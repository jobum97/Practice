import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "5\n" +
            "8\n" +
            "1 2 2\n" +
            "1 3 3\n" +
            "1 4 1\n" +
            "1 5 10\n" +
            "2 4 2\n" +
            "3 4 1\n" +
            "3 5 1\n" +
            "4 5 3\n" +
            "1 5";

    static int n, m;
    static ArrayList<ArrayList<Edge>> adjList;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        n = Integer.parseInt(input.readLine());
        m = Integer.parseInt(input.readLine());

        adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        StringTokenizer str;
        for (int i = 0; i < m; i++) {
            str = new StringTokenizer(input.readLine());
            int s = Integer.parseInt(str.nextToken());
            int e = Integer.parseInt(str.nextToken());
            int cost = Integer.parseInt(str.nextToken());

            adjList.get(s).add(new Edge(e, cost));
        }

        str = new StringTokenizer(input.readLine());

        int start = Integer.parseInt(str.nextToken());
        int end = Integer.parseInt(str.nextToken());

        sol(start, end);
    }

    public static void sol(int start, int end) {

        int beforeNode[] = new int[n + 1];
        int curCost[] = new int[n + 1];
        Arrays.fill(curCost, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(start, 0));
        curCost[start] = 0;

        while (!pq.isEmpty()) {

            Edge curEdge = pq.poll();
            int curNode = curEdge.e;
            //System.out.println(curEdge.e + " " + curEdge.cost);
            if (curNode == end) {
                output.append(curEdge.cost).append("\n");
                break;
            }

            for (int i = 0; i < adjList.get(curNode).size(); i++) {

                Edge next = adjList.get(curNode).get(i);
                if (curCost[next.e] > curCost[curNode] + next.cost) {
                    pq.add(new Edge(next.e, curEdge.cost + next.cost));
                    beforeNode[next.e] = curNode;
                    curCost[next.e] = curCost[curNode] + next.cost;
                }

            }

        }

        //System.out.println(Arrays.toString(beforeNode));
        //output.append(answer.list.size()).append("\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        int cur = end;
        while (beforeNode[cur] != 0) {
            stack.push(beforeNode[cur]);
            cur = beforeNode[cur];

        }
        output.append(stack.size()).append("\n");
        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(" ");
        }

        System.out.println(output);
    }

    public static class Edge implements Comparable<Edge>{
        int e;
        int cost;

        public Edge(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
