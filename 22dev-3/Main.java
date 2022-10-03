import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println(solution(50));
    }

    static int count = 0;
    static int[] dp;
    public static long solution(int k) {
        long answer = -1;

        int possible[] = new int[8];
        possible[2] = 1;
        possible[3] = 1;
        possible[4] = 1;
        possible[5] = 3;
        possible[6] = 3;
        possible[7] = 1;

        long dp[] = new long[51];

        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 5;
        dp[6] = 7;


        for (int i = 2; i < dp.length; i++) {
            for (int j = 2; j < 8; j++) {
                if (i + j < dp.length) {
                    dp[i + j] += dp[i] * possible[j];
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return answer;
    }

}
