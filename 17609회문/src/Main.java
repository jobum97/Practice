import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "7\n" +
            "abba\n" +
            "summuus\n" +
            "xabba\n" +
            "xabbay\n" +
            "comcom\n" +
            "comwwmoc\n" +
            "comwwtmoc";

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        int testcase = Integer.parseInt(input.readLine());

        for (int i = 0; i < testcase; i++) {
            String str = input.readLine();
            output.append(isCircular(str) + "\n");
        }
        System.out.print(output);

    }



    public static int isCircular(String input) {

        //System.out.println("---------" + input + "-----------");
        int length = input.length();
        char strings[] = input.toCharArray();
        int left = 0;
        int right = length - 1;
        int miss = 0;

        while (left <= right) {
            if (strings[left] == strings[right]) {
                left++;
                right--;
            } else {
                miss = 1;
                //틀렸을 때 왼쪽 문자 무시하는 경우
                int l = left + 1;
                int r = right;
                while (l <= r) {
                    if (strings[l] != strings[r]) {
                        miss++;
                        break;
                    }
                    l++;
                    r--;
                }

                //오른쪽 문자 무시하는 경우
                l = left;
                r = right - 1;
                while (l <= r) {
                    if (strings[l] != strings[r]) {
                        miss++;
                        break;
                    }
                    l++;
                    r--;
                }

                //왼쪽 문자 무시해도 안되고 오른쪽 문자 무시해도 안되면 3
                // 둘중 하나는 가능하면 2 => 유사회문
                if (miss >= 2) {
                    return miss - 1;
                } else {
                    return miss;
                }
            }
        }
        //다 통과 => 회문, 리턴 0
        return miss;
    }

}
