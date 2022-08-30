import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "4\n" +
            "1 1\n" +
            "2 2\n" +
            "1 2\n" +
            "2 1";

    static int N, map[][], visitAll;
    static double edgeTable[][], dp[][];

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        N = Integer.parseInt(input.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(input.readLine());
            map[i][0] = Integer.parseInt(str.nextToken());
            map[i][1] = Integer.parseInt(str.nextToken());
        }

        edgeTable = new double[N][N];
        visitAll = (1 << N) - 1;
        dp = new double[N][visitAll];

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int xDiff = Math.abs(map[i][0] - map[j][0]);
                int yDiff = Math.abs(map[i][1] - map[j][1]);
                double length = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
                edgeTable[i][j] = length;
                edgeTable[j][i] = length;
            }
        }

        System.out.println(tsp(0, 1));
    }

    public static double tsp(int cur, int visit) {

        //다 방문했을 때 마지막 위치에서 원점으로 돌아오는 길이 더하기
        if (visit == visitAll) {
            return edgeTable[cur][0];
        }

        //이미 방문했다면
        if (dp[cur][visit] != 0) {
            return dp[cur][visit];
        }

        dp[cur][visit] = Integer.MAX_VALUE;

        for (int next = 0; next < N; next++) {
            int nextVisit = visit | (1 << next);
            // 방문한적 없고 갈 수 있다면
            if (edgeTable[cur][next] > 0 && (visit & (1 << next)) == 0) {
                dp[cur][visit] = Math.min(dp[cur][visit], tsp(next, nextVisit) + edgeTable[cur][next]);
            }

        }

        return dp[cur][visit];
    }
}
