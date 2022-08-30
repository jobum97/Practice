import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "4 5\n" +
            "1 2 3 4 2\n" +
            "1 2 3 4 5\n" +
            "1 2 3 7 5\n" +
            "1 2 3 4 5";

    static int N, M, scoreBoard[][], ans, moveSet[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static boolean checked[][];


    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        scoreBoard = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 1; j <= M; j++) {
                scoreBoard[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        checked = new boolean[N + 1][M + 1];
        ans = 0;

        // 테트로미노 5가지를 회전이나 대칭을 시킬 수 있으면 => 인접한 4개의 칸을 선택하는 모든 경우 => dfs + ㅗ 모양 케이스 처리
        // 맵에서 인접한 4개의 칸을 선택했을 때 합의 최댓값??
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                checked[i][j] = true;
                dfs(i, j, scoreBoard[i][j], 1);
                checked[i][j] = false;
                check(i, j);
            }
        }

        System.out.println(ans);
    }

    public static void dfs(int row, int col, int sum, int depth) {
        if (depth == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = row + moveSet[i][0];
            int nextCol = col + moveSet[i][1];

            if (nextRow <= 0 || nextCol <= 0 || nextRow > N | nextCol > M) {
                continue;
            }

            if (!checked[nextRow][nextCol]) {
                checked[nextRow][nextCol] = true;
                dfs(nextRow, nextCol, sum + scoreBoard[nextRow][nextCol], depth + 1);
                checked[nextRow][nextCol] = false;
            }
        }
    }

    static void check(int y, int x) {
        if (y < N - 1 && x < M)
            ans = Math.max(ans, scoreBoard[y][x] + scoreBoard[y + 1][x] + scoreBoard[y + 2][x] + scoreBoard[y + 1][x + 1]);

        if (y < N - 1 && x > 1)
            ans = Math.max(ans, scoreBoard[y][x] + scoreBoard[y + 1][x] + scoreBoard[y + 2][x] + scoreBoard[y + 1][x - 1]);

        if (y < N && x < M - 1)
            ans = Math.max(ans, scoreBoard[y][x] + scoreBoard[y][x + 1] + scoreBoard[y][x + 2] + scoreBoard[y + 1][x + 1]);

        if (y > 1 && x < M - 1)
            ans = Math.max(ans, scoreBoard[y][x] + scoreBoard[y][x + 1] + scoreBoard[y][x + 2] + scoreBoard[y - 1][x + 1]);
    }




}
