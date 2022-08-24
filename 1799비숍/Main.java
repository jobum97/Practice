import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "5\n" +
            "1 1 0 1 1\n" +
            "0 1 0 0 0\n" +
            "1 0 1 0 1\n" +
            "1 0 0 0 0\n" +
            "1 0 1 1 1";

    static int N, map[][], Max, ans[];
    static boolean w[],b[];

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        N = Integer.parseInt(input.readLine());

        map = new int[N][N];
        ans = new int[2];
        w = new boolean[N * 2];
        b = new boolean[N * 2];
        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        Max = 0;
        backTracking(0, 0, 0);
        backTracking(0, 1, 0);

        System.out.println(ans[0] + ans[1]);
    }

    public static void backTracking(int row, int col, int cnt) {
        // 한줄 끝났을 때 줄내림 처리
        if (col >= N) {
            row++;
            // 끝이 짝수면 다음엔 홀수여야, 끝이 홀수면 다음이 짝수여야
            if (col % 2 == 0) {
                col = 1;
            }else{
                col = 0;
            }
        }

        // 끝났을 때 최대치 갱신
        if (row >= N) {
            ans[col % 2] = Math.max(ans[col % 2], cnt);
            return;
        }

        if (map[row][col] == 1 && !w[col - row + N - 1] && !b[row + col]) {
            w[col - row + N - 1] = b[row + col] = true;
            backTracking(row, col + 2, cnt + 1);
            w[col - row + N - 1] = b[row + col] = false;
        }
        backTracking(row, col + 2, cnt);
    }
}
