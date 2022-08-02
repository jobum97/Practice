import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "2\n" +
            "4\n" +
            "40 30 30 50\n" +
            "15\n" +
            "1 21 3 4 5 35 5 4 3 5 98 21 14 17 32";

    static int T, K;
    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        T = Integer.parseInt(input.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {
            K = Integer.parseInt(input.readLine());
            int[] data = new int[K + 1];
            int[] sum = new int[K + 1];
            StringTokenizer str = new StringTokenizer(input.readLine());
            for (int i = 1; i <= K; i++) {
                data[i] = Integer.parseInt(str.nextToken());
                sum[i] = sum[i - 1] + data[i];
            }


            int[][] dp = new int[K + 2][K + 2];

            //풀이
            for (int col = 1; col <= K; col++) {
                for (int row = 1; row + col <= K; row++) {
                    dp[row][row + col] = Integer.MAX_VALUE;
                    for (int mid = row; mid < col+row; mid++) {
                        dp[row][row + col] = Math.min(dp[row][row + col], dp[row][mid] + dp[mid + 1][row + col] + sum[row + col] - sum[row - 1]);
                    }
                }
            }

            output.append(dp[1][K]).append("\n");
        }
        System.out.print(output);
    }
}
