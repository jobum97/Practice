import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "3\n" +
            "4\n" +
            "1 2\n" +
            "1 3\n" +
            "2 2\n" +
            "2 3\n" +
            "3\n" +
            "2 D\n" +
            "3 D\n" +
            "4 D";
    static int N, K, L, moveSet[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 동남서북
    static boolean apple[][], checked[][];
    static char timeTable[];

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        StringTokenizer str;
        N = Integer.parseInt(input.readLine());
        apple = new boolean[N + 1][N + 1];
        checked = new boolean[N + 1][N + 1];
        timeTable = new char[10001];

        K = Integer.parseInt(input.readLine());
        for (int i = 0; i < K; i++) {
            str = new StringTokenizer(input.readLine());
            int row = Integer.parseInt(str.nextToken());
            int col = Integer.parseInt(str.nextToken());
            apple[row][col] = true;
        }

        L = Integer.parseInt(input.readLine());
        for (int i = 0; i < L; i++) {
            str = new StringTokenizer(input.readLine());
            timeTable[Integer.parseInt(str.nextToken())] = str.nextToken().charAt(0);
        }

        sol();
    }
    public static void sol(){
        int snake_row = 1;
        int snake_col = 1;
        int snake_dir = 0; // 동쪽 보고있음
        checked[snake_row][snake_col] = true;

        Queue<Point> snake = new LinkedList<>();
        snake.add(new Point(snake_row, snake_col));

        int time = 0;
        while (snake_row > 0 && snake_col > 0 && snake_row <= N && snake_col <= N) {

            int next_snake_row = snake_row + moveSet[snake_dir][0];
            int next_snake_col = snake_col + moveSet[snake_dir][1];
            //System.out.println(time+" "+snake_row+" "+ snake_col+" "+snake_dir);

            // 맵밖으로 벗어나거나 자신의 몸통이면 부딪히는 시간 추가하고 종료
            if (next_snake_row <= 0 || next_snake_col <= 0 || next_snake_row > N || next_snake_col > N || checked[next_snake_row][next_snake_col]) {
                time++;
                break;
            }

            // 머리 나아가는 것 반영
            snake.add(new Point(next_snake_row, next_snake_col));
            checked[next_snake_row][next_snake_col] = true;

            // 다음 지점이 사과가 아니면 꼬리 줄어들음
            if (!apple[next_snake_row][next_snake_col]) {
                Point tail = snake.poll();
                checked[tail.row][tail.col] = false;
            }else{
                // 사과면 사과를 먹는다
                apple[next_snake_row][next_snake_col] = false;
            }

            snake_row = next_snake_row;
            snake_col = next_snake_col;

            time++;
            switch (timeTable[time]) {
                //오른쪽 회전이면 +1
                case 'D':
                    snake_dir++;
                    break;
                //왼쪽 회전이면 -1
                case 'L':
                    snake_dir--;
                    break;
            }
            snake_dir = (snake_dir + 4) % 4;
        }

        System.out.println(time);
    }

    public static class Point{
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
