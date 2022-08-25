import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "BBCBB";

    static int dp[], N;
    static String str;
    static boolean palindrome[][];

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        str = input.readLine();
        N = str.length();
        palindrome = new boolean[N + 1][N + 1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        checkPalindrome();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                // j~i가 회문이면 앞부분+1 과 비교해서 최솟값 dp에 저장
                if (palindrome[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        System.out.println(dp[N]);
    }

    // 회문인지 모든 경우 미리 체크해둠
    public static void checkPalindrome() {
        for (int start = 1; start <= N; start++) {
            for (int end = start; end <= N; end++) {
                boolean flag = true;

                int s = start - 1;
                int e = end - 1;
                while (s <= e) {
                    if (str.charAt(s++) != str.charAt(e--)) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    palindrome[start][end] = true;
            }
        }
    }
}
