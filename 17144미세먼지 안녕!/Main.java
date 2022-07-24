import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static String src = "7 8 50\n" +
            "0 0 0 0 0 0 0 9\n" +
            "0 0 0 0 3 0 0 8\n" +
            "-1 0 5 0 0 0 22 0\n" +
            "-1 8 0 0 0 0 0 0\n" +
            "0 0 0 0 0 10 43 0\n" +
            "0 0 5 0 15 0 0 0\n" +
            "0 0 40 0 0 0 20 0";

    static int R, C, T, map[][], cleanerRow1, cleanerRow2;
    static Queue<Diffusion> queue = new LinkedList<>();
    static int moveSet[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        R = Integer.parseInt(str.nextToken());
        C = Integer.parseInt(str.nextToken());
        T = Integer.parseInt(str.nextToken());

        map = new int[R + 1][C + 1];

        boolean isFirst = true;

        for (int i = 1; i <= R; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 1; j <= C; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
                if (map[i][j] == -1) {
                    if (isFirst) {
                        cleanerRow1 = i;
                        isFirst = false;
                    }else{
                        cleanerRow2 = i;
                    }
                }
            }
        }

        int time = 0;
        while (true) {

            if (time == T) {
                break;
            }
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (map[i][j] > 0) {
                        dustDiffusion(i, j);
                    }
                }
            }
            diffusion();
            //showMap();
            windFlow1();
            windFlow2();
            //showMap();
            time++;
        }

        System.out.println(countDust());
    }

    public static int countDust(){
        int dust = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (map[i][j] > 0) {
                    dust += map[i][j];
                }
            }
        }
        return dust;
    }

    public static void showMap(){
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                System.out.print(map[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println("==========================");
    }

    // 반시계방향
    public static void windFlow1(){
        int leftUp = map[1][1];
        int rightUp = map[1][C];
        int rightDown = map[cleanerRow1][C];

        for (int i = C; i >= 3; i--) {
            map[cleanerRow1][i] = map[cleanerRow1][i - 1];
        }
        map[cleanerRow1][2] = 0;

        //showMap();

        for (int i = 1; i <= cleanerRow1 - 2; i++) {
            map[i][C] = map[i + 1][C];
        }
        map[cleanerRow1 - 1][C] = rightDown;

        //showMap();

        for (int i = 1; i <= C - 2; i++) {
            map[1][i] = map[1][i + 1];
        }
        map[1][C - 1] = rightUp;

        //showMap();

        for (int i = cleanerRow1 - 1; i > 2; i--) {
            map[i][1] = map[i - 1][1];
        }
        map[2][1] = leftUp;

    }

    // 시계방향
    public static void windFlow2(){
        int leftDown = map[R][1];
        int rightUp = map[cleanerRow2][C];
        int rightDown = map[R][C];

        for (int i = C; i >= 3; i--) {
            map[cleanerRow2][i] = map[cleanerRow2][i - 1];
        }
        map[cleanerRow2][2] = 0;

//        showMap();

        for (int i = R; i >= cleanerRow2 + 2; i--) {
            map[i][C] = map[i - 1][C];
        }
        map[cleanerRow2 + 1][C] = rightUp;

//        showMap();

        for (int i = 1; i <= C - 2; i++) {
            map[R][i] = map[R][i + 1];
        }
        map[R][C - 1] = rightDown;

//        showMap();

        for (int i = cleanerRow2 + 1; i < R; i++) {
            map[i][1] = map[i + 1][1];
        }
        map[R-1][1] = leftDown;

    }

    public static void dustDiffusion(int row, int col) {

        int diffusionDust = map[row][col] / 5;
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + moveSet[i][0];
            int nextCol = col + moveSet[i][1];

            // 칸이 없는 경우
            if (nextRow <= 0 | nextCol <= 0 | nextRow > R | nextCol > C) {
                continue;
            }

            // 공기청정기 있는 경우
            if (map[nextRow][nextCol] == -1) {
                continue;
            }

            queue.add(new Diffusion(nextRow, nextCol, diffusionDust));
            count++;
        }

        queue.add(new Diffusion(row, col, -diffusionDust * count));
    }

    public static void diffusion() {
        while (!queue.isEmpty()) {
            Diffusion diffusion = queue.poll();
            map[diffusion.row][diffusion.col] += diffusion.dust;
        }
    }

    public static class Diffusion {
        int row;
        int col;
        int dust;

        public Diffusion(int row, int col, int dust) {
            this.row = row;
            this.col = col;
            this.dust = dust;
        }
    }
}
