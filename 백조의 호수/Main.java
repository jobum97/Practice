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
    static String src = "8 17\n" +
            "...XXXXXX..XX.XXX\n" +
            "....XXXXXXXXX.XXX\n" +
            "...XXXXXXXXXXXX..\n" +
            "..XXXXX.LXXXXXX..\n" +
            ".XXXXXX..XXXXXX..\n" +
            "XXXXXXX...XXXX...\n" +
            "..XXXXX...XXX....\n" +
            "....XXXXX.XXXL...";

    static int R, C, targetRow1, targetCol1, targetRow2, targetCol2;
    static boolean[][] map, checked;
    static Queue<Coord> waterQueue = new LinkedList<>();
    static Queue<Coord> nextQueue = new LinkedList<>();
    static Queue<Coord> findQueue = new LinkedList<>();
    static int[][] moveSet = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        R = Integer.parseInt(str.nextToken());
        C = Integer.parseInt(str.nextToken());

        // .: 물 X: 빙판, L: 백조
        // 날마다 물과 인접한 빙판 녹음

        map = new boolean[R + 1][C + 1];
        checked = new boolean[R + 1][C + 1];

        boolean isFirst = true;
        for (int i = 0; i < R; i++) {
            String line = input.readLine();
            for (int j = 0; j < C; j++) {
                if (line.charAt(j) == '.') {
                    waterQueue.add(new Coord(i + 1, j + 1));
                    map[i + 1][j + 1] = true;
                } else if (line.charAt(j) == 'L') {
                    map[i + 1][j + 1] = true;
                    waterQueue.add(new Coord(i + 1, j + 1));
                    if(isFirst){
                        targetRow1 = i + 1;
                        targetCol1 = j + 1;
                        isFirst = false;
                    }else{
                        targetRow2 = i + 1;
                        targetCol2 = j + 1;
                    }
                }
            }
        }


        sol();

    }

    public static void sol() {

        findQueue.add(new Coord(targetRow1, targetCol1));
        checked[targetRow1][targetCol1] = true;
        int day = 0;
        while (!find()) {
            //System.out.println("=================day: "+day+"====================");
            melt();
            day++;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
        System.out.println(day);
    }

    public static boolean find() {

        while(!findQueue.isEmpty()){
            Coord cur = findQueue.poll();
            //System.out.println("find " + cur.row + " " + cur.col);
            if (cur.row == targetRow2 && cur.col == targetCol2) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + moveSet[i][0];
                int nextCol = cur.col + moveSet[i][1];

                if (nextRow <= 0 || nextCol <= 0 || nextRow > R || nextCol > C) {
                    continue;
                }

                if (checked[nextRow][nextCol]) {
                    continue;
                }

                checked[nextRow][nextCol] = true;
                //빙판이면 nextQueue에 넣기
                if (!map[nextRow][nextCol]) {
                    nextQueue.add(new Coord(nextRow, nextCol));
                   // System.out.println("next find " + nextRow+ " " + nextCol);
                }else{
                    findQueue.add(new Coord(nextRow, nextCol));
                }
            }
        }

        while (!nextQueue.isEmpty()) {
            findQueue.add(nextQueue.poll());
        }
        return false;
    }


    public static void melt(){

        // 녹을 물 녹이고 녹은 지점들 다시 waterQueue에 넣어야함
        Queue<Coord> queue = new LinkedList<>();

        while (!waterQueue.isEmpty()) {
            Coord cur = waterQueue.poll();
            //System.out.println("melt "+cur.row+" "+cur.col);
            for (int k = 0; k < 4; k++) {

                int nextRow = cur.row + moveSet[k][0];
                int nextCol = cur.col + moveSet[k][1];

                if (nextRow <= 0 || nextCol <= 0 || nextRow > R || nextCol > C) {
                    continue;
                }

                //빙판이면
                if (!map[nextRow][nextCol]) {
                    map[nextRow][nextCol] = true;
                    //System.out.println("nextMelt "+nextRow+" "+nextCol);
                    queue.add(new Coord(nextRow, nextCol));
                }
            }
        }

        while (!queue.isEmpty()) {
            waterQueue.add(queue.poll());
        }
    }
    public static class Coord{
        int row;
        int col;

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
