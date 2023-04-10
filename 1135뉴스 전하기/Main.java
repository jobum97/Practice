import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "24\n" +
            "-1 0 0 1 1 1 2 2 3 3 4 4 5 5 6 7 7 8 12 13 14 16 16 16";

    static int N, dp[];
    static ArrayList<Integer>[] trees;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        N = Integer.parseInt(input.readLine());

        // 트리 구조
        // 모든 직원은 1명의 직속 상사
        // 민식이가 대빵
        // 모든 사람은 직속부하에게만 전화걸 수 있음
        // 모두에게 전파되는 시간의 최솟값은?

        trees = new ArrayList[N];
        dp = new int[N];
        StringTokenizer str = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = new ArrayList<>();
        }
        str.nextToken();
        for (int i = 1; i < N; i++) {
            trees[Integer.parseInt(str.nextToken())].add(i);
        }

        // 가장 오래 걸리는 사람에게 먼저 전파해야함

        System.out.println(dfs(0));
    }

    public static int dfs(int cur) {
        int cnt = 0;
        int max = 0;

        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        //
        for (Integer next : trees[cur]) {
            dp[next] = dfs(next);
            queue.add(new int[]{next, dp[next]});
        }

        while (!queue.isEmpty()) {
            int node[] = queue.poll();
            cnt++;
            max = Math.max(max, node[1] + cnt);
        }
        return max;
    }

}
