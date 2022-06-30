import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuffer output = new StringBuffer();
    static String src = "10\n" +
            "1 5 2 1 4 3 4 5 2 1";

    public static void main(String[] args) throws IOException {
//        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());
        StringTokenizer str = new StringTokenizer(input.readLine());

        int[] data = new int[N];

        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(str.nextToken());
        }

        int[] r_dp = new int[N], l_dp = new int[N];

        LIS(r_dp, data, N);
        LDS(l_dp, data, N);
//        System.out.println(Arrays.toString(r_dp));
//        System.out.println(Arrays.toString(l_dp));
        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, r_dp[i] + l_dp[i]);
        }

        System.out.println(result - 1);
    }

    public static void LIS(int[] dp, int[] data, int N) {

        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int tempMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (data[i] > data[j]) {
                    tempMax = Math.max(dp[j], tempMax);
                }
            }
            dp[i] = tempMax + 1;
        }
    }

    public static void LDS(int[] dp, int[] data, int N) {

        dp[N - 1] = 1;
        for (int i = N - 1; i >= 0; i--) {
            int tempMax = 0;
            for (int j = i + 1; j < N; j++) {
                if (data[i] > data[j]) {
                    tempMax = Math.max(dp[j], tempMax);
                }
            }
            dp[i] = tempMax + 1;
        }
    }
}
