import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "3";


    static int N;
    static int dp[][];

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        //input = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(input.readLine());
        // N : 1~1000
        dp = new int[1001][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            next(i);
        }


//        for (int i = 1; i <= N; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer + dp[N][i]) % 10007;
        }
        System.out.println(answer);
    }

    public static void next(int row) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[row - 1][i]) % 10007;
        }
        dp[row][0] = 1;
        for (int i = 1; i < 10; i++) {
            dp[row][i] = (dp[row][i - 1] + dp[row - 1][i]) % 10007;
        }

    }


}
