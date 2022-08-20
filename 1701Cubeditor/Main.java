import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "abcdabcabb";
    static String inputStr;
    static int pi[];

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        inputStr = input.readLine();
        pi = new int[inputStr.length()];
        // 어떤 문자열 내에 부분 문자열이 2번 이상 나오는 문자열 중 가장 길이가 긴 길이
        int max = 0;
        for (int i = 0; i < inputStr.length(); i++) {
            max = Math.max(max, getMax(inputStr.substring(i, inputStr.length())));
        }
        System.out.println(max);
    }

    public static int getMax(String s) {
        int j = 0;
        int max = 0;
        int pi[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                pi[i] = ++j;
                max = Math.max(pi[i], max);
            }
        }
        return max;
    }

}
