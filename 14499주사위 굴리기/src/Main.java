import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder output;
    static BufferedReader input;
    static String src = "4 2 0 0 8\n" +
            "0 2\n" +
            "3 4\n" +
            "5 6\n" +
            "7 8\n" +
            "4 4 4 1 3 3 3 2";

    static int N, M, row, col, K, map[][], Dice[];
    //동서북남
    static int moveSet[][] = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        output = new StringBuilder();

        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken()); // 맵 사이즈 N * M
        M = Integer.parseInt(str.nextToken());
        row = Integer.parseInt(str.nextToken()); // 현재 위치 row, col
        col = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken()); // 명령 개수

        map = new int[N][M];
        Dice = new int[6];

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        // 명령 수행
        str = new StringTokenizer(input.readLine());
        for (int i = 0; i < K; i++) {
            int order = Integer.parseInt(str.nextToken());

            int nextRow = row + moveSet[order][0];
            int nextCol = col + moveSet[order][1];

            // 맵 나가면 무시
            if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) {
                continue;
            }

            row = nextRow;
            col = nextCol;

            rollDice(order);

            // 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다
            if (map[row][col] == 0) {
                map[row][col] = Dice[5];

            } else {
                // 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
                Dice[5] = map[row][col];
                map[row][col] = 0;
            }

            //System.out.println(Arrays.toString(Dice));

            //주사위 상단에 있는 숫자 출력
            output.append(Dice[0] + "\n");
        }

        System.out.print(output);
    }

    public static void rollDice(int order) {

        int temp = 0;
        //동쪽
        if (order == 1) {

            swapDice(1, 0, 2, 5);

        }//서쪽
        else if (order == 2) {

            swapDice(2, 0, 1, 5);

        }//북쪽
        else if (order == 3) {

            swapDice(5, 4, 0, 3);

        }//남쪽
        else if (order == 4) {

            swapDice(3, 0, 4, 5);
        }
    }

    // i -> j ->k -> t-> i
    public static void swapDice(int i, int j, int k, int t) {
        int temp = Dice[k];

        Dice[k] = Dice[j];
        Dice[j] = Dice[i];
        Dice[i] = Dice[t];
        Dice[t] = temp;
    }

}
