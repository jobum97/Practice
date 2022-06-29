import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader input;
    static String src = "4 2\n" +
            "9 7 11 1";

    static int[] result, data;
    static boolean[] visit;
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        data = new int[N];
        result = new int[N];
        visit = new boolean[N];

        str = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(data);
        dfs(N, M, 0);
        System.out.print(output);
    }

    public static void dfs(int N, int M, int depth) {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                output.append(result[i] + " ");
            }
            output.append("\n");
            return;
        }

        int past = -1;
        for (int i = 0; i < data.length; i++) {
            int now = data[i];
            if (visit[i] || past == now) {
                continue;
            }else{
                past = now;
                visit[i] = true;
                result[depth] = data[i];
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }
}
