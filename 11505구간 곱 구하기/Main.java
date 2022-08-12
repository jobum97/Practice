import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "5 2 2\n" +
            "1\n" +
            "2\n" +
            "3\n" +
            "4\n" +
            "5\n" +
            "1 3 0\n" +
            "2 2 5\n" +
            "1 3 6\n" +
            "2 2 5";

    static int N, M, K, INF = 1000000007,data[];
    static long dp[][];


    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        data = new int[N + 1];
        dp = new long[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            data[i] = Integer.parseInt(input.readLine());
            dp[i][i] = data[i];
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                dp[i][j] = (dp[i][j - 1] * data[j]) % INF;
            }
        }

        for (int i = 0; i < M + K; i++) {
            str = new StringTokenizer(input.readLine());
            int order = Integer.parseInt(str.nextToken());
            int origin = Integer.parseInt(str.nextToken());
            int update = Integer.parseInt(str.nextToken());
           // printDp();
            if (order == 1) {
                swap(origin, update);
            } else if (order == 2) {
                output.append(dp[origin][update]).append("\n");
            }
        }
        System.out.print(output);

    }

    public static void printDp(){
        for (int i = 1; i <= N; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }

    public static void swap(int origin, int update){
        data[origin] = update;
        dp[origin][origin] = update;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                dp[i][j] = (dp[i][j - 1] * data[j]) % INF;
            }
        }
    }

}
