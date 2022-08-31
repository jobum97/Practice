import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "5 10\n" +
            "##########\n" +
            "#.#......#\n" +
            "##.......#\n" +
            "#OR..B.#.#\n" +
            "##########";

    static int N, M, red_row, red_col, blue_row, blue_col, hole_row, hole_col, ans;
    static int[][] moveSet = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 동서남북
    static boolean map[][], isValid, checked[][][][][];

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        map = new boolean[N][M];
        checked = new boolean[N][M][N][M][4];
        ans = Integer.MAX_VALUE;
        isValid = false;

        for (int i = 0; i < N; i++) {
            String line = input.readLine();
            for (int j = 0; j < M; j++) {
                switch (line.charAt(j)) {
                    case '#':
                        break;
                    case '.':
                        map[i][j] = true;
                        break;
                    case 'B':
                        blue_row = i;
                        blue_col = j;
                        map[i][j] = true;
                        break;
                    case 'R':
                        map[i][j] = true;
                        red_row = i;
                        red_col = j;
                        break;
                    case 'O':
                        map[i][j] = true;
                        hole_row = i;
                        hole_col = j;
                        break;
                }

            }
        }
        sol();
    }

    public static void sol(){
        // 파란 구슬은 구멍에 넣지 않으면서 빨간 구슬을 넣는 것이 목표
        // 상하좌우로 기울이기 => 빨간, 파란 구슬 둘다 영향 받음
        // 빨간, 파란 구슬, 구멍 모두 한개씩만 존재

        dfs(red_row, red_col, blue_row, blue_col, 1);

        if (isValid) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }

    public static void dfs(int red_row, int red_col, int blue_row, int blue_col, int depth) {
        if (depth > 10) {
            return;
        }
        System.out.println(red_row + " " + red_col + " " + blue_row + " " + blue_col + " " + depth);
        for (int i = 0; i < 4; i++) {
            // 기울였을 때의 시뮬레이션

            // 했던 상황은 건너뛴다
            if (checked[red_row][red_col][blue_row][blue_col][i]) {
                continue;
            }

            // 파란 구슬이 구멍에 들어가는 경우 return
            int next_blue_row = blue_row;
            int next_blue_col = blue_col;
            int next_red_row = red_row;
            int next_red_col = red_col;

            boolean is_red_holeIn = false;
            boolean is_blue_holeIn = false;

            System.out.println(red_row + " " + red_col + " " + blue_row + " " + blue_col + " " + depth + " 방향:" + i);
            // 둘 중 하나라도 움직일 여지가 있다면
            while (isValidCoord(next_blue_row + moveSet[i][0], next_blue_col + moveSet[i][1]) &&
                    isValidCoord(next_red_row + moveSet[i][0], next_red_col + moveSet[i][1]) &&
                    (map[next_blue_row + moveSet[i][0]][next_blue_col + moveSet[i][1]] || map[next_red_row + moveSet[i][0]][next_red_col + moveSet[i][1]])) {
                System.out.println(next_red_row + " " + next_red_col + " " + next_blue_row + " " + next_blue_col + " " + depth + " 방향:" + i);
                // 갈 수 있는 공간이어야하고 + 파란 공과 빨간 공의 위치가 겹치지 않아야함
                // 한칸씩 움직일때 둘다 움직일 수 있는대로 움직엿는데 겹치면 롤백해야
                boolean is_blue_moved = false;
                boolean is_red_moved = false;
                if (map[next_blue_row + moveSet[i][0]][next_blue_col + moveSet[i][1]]) {
                    next_blue_row += moveSet[i][0];
                    next_blue_col += moveSet[i][1];
                    is_blue_moved = true;
                }
                if (map[next_red_row + moveSet[i][0]][next_red_col + moveSet[i][1]]) {
                    next_red_row += moveSet[i][0];
                    next_red_col += moveSet[i][1];
                    is_red_moved = true;
                }

                // 둘이 겹치면 롤백 하고 마지막 상태로 나감 (홀이 아닌 경우에만)
                if (next_red_row == next_blue_row && next_red_col == next_blue_col && !(next_red_row == hole_row && next_red_col == hole_col)) {
                    if (is_blue_moved) {
                        next_blue_row -= moveSet[i][0];
                        next_blue_col -= moveSet[i][1];
                    }
                    if (is_red_moved) {
                        next_red_row -= moveSet[i][0];
                        next_red_col -= moveSet[i][1];
                    }
                    System.out.println("멈춰");
                    break;
                }

                // 파란 공이 홀에 빠지는 경우
                if (next_blue_row == hole_row && next_blue_col == hole_col) {
                    is_blue_holeIn = true;
                }
                //System.out.println(next_red_row + " " + next_red_col + " " + hole_row + " " + hole_col);
                // 빨간 공이 홀에 빠지는 경우
                if (next_red_row == hole_row && next_red_col == hole_col) {
                    is_red_holeIn = true;
                }
            }

            // 빨간 공만 홀인 해야 인정 나머지 케이스는 무효
            if (is_red_holeIn && !is_blue_holeIn){
                ans = Math.min(ans, depth);
                isValid = true;
                return;
            } else if (is_red_holeIn || is_blue_holeIn){
                continue;
            }

            //움직였다면
            if (!(red_row == next_red_row && red_col == next_red_col && blue_row == next_blue_row && blue_col == next_blue_col)) {
                checked[red_row][red_col][blue_row][blue_col][i] = true;
                dfs(next_red_row, next_red_col, next_blue_row, next_blue_col, depth + 1);
                checked[red_row][red_col][blue_row][blue_col][i] = false;
            }
        }
    }

    public static boolean isValidCoord(int row, int col){
        if (row < 0 || col < 0 || row >= N || col >= M) {
            return false;
        }else{
            return true;
        }
    }

}
