import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "7 4\n" +
            "0 0 0 1\n" +
            "0 1 0 0\n" +
            "0 0 0 0\n" +
            "0 0 0 1\n" +
            "0 0 0 0\n" +
            "0 1 0 0\n" +
            "0 0 0 1";
    static int N, M, map[][];
    static boolean isVisited[][];
    static final int moveSet[][] = {{-1, -1}, {1, 1}, {-1, 1}, {1, -1}, {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];
        Queue<Shark> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(str.nextToken()) == 1) {
                    queue.add(new Shark(i, j, 0));
                    isVisited[i][j] = true;
                }else{
                    map[i][j] = 1000;
                }
            }
        }

        //어떤 칸의 안전거리 == 가장 거리가 가까운 상어와의 거리
        // 이동거리 == 대각선 이동 포함 거리

        // 안전 거리의 최대 값 찾아보자
        int max = 0;
        while (!queue.isEmpty()) {
            Shark cur = queue.poll();
            //System.out.println("===================" + cur.row + " " + cur.col + " " + cur.dist + "====================");
            for (int i = 0; i < moveSet.length; i++) {
                int nextRow = cur.row + moveSet[i][0];
                int nextCol = cur.col + moveSet[i][1];
                // 맵밖을 벗어나가거나 기존 최대값보다 크거나 같다면 굳이 갈필요없음
                if (!isInMap(nextRow, nextCol) || map[nextRow][nextCol] <= cur.dist + 1) {
                    continue;
                }

                map[nextRow][nextCol] = cur.dist + 1;
                max = Math.max(max, cur.dist + 1);
                queue.add(new Shark(nextRow, nextCol, cur.dist + 1));
            }
        }

        System.out.println(max);
    }

    public static boolean isInMap(int row, int col) {
        if (row < 0 || col < 0 || row >= N || col >= M) {
            return false;
        }
        return true;
    }

    public static class Shark{
        int row;
        int col;
        int dist;

        public Shark(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}
