import java.util.*;
public class Main {
    public static void main(String[] args) {

    }
    class Solution {

        public boolean[][][] map, checked;
        public int row, col, height, startRow, startCol, startHeight, endRow, endCol, endHeight;
        // 위 아래 상 하 좌 우
        public int moveSet[][] = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};


        public int solution(String[][] map3d) {

            row = map3d[0].length;
            col = map3d[0][0].length();
            height = map3d.length;

            map = new boolean[height][row][col];
            checked = new boolean[height][row][col];

            for (int h = 0; h < map3d.length; h++) {
                for (int r = 0; r < map3d[h].length; r++) {
                    for (int c = 0; c < map3d[h][r].length(); c++) {
                        if (map3d[h][r].charAt(c) == 'O') {
                            map[h][r][c] = true;
                        } else if (map3d[h][r].charAt(c) == 'S') {
                            startHeight = h;
                            startRow = r;
                            startCol = c;
                            map[h][r][c] = true;
                        } else if (map3d[h][r].charAt(c) == 'E') {
                            endHeight = h;
                            endRow = r;
                            endCol = c;
                            map[h][r][c] = true;
                        }
                    }
                }
            }

            return find();
        }

        // 3차원 공간, 빈칸,막힌칸
        // 상하좌우 위아래 6방향 이동 가능
        public int find() {

            int answer = -1;
            PriorityQueue<Coord> pq = new PriorityQueue<>();
            pq.add(new Coord(startHeight, startRow, startCol, 0));
            checked[startHeight][startRow][startCol] = true;

            while (!pq.isEmpty()) {
                Coord cur = pq.poll();

                // 목적지에 도착하면 최단 거리 리턴
                if (cur.height == endHeight && cur.row == endRow && cur.col == endCol) {
                    return cur.cost;
                }

                moveAllDirection(pq, cur);
            }
            return answer;
        }

        private void moveAllDirection(PriorityQueue<Coord> pq, Coord cur) {
            // 6방향으로 탐색
            for (int dir = 0; dir < moveSet.length; dir++) {

                int nextHeight = cur.height + moveSet[dir][0];
                int nextRow = cur.row + moveSet[dir][1];
                int nextCol = cur.col + moveSet[dir][2];

                // 맵 밖으로 벗어나는 위치이면 탐색X
                if (nextHeight < 0 || nextHeight >= height || nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col) {
                    continue;
                }

                // 이미 갔던 곳 아닌데 갈 수 있는 곳이면 탐색한다
                if (!checked[nextHeight][nextRow][nextCol] && map[nextHeight][nextRow][nextCol]) {
                    pq.add(new Coord(nextHeight, nextRow, nextCol, cur.cost + 1));
                    checked[nextHeight][nextRow][nextCol] = true;
                }
            }
        }


        public class Coord implements Comparable<Coord> {
            int height;
            int row;
            int col;
            int cost;
            int dist;

            public Coord(int height, int row, int col, int cost) {
                this.height = height;
                this.row = row;
                this.col = col;
                this.cost = cost;
                this.dist = Math.abs(endHeight - this.height) + Math.abs(endRow - this.row) + Math.abs(endCol - this.col);
            }

            // 소요시간 오름차순, 만약 소요시간이 같을 경우 목적지와의 절대적 거리가 같은 쪽을 우선적으로 탐색
            public int compareTo(Coord o) {
                if (this.cost == o.cost) {
                    return this.dist - o.dist;
                } else {
                    return this.cost - o.cost;
                }

            }
        }

    }
}

