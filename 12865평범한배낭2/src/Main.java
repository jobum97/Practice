import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4 7\n" +
            "6 13\n" +
            "4 8\n" +
            "3 6\n" +
            "5 12";

    static int N, K, data[][], maxValue, dp[][];

    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        data = new int[N + 1][2];
        dp = new int[K + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            str = new StringTokenizer(input.readLine());
            data[i][0] = Integer.parseInt(str.nextToken()); //무게
            data[i][1] = Integer.parseInt(str.nextToken()); //가치
        }

        for (int c = 1; c <= N; c++) {
            for (int r = 1; r <= K; r++) {
                if (data[c][0] > r) {
                    dp[r][c] = dp[r][c - 1];
                } else {
                    dp[r][c] = Math.max(dp[r][c - 1], dp[r - data[c][0]][c - 1] + data[c][1]);
                }
            }
        }

//        for (int i = 1; i <= K; i++) {
//            System.out.println(i + " " + Arrays.toString(dp[i]));
//        }

        System.out.println(dp[K][N]);
    }
}
