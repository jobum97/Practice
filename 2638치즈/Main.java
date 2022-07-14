import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output;
    static String src = "8 9\n" +
            "0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 1 1 0 0 0 0\n" +
            "0 0 0 1 1 0 1 1 0\n" +
            "0 0 1 1 1 1 1 1 0\n" +
            "0 0 1 1 1 1 1 0 0\n" +
            "0 0 1 1 0 1 1 0 0\n" +
            "0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0";

    static int N, M, map[][];
    static boolean visited[][];
    static Queue<Coord> meltQueue;

    static int[][] moveSet = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        map = new int[N][M];

        meltQueue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        System.out.println(sol());
    }
    public static void bfs(){
        Queue<Coord> outAir = new LinkedList<>();
        outAir.add(new Coord(0, 0));
        while (!outAir.isEmpty()) {
            Coord cur = outAir.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + moveSet[i][0];
                int nextCol = cur.col + moveSet[i][1];

                if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) {
                    continue;
                }
                if (visited[nextRow][nextCol] || map[nextRow][nextCol] == 1) {
                    continue;
                }

                map[nextRow][nextCol] = 3;
                visited[nextRow][nextCol] = true;
                outAir.add(new Coord(nextRow, nextCol));
            }
        }
    }
    public static int sol(){

        int result = 0;
        while (true) {
            //showMap();
            visited = new boolean[N][M];
            bfs();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && isMelt(i, j)) {
                        meltQueue.add(new Coord(i, j));
                    }
                }
            }
            if (meltQueue.size() == 0) {
                break;
            }

            while (!meltQueue.isEmpty()) {
                Coord melt = meltQueue.poll();
                map[melt.row][melt.col] = 0;
            }

            result++;
        }
        //showMap();
        return result;
    }

    public static void showMap(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
    }

    public static class Coord{
        int row;
        int col;

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static boolean isMelt(int row, int col) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + moveSet[i][0];
            int nextCol = col + moveSet[i][1];

            if (map[nextRow][nextCol] == 3) {
                count += 1;
            }
        }

        if (count >= 2) {
            return true;
        }else {
            return false;
        }
    }
}

