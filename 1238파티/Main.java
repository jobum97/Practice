import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "4 8 2\n" +
            "1 2 4\n" +
            "1 3 2\n" +
            "1 4 7\n" +
            "2 1 1\n" +
            "2 3 5\n" +
            "3 1 2\n" +
            "3 4 6\n" +
            "4 2 3";

    static int N, M, X;
    static ArrayList<ArrayList<Edge>> adjListGo, adjListBack;
    static int[] minCostGo, minCostBack;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken()); //학생수
        M = Integer.parseInt(str.nextToken()); //도로 개수
        X = Integer.parseInt(str.nextToken()); // 목적지

        adjListGo = new ArrayList<>();
        adjListBack = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjListGo.add(new ArrayList<>());
            adjListBack.add(new ArrayList<>());
        }
        minCostBack = new int[N + 1];
        minCostGo = new int[N + 1];

        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());
            int cost = Integer.parseInt(str.nextToken());
            adjListGo.get(end).add(new Edge(start, cost));
            adjListBack.get(start).add(new Edge(end, cost));
        }
        //1~N 에서 목적지까지 최단거리 각각 + 목적지에서 1~N 까지 최단 거리 의 최대값 찾기

        minCostGo = Dijikstra(adjListGo);
        minCostBack = Dijikstra(adjListBack);

//        System.out.println(Arrays.toString(minCostGo));
//        System.out.println(Arrays.toString(minCostBack));
        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, minCostBack[i] + minCostGo[i]);
        }
        System.out.println(result);
    }

    public static int[] Dijikstra(ArrayList<ArrayList<Edge>> adjList) {

        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int minCost[] = new int[N + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        pq.add(new Edge(X, 0));
        while (!pq.isEmpty()) {
            Edge curEdge = pq.poll();
            int curNode = curEdge.next;
            int curCost = curEdge.cost;

            //System.out.println(curNode + " " + curCost);
            minCost[curNode] = Math.min(minCost[curNode], curCost);

            if (visited[curNode]) {
                continue;
            } else {
                visited[curNode] = true;
            }

            for (int i = 0; i < adjList.get(curNode).size(); i++) {
                Edge nextEdge = adjList.get(curNode).get(i);
                pq.add(new Edge(nextEdge.next, curCost + nextEdge.cost));
            }
        }
        return minCost;
    }

    public static class Edge implements Comparable<Edge> {
        int next;
        int cost;

        public Edge(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
