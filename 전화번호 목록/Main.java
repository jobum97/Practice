import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "2\n" +
            "3\n" +
            "911\n" +
            "97625999\n" +
            "91125426\n" +
            "5\n" +
            "113\n" +
            "12340\n" +
            "123440\n" +
            "12345\n" +
            "98346";

    static int testCase, n;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        testCase = Integer.parseInt(input.readLine());

        for (int t = 1; t <= testCase; t++) {
            n = Integer.parseInt(input.readLine());

            //한 번호가 다른 번호의 접두어인 경우 없으면 YES, 있으면 NO

            ArrayList<String> strList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                strList.add(input.readLine());
            }

            strList.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });

            boolean isConsistent = true;
            for (int shortStr = 0; shortStr < strList.size(); shortStr++) {
                for (int longStr = shortStr + 1; longStr < strList.size(); longStr++) {

                    boolean isPrefix = true;
                    String sStr = strList.get(shortStr);
                    String lStr = strList.get(longStr);

                    if (sStr.length() == lStr.length()) {
                        continue;
                    }

                    for (int strIdx = 0; strIdx < strList.get(shortStr).length(); strIdx++) {
                        if(sStr.charAt(strIdx) != lStr.charAt(strIdx)){
                            isPrefix = false;
                            break;
                        }
                    }

                    if (isPrefix) {
                        isConsistent = false;
                        break;
                    }
                }
                if (!isConsistent) {
                    break;
                }
            }

            if (isConsistent) {
                output.append("YES").append("\n");
            }else{
                output.append("NO").append("\n");
            }
        }
        System.out.print(output);
    }
}
