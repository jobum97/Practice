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

        data = new int[N][2];
        maxValue = 0;
        dp = new int[N + 1][K + 1];

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            data[i][0] = Integer.parseInt(str.nextToken()); //무게
            data[i][1] = Integer.parseInt(str.nextToken()); //가치
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {

            }
        }
        for (int i = 0; i <= K; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        //System.out.println(Arrays.toString(dp));
        System.out.println(maxValue);
    }
}
