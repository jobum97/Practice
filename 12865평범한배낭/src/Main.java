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

    static int N, K;

    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());


        int Weight[] = new int[N + 1];
        int Value[] = new int[N + 1];
        int dp[] = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            str = new StringTokenizer(input.readLine());
            Weight[i] = Integer.parseInt(str.nextToken()); //무게
            Value[i] = Integer.parseInt(str.nextToken()); //가치
        }

        for (int i = 1; i <= N; i++) {

            for (int j = K; j - Weight[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - Weight[i]] + Value[i]);
            }
        }

        //System.out.println(Arrays.toString(dp));
        System.out.println(dp[K]);
    }
}
