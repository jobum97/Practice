import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static int[][] moveSet = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int[][] verticalMoveSet = {{-1, 1}, {-1, -1}, {-2, 0}};
    static int[][] horizonMoveSet = {{0, -2}, {0, 2}, {0, 3}, {0, -3}};


    public int[][] solution(String[] wall) {

        char[][] map = new char[wall.length][wall[0].length()];
        for (int i = 0; i < wall.length; i++) {
            for (int j = 0; j < wall[i].length(); j++) {
                map[i][j] = wall[i].charAt(j);
            }
        }
        return sol(map);
    }

    public int[][] sol(char[][] map) {
        // 홀드, 빈칸, 막힌칸
        // 홀드로는 상하좌우 이동가능
        //  홀드간의 길이 비어있으면 2~3칸 이동가능
        int startRow = map.length - 1;
        int startCol = 0;

        int N = map.length;
        int M = map[0].length;
        int answer[][] = new int[N][M];
        boolean checked[][] = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'H') {
                    answer[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        PriorityQueue<Coord> queue = new PriorityQueue<>();
        answer[startRow][startCol] = 1;
        queue.add(new Coord(startRow, startCol, 1));
        checked[startRow][startCol] = true;
        while (!queue.isEmpty()) {
            Coord cur = queue.poll();

            for (int i = 0; i < moveSet.length; i++) {
                int nextRow = cur.row + moveSet[i][0];
                int nextCol = cur.col + moveSet[i][1];

                if (nextCol < 0 || nextRow < 0 || nextRow >= N || nextCol >= M || !(map[nextRow][nextCol] == 'H')) {
                    continue;
                }
                // 최소 갱신 홀드라면
                if (answer[nextRow][nextCol] > cur.cnt + 1) {
                    queue.add(new Coord(nextRow, nextCol, cur.cnt + 1));
                    answer[nextRow][nextCol] = cur.cnt + 1;
                }
            }

            for (int i = 0; i < verticalMoveSet.length; i++) {
                int nextRow = cur.row + verticalMoveSet[i][0];
                int nextCol = cur.col + verticalMoveSet[i][1];

                //맵 벗어나거나 홀드가 아니면
                if (nextCol < 0 || nextRow < 0 || nextRow >= N || nextCol >= M || !(map[nextRow][nextCol] == 'H')) {
                    continue;
                }

                int minRow = Math.min(cur.row, nextRow);
                int maxRow = Math.max(cur.row, nextRow);
                int minCol = Math.min(cur.col, nextCol);
                boolean flag = true;
                //세로 움직임
                if (cur.col == nextCol) {
                    for (int j = minRow; j < nextRow; j++) {
                        if (map[cur.col][j] == 'X') {
                            flag = false;
                            break;
                        }
                    }
                }else{
                    for (int r = maxRow; r <= minRow; r--) {
                        for (int c = minCol; c <= minCol + 1; c++) {
                            if (map[r][c] == 'X') {
                                flag = false;
                                break;
                            }
                        }
                    }
                }

                //갈 수 없음
                if(!flag){
                    continue;
                }

                // 최소 갱신 홀드라면
                if (answer[nextRow][nextCol] > cur.cnt + 1) {
                    queue.add(new Coord(nextRow, nextCol, cur.cnt + 1));
                    answer[nextRow][nextCol] = cur.cnt + 1;
                }
            }

            for (int i = 0; i < horizonMoveSet.length; i++) {
                int nextRow = cur.row + horizonMoveSet[i][0];
                int nextCol = cur.col + horizonMoveSet[i][1];
                System.out.println(nextRow + " " + nextCol);
                //맵 벗어나거나 홀드가 아니면
                if (nextCol < 0 || nextRow - 1 < 0 || nextRow >= N || nextCol >= M || !(map[nextRow][nextCol] == 'H')) {
                    continue;
                }

                int minCol = Math.min(cur.col, nextCol);
                int maxCol = Math.max(cur.col, nextCol);
                boolean flag = true;
               //가로 움직임
                for (int r = cur.row - 1; r <= cur.row; r--) {
                    for (int c = minCol; c <= maxCol; c++) {
                        if (map[r][c] == 'X') {
                            flag = false;
                            break;
                        }
                    }
                }

                //갈 수 없음
                if(!flag){
                    continue;
                }

                // 최소 갱신 홀드라면
                if (answer[nextRow][nextCol] > cur.cnt + 1) {
                    queue.add(new Coord(nextRow, nextCol, cur.cnt + 1));
                    answer[nextRow][nextCol] = cur.cnt + 1;
                }
            }


        }

        return answer;
    }

    public class Coord implements Comparable<Coord>{
        int row;
        int col;
        int cnt;

        public Coord(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Coord o) {
            return this.cnt - o.cnt;
        }
    }
}
