import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "4\n" +
            "0 10 15 20\n" +
            "5 0 9 10\n" +
            "6 13 0 12\n" +
            "8 8 9 0";

    static int N, costTable[][], ans, visitAll, dp[][], INF = 999999999;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        N = Integer.parseInt(input.readLine());

        costTable = new int[N][N];
        visitAll = (1 << N) - 1;
        ans = Integer.MAX_VALUE;
        dp = new int[N][visitAll];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                costTable[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        System.out.println(tsp(0, 1));
    }

    public static int tsp(int cur, int visit) {

        // 모든 도시 방문했다면
        if (visit == visitAll) {
            //System.out.println(cost);
            if (costTable[cur][0] > 0) {
                return costTable[cur][0];
            }else{
                return INF;
            }
        }

        // 이미 방문한
        if (dp[cur][visit] != -1) {
            return dp[cur][visit];
        }

        dp[cur][visit] = INF;

        for (int i = 0; i < N; i++) {
            int next = visit | (1 << i);
            // 연결되어 있고 가본적 없다면
            if (costTable[cur][i] > 0 && (visit & (1 << i)) == 0) {
                dp[cur][visit] = Math.min(dp[cur][visit], tsp(i, next) + costTable[cur][i]);
            }
        }
        return dp[cur][visit];
    }
}
