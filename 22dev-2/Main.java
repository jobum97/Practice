import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"XY..", "YX..", "..YX", ".AXY"}));
    }

    static int[][] moveSet = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int totalRecord[];
    public static int solution(String[] maps) {
        int answer = 0;

        int N = maps.length;
        int M = maps[0].length();

        int[][] checked = new int[N][M];
        totalRecord = new int[30];
        int p = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i].charAt(j) == '.') {
                    checked[i][j] = -1;
                }

                if (checked[i][j]==0) {
                    grouping(i, j, maps, checked, p);
                    p++;
                }
            }
        }

        for (int i = 0; i < checked.length; i++) {
            System.out.println(Arrays.toString(checked[i]));
        };

        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < totalRecord.length; i++) {
            if (max <= totalRecord[i]) {
                max = totalRecord[i];
                maxIdx = i;
            }
        }


        return totalRecord[maxIdx];
    }

    public static void grouping(int r, int c, String[] maps, int[][] checked, int p) {

        int N = maps.length;
        int M = maps[0].length();
        int record[] = new int[30];

        Queue<Coord> queue = new LinkedList<>();
        queue.add(new Coord(r, c));
        checked[r][c] = p;
        while (!queue.isEmpty()) {
            Coord cur = queue.poll();

            record[(int) (maps[cur.row].charAt(cur.col) - 'A')]++;


            for (int i = 0; i < moveSet.length; i++) {
                int nextRow = cur.row + moveSet[i][0];
                int nextCol = cur.col + moveSet[i][1];

                if (nextRow >= N || nextCol >= M || nextCol < 0 || nextRow < 0) {
                    continue;
                }

                if (checked[nextRow][nextCol] == 0 && maps[nextRow].charAt(nextCol) != '.') {
                    queue.add(new Coord(nextRow, nextCol));
                    checked[nextRow][nextCol] = p;
                }
            }
        }

        int max = 0;
        int total = 0;
        int maxIdx = 0;
        for (int i = 0; i < record.length; i++) {
            if (max <= record[i]) {
                max = record[i];
                maxIdx = i;
            }
        }

        for (int i = 0; i < record.length; i++) {
            if (record[i] < max) {
                total += record[i];
            }else if(record[i]==max){
                totalRecord[i] += record[i];
            }
        }

        totalRecord[maxIdx] += total;

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
