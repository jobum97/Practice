import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static String src = "4 2\n" +
            "1 1 1 1";

    static int[] data, dp;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        data = new int[N + 1];
        dp = new int[N + 1];
        str = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            data[i] = Integer.parseInt(str.nextToken());
            dp[i] = data[i] + dp[i - 1];
        }

        int count = 0;

        for (int i = 1; i <= N; i++) {
            // 누적합이 M보다 클때만
            if (dp[i] >= M) {
                for (int j = 0; j < i; j++) {
                    int temp = dp[i] - dp[j];
                    //System.out.println(dp[i] + " " + dp[j]);
                    if (temp < M) {
                        break;
                    } else if (temp == M) {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
