import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "13\n" +
            "but\n" +
            "i\n" +
            "wont\n" +
            "hesitate\n" +
            "no\n" +
            "more\n" +
            "no\n" +
            "more\n" +
            "it\n" +
            "cannot\n" +
            "wait\n" +
            "im\n" +
            "yours";

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        int N = Integer.parseInt(input.readLine());

        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String temp = input.readLine();
            if (!words.contains(temp)) {
                words.add(temp);
            }
        }

        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }else{
                    return o1.length() - o2.length();
                }
            }
        });
        for (int i = 0; i < words.size(); i++) {
            output.append(words.get(i) + "\n");
        }
        System.out.print(output);

    }
}
