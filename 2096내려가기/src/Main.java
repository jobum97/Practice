import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
        static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        static StringBuilder output = new StringBuilder();
        static String src = "3\n" +
                "0 0 0\n" +
                "0 0 0\n" +
                "0 0 0";

        public static void main(String[] args) throws IOException {
            input = new BufferedReader(new InputStreamReader(System.in));
            //input = new BufferedReader(new StringReader(src));

            int N = Integer.parseInt(input.readLine());

            int dp[][][] = new int[N][3][2];
            int temp = 0;
            StringTokenizer str = new StringTokenizer(input.readLine());
            for (int i = 0; i < 3; i++) {
                temp = Integer.parseInt(str.nextToken());
                dp[0][i][0] = temp;
                dp[0][i][1] = temp;
            }

            for (int i = 1; i < N; i++) {
                str = new StringTokenizer(input.readLine());
                for (int j = 0; j < 3; j++) {
                    temp = Integer.parseInt(str.nextToken());
                    if (j == 0) {
                        dp[i][0][0] = Math.max(temp + dp[i - 1][0][0], temp + dp[i - 1][1][0]);
                        dp[i][0][1] = Math.min(temp + dp[i - 1][0][1], temp + dp[i - 1][1][1]);
                    } else if (j == 1) {
                        dp[i][1][0] = Math.max(temp + dp[i - 1][0][0], temp + dp[i - 1][1][0]);
                        dp[i][1][0] = Math.max(dp[i][1][0], temp + dp[i - 1][2][0]);

                        dp[i][1][1] = Math.min(temp + dp[i - 1][0][1], temp + dp[i - 1][1][1]);
                        dp[i][1][1] = Math.min(dp[i][1][1], temp + dp[i - 1][2][1]);
                    } else {
                        dp[i][2][0] = Math.max(temp + dp[i - 1][1][0], temp + dp[i - 1][2][0]);
                        dp[i][2][1] = Math.min(temp + dp[i - 1][1][1], temp + dp[i - 1][2][1]);
                    }
                }
            }

            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                max = Math.max(max, dp[N - 1][i][0]);
                min = Math.min(min, dp[N - 1][i][1]);
            }

            System.out.println(max + " " + min);

        }
    }

