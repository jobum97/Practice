import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder output;
    static BufferedReader input;
    static String src = "4 5\n" +
            "50 45 37 32 30\n" +
            "35 50 40 20 25\n" +
            "30 30 25 17 28\n" +
            "27 24 22 15 10";

    static int N, M, map[][], dp[][], result;


    //동서북남
    static int moveSet[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        output = new StringBuilder();

        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken()); // 맵 사이즈 N * M
        M = Integer.parseInt(str.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(DFS(0, 0));
    }

    public static int DFS(int row, int col) {
        //System.out.println(row + " " + col);
        // 끝 부분 도달
        if (row == N - 1 && col == M - 1) {
            return 1;
        }

        // -1이 아니면 이미 방문했던 곳
        if (dp[row][col] != -1) {
            return dp[row][col];
        } else {
            dp[row][col] = 0;
            for (int i = 0; i < 4; i++) {
                int nextRow = row + moveSet[i][0];
                int nextCol = col + moveSet[i][1];

                if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) {
                    continue;
                }
                //내리막길이면
                if (map[row][col] > map[nextRow][nextCol]) {
                    dp[row][col] += DFS(nextRow, nextCol);
                }
            }
        }

        return dp[row][col];
    }
}
