import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "3 4 6\n" +
            "....\n" +
            ".T..\n" +
            "....";

    static boolean map[][], isVisited[][];
    static final int moveSet[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static int R,C, K, answer;

    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        R = Integer.parseInt(str.nextToken());
        C = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());
        // T는 가지 못하는 부분

        map = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = input.readLine();
            for (int j = 0; j < C; j++) {
                char token = line.charAt(j);
                if (token == '.') {
                    map[i][j] = true;
                } else if (token == 'T') {
                    map[i][j] = false;
                }
            }
        }
        answer = 0;
        isVisited = new boolean[R][C];
        isVisited[R - 1][0] = true;
        dfs(1, R - 1, 0);
        System.out.println(answer);
    }

    public static void dfs(int dist, int row, int col) {
        if (dist == K) {
            if (row == 0 && col == C - 1) {
                answer += 1;
            }
            return;
        }

        //System.out.println(row+" "+col+" "+dist);
        for (int i = 0; i < moveSet.length; i++) {
            int nextRow = row + moveSet[i][0];
            int nextCol = col + moveSet[i][1];

            // 맵밖 벗어나거나 방문했던곳 다시가거나 갈수없는 곳에 가면
            if (!isInMap(nextRow, nextCol) || isVisited[nextRow][nextCol] || !map[nextRow][nextCol]) {
                continue;
            }
            isVisited[nextRow][nextCol] = true;
            dfs(dist + 1, nextRow, nextCol);
            isVisited[nextRow][nextCol] = false;
        }

    }

    public static int sol() {
        // 거리 K인 집에 가는 가짓수
        // 한번 간 곳은 지나가지 않음
        int count = 0;
        PriorityQueue<FootStep> queue = new PriorityQueue<>();
        queue.add(new FootStep(R, C, 0));
        boolean[][] isVisited = new boolean[R][C];

        while (!queue.isEmpty()) {

            FootStep footStep = queue.poll();
            if (footStep.row == 0 && footStep.col == C - 1 && footStep.dist == K) {
                count++;
            }

            for (int i = 0; i < moveSet.length; i++) {
                int nextRow = footStep.row + moveSet[i][0];
                int nextCol = footStep.row + moveSet[i][1];

                if (!isInMap(nextRow, nextCol) || isVisited[nextRow][nextCol] || footStep.dist == K) {
                    continue;
                }

                isVisited[nextRow][nextCol] = true;
                queue.add(new FootStep(nextRow, nextCol, footStep.dist + 1));
            }

        }


        return count;
    }

    public static boolean isInMap(int row, int col) {
        if (row < 0 || col < 0 || row >= R || col >= C) {
            return false;
        }
        return true;
    }

    public static class FootStep implements Comparable<FootStep>{
        int row;
        int col;
        int dist;

        public FootStep(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

        public int compareTo(FootStep footStep) {
            return this.dist - footStep.dist;
        }
    }
}
