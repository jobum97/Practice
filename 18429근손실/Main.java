import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "3 4\n" +
            "3 7 5";
    static int result = 0,N, K;
    static int[] machineEffect;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        machineEffect = new int[N];
        isVisited = new boolean[N];
        str = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            machineEffect[i] = Integer.parseInt(str.nextToken()) - K;
        }
        // 매일 K만큼 감량
        //운동기구 N개 N일간 1번씩 사용가능


        dfs(0, 0);
        System.out.println(result);
    }

    public static void dfs(int day, int sum) {
        if (sum < 0) {
            return;
        }
        if (day == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            dfs(day+1,sum+machineEffect[i]);
            isVisited[i] = false;
        }

    }
}
