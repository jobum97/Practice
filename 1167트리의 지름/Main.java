import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static String src = "5\n" +
            "1 3 2 -1\n" +
            "2 4 4 -1\n" +
            "3 1 2 4 3 -1\n" +
            "4 2 4 3 3 5 6 -1\n" +
            "5 4 6 -1";

    static int N, maxLength, endPoint;
    static ArrayList<ArrayList<Edge>> adjList;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(input.readLine());

        adjList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(input.readLine());
            int nodeNum = Integer.parseInt(str.nextToken());
            while (str.hasMoreTokens()) {
                int next = Integer.parseInt(str.nextToken());
                if (next == -1) {
                    break;
                }
                int dist = Integer.parseInt(str.nextToken());
                adjList.get(nodeNum).add(new Edge(next, dist));
            }
        }

        maxLength = Integer.MIN_VALUE;
        visited = new boolean[N + 1];
        dfs(1, 0);
        maxLength = Integer.MIN_VALUE;
        visited = new boolean[N + 1];
        dfs(endPoint, 0);
        System.out.println(maxLength);

    }


    public static void dfs(int cur, int dist) {
        if (maxLength < dist) {
            maxLength = dist;
            endPoint = cur;
        }

        visited[cur] = true;

        for (Edge edge : adjList.get(cur)) {
            if (visited[edge.next]) {
                continue;
            }
            dfs(edge.next, edge.dist + dist);
        }
    }
    public static class Edge{
        int next;
        int dist;

        public Edge(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }
    }
}
