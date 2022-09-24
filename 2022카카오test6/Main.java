import java.util.*;
public class Main {
    static int[][] moveSet = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    static char[] charSet = {'d', 'l', 'r', 'u'};

    public static void main(String[] args) {
        System.out.println(solution(50,50, 1,1, 50,50, 2500));
    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";

        boolean failFlag = true;
        PriorityQueue<FootPrint> pq = new PriorityQueue<>();
        pq.add(new FootPrint(x, y, "", 0));
        int sub = k - Math.abs(r - y) + Math.abs(c - x); // 필요한 이동수
        while (!pq.isEmpty()) {
            FootPrint cur = pq.poll();
            System.out.println(cur.row + " " + cur.col);

            if (sub % 2 != 0) {
                break;
            }
            if (cur.dist == k && cur.row == r && cur.col == c) {
                failFlag = false;
                answer = cur.log;
                break;
            }
            for (int i = 0; i < moveSet.length; i++) {
                int nextRow = cur.row + moveSet[i][0];
                int nextCol = cur.col + moveSet[i][1];

                if (nextRow < 1 || nextRow > n || nextCol < 1 || nextCol > m) {
                    continue;
                }
                int targetDist = Math.abs(r - nextRow) + Math.abs(c - nextCol);
                // 갈 수 있는 횟수가 살아 있고, 현재 상태에서 갈 수 있는 위치여야
                if (cur.dist < k && targetDist <= k - cur.dist) {
                    pq.add(new FootPrint(nextRow, nextCol, cur.log + charSet[i], cur.dist + 1));
                }
            }

        }

        if (failFlag) {
            return "impossible";
        }

        return answer;
    }

    public static class FootPrint implements Comparable<FootPrint>{
        int row;
        int col;
        String log;
        int dist;

        public FootPrint(int row, int col, String log, int dist) {
            this.row = row;
            this.col = col;
            this.log = log;
            this.dist = dist;
        }

        @Override
        public int compareTo(FootPrint o) {
            return this.log.compareTo(o.log);
        }
    }
}
