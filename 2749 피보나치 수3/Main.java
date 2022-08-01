import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {
    static BufferedReader input;
    static String src = "999999999999999999";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        // 1500000 마다 반복되는 주기

        int[] dp = new int[1500002];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 0; i < 1500000; i++) {
            dp[i + 2] = (dp[i + 1] + dp[i]) % 1000000;
        }
        long N = Long.parseLong(input.readLine());
        System.out.println(dp[(int) (N % 1500000)]);
    }
}
