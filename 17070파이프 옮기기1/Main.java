import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "6\n" +
            "0 0 0 0 0 0\n" +
            "0 1 0 0 0 0\n" +
            "0 0 0 0 0 0\n" +
            "0 0 0 0 0 0\n" +
            "0 0 0 0 0 0\n" +
            "0 0 0 0 0 0";

    static int N, map[][], row, col;
    static int moveSet[][] = {{0, 1}, {1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(input.readLine());

        StringTokenizer str;
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        // N,N으로 도착시키는 방법의 수, 처음은 (1,1)(1,2) 가로 방향
        // 이동방향 오른쪽, 오른쪽 아래, 아래 (방향 한번에 45도씩만 이동가능)

        row = 1;
        col = 2;

        System.out.println(sol());


    }

    public static boolean moveCheck(int dir, int row, int col) {
        //System.out.println(dir + " " + row + " " + col + " " + N);
        int nextRow = row + 1;
        int nextCol = col + 1;
        if (dir == 0) {
            if (nextCol <= N && map[row][col + 1] == 0) {
                return true;
            } else {
                return false;
            }
        } else if (dir == 1) {
            if (nextRow <= N && nextCol <= N && map[row][col + 1] == 0 && map[row + 1][col] == 0 && map[row + 1][col + 1] == 0) {
                return true;
            } else {
                return false;
            }
        } else if (dir == 2) {
            if (nextRow <= N && map[row + 1][col] == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static Coord move(int dir, Coord before) {
        if (dir == 0) {
            return new Coord(0, before.row, before.col + 1);
        } else if (dir == 1) {
            return new Coord(1, before.row + 1, before.col + 1);
        } else {
            return new Coord(2, before.row + 1, before.col);
        }
    }

    public static int sol(){
        int result = 0;
        Queue<Coord> queue = new LinkedList<>();
        queue.add(new Coord(0, row, col));

        while (!queue.isEmpty()) {
            Coord cur = queue.poll();
           // System.out.println("cur:" + cur.row + " " + cur.col);
            if (cur.row == N && cur.col == N) {
                //System.out.println("도착");
                result++;
                continue;
            }
            if (cur.row > N || cur.col > N) {
                continue;
            }

            for (int i = cur.dir - 1; i <= cur.dir + 1; i++) {
                //System.out.println(i + " " + cur.row + " " + cur.col);
                if (moveCheck(i, cur.row, cur.col)) {
                    //System.out.println("통과");
                    queue.add(move(i, cur));
                }
            }

        }
        return result;
    }
    public static class Coord{
        int dir;
        int row;
        int col;

        public Coord(int dir, int row, int col) {
            this.dir = dir;
            this.row = row;
            this.col = col;
        }
    }
}
