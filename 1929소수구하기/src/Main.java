import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "3 16";

    static int N, M;
    static boolean dp[];
    public static void main(String arg[]) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        M = Integer.parseInt(str.nextToken());
        N = Integer.parseInt(str.nextToken());

        dp = new boolean[N + 1];
        dp[1] = true;
        for (int i = 2; i <= N / 2; i++) {
            for (int j = 2; j <= N / i; j++) {
                dp[i * j] = true;
            }
        }

        for (int i = M; i <= N; i++) {
            if (!dp[i]) {
                output.append(i + "\n");
            }
        }

        System.out.println(output);
    }
}
