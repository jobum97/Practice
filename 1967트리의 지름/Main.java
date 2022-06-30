import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static String src = "12\n" +
            "1 2 3\n" +
            "1 3 2\n" +
            "2 4 5\n" +
            "3 5 11\n" +
            "3 6 9\n" +
            "4 7 1\n" +
            "4 8 7\n" +
            "5 9 15\n" +
            "5 10 4\n" +
            "6 11 6\n" +
            "6 12 10";

    static List<Node>[] nodes;
    static boolean[] visited;
    static int max,end;
    public static void main(String[] args) throws IOException {
//        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());
        StringTokenizer str;

        nodes = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<Node>();
        }

        for (int i = 1; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            int parentNode = Integer.parseInt(str.nextToken());
            int childNode = Integer.parseInt(str.nextToken());
            int value = Integer.parseInt(str.nextToken());

            nodes[parentNode].add(new Node(childNode, value));
            nodes[childNode].add(new Node(parentNode, value));
        }

        visited = new boolean[N + 1];
        max = Integer.MIN_VALUE;
        dfs(1, 0);
        visited = new boolean[N + 1];
        max = Integer.MIN_VALUE;
        dfs(end, 0);

        System.out.println(max);


    }
    public static void dfs(int cur, int dist) {
        if (max < dist) {
            end = cur;
            max = dist;
        }

        visited[cur] = true;

        for (Node next : nodes[cur]
        ) {
            if (visited[next.node]) {
                continue;
            }
            dfs(next.node, dist + next.dist);
        }
    }

    public static class Node{
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}
