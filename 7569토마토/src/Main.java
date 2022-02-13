import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "5 3 2\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "0 0 0 0 0\n" +
            "0 0 1 0 0\n" +
            "0 0 0 0 0";


    static int C, R, H, answer;
    static boolean checked[][][];
    static ArrayList<Coord> tomato;
    static int moveSet[][] = {{1, 0, 0}, {0, 1, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str;
        str = new StringTokenizer(input.readLine());

        C = Integer.parseInt(str.nextToken()); //col
        R = Integer.parseInt(str.nextToken()); //row
        H = Integer.parseInt(str.nextToken()); //height

        tomato = new ArrayList<>();
        checked = new boolean[R][C][H];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < R; j++) {
                str = new StringTokenizer(input.readLine());
                for (int k = 0; k < C; k++) {
                    int temp = Integer.parseInt(str.nextToken());
                    if (temp == 1) {
                        checked[j][k][i] = true;
                        tomato.add(new Coord(j, k, i, 0));
                    } else if (temp == -1) {
                        checked[j][k][i] = true;
                    }
                }
            }
        }
        sol();

        boolean isValid = true;
        loop:
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (!checked[j][k][i]) {
                        isValid = false;
                        break loop;
                    }

                }
            }
        }
        if (isValid) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }


    }

    public static void sol() {
        PriorityQueue<Coord> PQ = new PriorityQueue<>();

        for (int i = 0; i < tomato.size(); i++) {
            PQ.add(tomato.get(i));
        }

        while (!PQ.isEmpty()) {
            Coord cur = PQ.poll();
            answer = cur.day;
            //System.out.println(cur.row + " " + cur.col + " " + cur.day);
            for (int i = 0; i < moveSet.length; i++) {

                int nextRow = cur.row + moveSet[i][0];
                int nextCol = cur.col + moveSet[i][1];
                int nextH = cur.height + moveSet[i][2];

                //범위 벗어나면 아웃
                if (nextRow < 0 || nextCol < 0 || nextH < 0 || nextRow >= R || nextCol >= C || nextH >= H) {
                    continue;
                }

                if (!checked[nextRow][nextCol][nextH]) {
                    checked[nextRow][nextCol][nextH] = true;
                    PQ.add(new Coord(nextRow, nextCol, nextH, cur.day + 1));
                }

            }
        }
    }


    static class Coord implements Comparable<Coord>{
        int row;
        int col;
        int height;
        int day;
        public Coord(int row, int col, int height, int day) {
            this.row = row;
            this.col = col;
            this.height = height;
            this.day = day;
        }

        @Override
        public int compareTo(Coord o) {
            return this.day - o.day;
        }
    }

}
