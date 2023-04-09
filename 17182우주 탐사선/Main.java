import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "4 1\n" +
            "0 83 38 7\n" +
            "15 0 30 83\n" +
            "67 99 0 44\n" +
            "14 46 81 0";
    static int N,K, adjArr[][], answer;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());
        adjArr = new int[N][N];
        visited = new boolean[N];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                adjArr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        // 모든 행성 탐사하는데 걸리는 시간
        // 0번째 행성에서 출발
        // 갔던데 가도됨, 모든 곳 탐사해야함

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (adjArr[i][j] > adjArr[i][k] + adjArr[k][j]) {
                        adjArr[i][j] = adjArr[i][k] + adjArr[k][j];
                    }
                }
            }
        }
        visited[K] = true;
        dfs(K,0,1);
        System.out.println(answer);
    }

    public static void dfs(int idx, int dist, int cnt) {
        if (answer < dist) {
            return;
        }
        if (cnt == N) {
            answer = Math.min(answer, dist);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(i, dist + adjArr[idx][i], cnt + 1);
            visited[i] = false;
        }

    }
}
