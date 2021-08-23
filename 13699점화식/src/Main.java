import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "25";

    static int N;

    public static void main(String arg[]) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(input.readLine());

        long temp;
        long[] dp = new long[N + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            temp = 0;
            for (int j = 0; j < i; j++) {
                temp += dp[j] * dp[i - 1 - j];
            }
            dp[i] = temp;
        }

        //System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
    }
}