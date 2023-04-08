import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;


public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();

    static String src = "6 10\n" +
            "0 1 2 0 1 1\n" +
            "1 2 0 1 1 0\n" +
            "2 1 0 1 1 0\n" +
            "1 0 1 1 0 2\n" +
            "2 0 1 2 0 1\n" +
            "0 2 1 0 2 1\n" +
            "1 1 1\n" +
            "2 2 2\n" +
            "3 3 4\n" +
            "4 4 1\n" +
            "5 5 3\n" +
            "6 6 2\n" +
            "1 6 3\n" +
            "6 1 2\n" +
            "2 4 3\n" +
            "4 2 1";
    static int N, K, map[][];
    static ArrayList<Integer> horseInfo[][];
    static final int WHITE = 0, RED = 1, BLUE = 2;
    static final int moveSet[][] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static final int change[] = {1, 0, 3, 2};

    public static void main(String args[]) throws IOException {
        //input=new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());


        // 맵 초기화
        map = new int[N][N];
        horseInfo = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
                horseInfo[i][j] = new ArrayList<>();
            }
        }

        Horse horses[] = new Horse[K+1];
        for (int i = 1; i <= K; i++) {
            str = new StringTokenizer(input.readLine());
            int row = Integer.parseInt(str.nextToken()) - 1;
            int col = Integer.parseInt(str.nextToken()) - 1;
            int dir = Integer.parseInt(str.nextToken()) - 1;
            horses[i] = new Horse(dir, row, col);
            horseInfo[row][col].add(i);
        }
        // 1~K 순서대로 이동, 중첩되면 가장 아래에있는 말 기준으로 같이 이동
        // 말이 4개 중첩되면 게임 종료

        // 횐색(0) 일경우 일반적인 이동
        // 빨간색(1) 일경우 이동하는 말들 순서 역순하고 쌓음
        // 파란색(2) 일경우 이동방향 반대로하고 한칸 이동, 이동하려고하는칸 파란색이면 이동은 X
        // 나가려고할때와 동일

        int turn = 0;
        boolean isFinished = false;
        while (turn <= 1000 && !isFinished) {
            for (int i = 1; i <= K; i++) {
                Horse curHorse = horses[i];
                int curRow = curHorse.row;
                int curCol = curHorse.col;
                // 가장 아래쪽 말이 아니라면 Pass
                if (horseInfo[curHorse.row][curHorse.col].get(0) != i) {
                    continue;
                }
                int nextRow = curRow + moveSet[curHorse.dir][0];
                int nextCol = curCol + moveSet[curHorse.dir][1];

                // 나가려고하거나 파란색인 경우
                if (!isInMap(nextRow, nextCol) || map[nextRow][nextCol] == BLUE) {
                    curHorse.dir = change[curHorse.dir];
                    nextRow = curRow + moveSet[curHorse.dir][0];
                    nextCol = curCol + moveSet[curHorse.dir][1];
                }

                if (!isInMap(nextRow, nextCol) || map[nextRow][nextCol] == BLUE) {
                    continue;
                } else if (map[nextRow][nextCol] == RED) {
                    for (int j = horseInfo[curRow][curCol].size() - 1; j >= 0; j--) {
                        int temp = horseInfo[curRow][curCol].get(j);
                        horseInfo[nextRow][nextCol].add(temp);
                        horses[temp].row = nextRow;
                        horses[temp].col = nextCol;
                    }
                    horseInfo[curRow][curCol].clear();
                } else {
                    for (int j = 0; j < horseInfo[curRow][curCol].size(); j++) {
                        int temp = horseInfo[curRow][curCol].get(j);
                        horseInfo[nextRow][nextCol].add(temp);
                        horses[temp].row = nextRow;
                        horses[temp].col = nextCol;
                    }
                    horseInfo[curRow][curCol].clear();
                }

                if (horseInfo[nextRow][nextCol].size() >= 4) {
                    isFinished = true;
                    break;
                }
            }

            turn++;
        }

        if (turn > 1000) {
            System.out.println(-1);
        } else {
            System.out.println(turn);
        }
    }

    public static boolean isInMap(int row, int col) {
        if (row < 0 || col < 0 || row >= N || col >= N) {
            return false;
        }
        return true;
    }

    private static class Horse {
        int dir;
        int row;
        int col;

        public Horse(int dir, int row, int col) {
            this.dir = dir;
            this.row = row;
            this.col = col;
        }
    }
}

