import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String src = "15 15\n" +
            "2 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
            "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
            "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
            "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
            "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
            "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
            "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
            "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
            "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
            "1 1 1 1 1 1 1 1 0 0 0 0 0 0 0\n" +
            "1 1 1 1 1 1 1 1 0 1 1 1 1 1 1\n" +
            "1 1 1 1 1 1 1 1 0 1 0 0 0 0 0\n" +
            "1 1 1 1 1 1 1 1 0 1 0 1 1 1 1\n" +
            "1 1 1 1 1 1 1 1 0 1 0 1 0 0 0\n" +
            "1 1 1 1 1 1 1 1 1 1 0 1 1 1 1";
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static boolean[] checked;
    static int[][] moveSet = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

    public void solution() throws Exception{
        input = new BufferedReader(new InputStreamReader(System.in));
         input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        // 갈수 없는 땅 0
        // 갈 수 있는 땅 도달할 수 없는 곳은 -1
        // 각 지점에서의 목표지점까지의 거리
        // == 목표지점에서의 각 지역까지의 거리

        int map[][] = new int[N][M];
        boolean cantGo[][] = new boolean[N][M];
        Queue<Coord> startPointList = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(str.nextToken());
                if (input == 2) {
                    startPointList.add(new Coord(i, j, 0));
                    cantGo[i][j] = true;
                } else if (input == 0) {
                    cantGo[i][j] = true;
                }else{
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!startPointList.isEmpty()) {
            Coord start = startPointList.poll();
            for (int i = 0; i < moveSet.length; i++) {
                int nextRow = start.row + moveSet[i][0];
                int nextCol = start.col + moveSet[i][1];

                if (nextRow < 0 | nextCol < 0 | nextRow >= N | nextCol >= M) {
                    continue;
                }

                // 출발점이나 갈 수 없는 곳이 아니면서 최솟값 갱신시에만에 이동
                if (!cantGo[nextRow][nextCol] && start.dist + 1 < map[nextRow][nextCol]) {
                    map[nextRow][nextCol] = start.dist + 1;
                    startPointList.add(new Coord(nextRow, nextCol, start.dist + 1));
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == Integer.MAX_VALUE) {
                    map[i][j] = -1;
                }
                result.append(map[i][j]).append(" ");
            }
            result.append("\n");
        }
        System.out.println(result);
    }

    public class Coord{
        int row;
        int col;
        int dist;

        public Coord(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
