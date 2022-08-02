import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "3\n" +
            "5 3\n" +
            "3 2\n" +
            "2 6";

    static int N, r, c, arr[][], dp[][];
    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        //풀이
        N = Integer.parseInt(input.readLine());
        arr = new int[N + 1][2];
        dp = new int[N + 2][N + 2];
        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(input.readLine());
            arr[i + 1][0] = Integer.parseInt(str.nextToken());
            arr[i + 1][1] = Integer.parseInt(str.nextToken());
        }

        // dp row ~ col 까지의 행렬을 곱했을 때 최소 곱셈 연산 횟수


        for (int col = 1; col < N; col++) {
            for (int row = 1; col + row <= N; row++) {
                dp[row][col + row] = Integer.MAX_VALUE;
                for (int mid = row; mid <= col + row; mid++) {
                    dp[row][col + row]  = Math.min(dp[row][col + row], dp[row][mid] + dp[mid + 1][col + row] + cost(row, mid, col + row));
                }
            }
        }

        System.out.println(dp[1][N]);

    }

    public static int cost(int s, int mid, int e) {
        return arr[s][0] * arr[mid][1] * arr[e][1];
    }
}
