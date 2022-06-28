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
    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        int city = Integer.parseInt(input.readLine());
        int bus = Integer.parseInt(input.readLine());

        ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i <= city; i++) {
            adjList.add(new ArrayList<>());
        }

        StringTokenizer str;
        for (int i = 0; i < bus; i++) {
            str = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());
            int cost = Integer.parseInt(str.nextToken());

            adjList.get(start).add(new Edge(end, cost));
        }

        str = new StringTokenizer(input.readLine());
        int start = Integer.parseInt(str.nextToken());
        int end = Integer.parseInt(str.nextToken());

        Dijkstra(start, end, city, adjList);
    }

    public static void Dijkstra(int start, int end, int city, ArrayList<ArrayList<Edge>> adjList) {

        int[] minCost = new int[city + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curP = cur.nextP;
            int curCost = cur.cost;

            if (curP == end) {
                //System.out.println("도착");
                System.out.println(curCost);
                break;
            }
            for (int i = 0; i < adjList.get(curP).size(); i++) {
                Edge nextEdge = adjList.get(curP).get(i);

                //최소 갱신시
                if (minCost[nextEdge.nextP] > curCost + nextEdge.cost) {
                    minCost[nextEdge.nextP] = curCost + nextEdge.cost;
                    pq.add(new Edge(nextEdge.nextP, curCost + nextEdge.cost));
                }
            }

        }


    }

    public static class Edge implements Comparable<Edge>
    {
        int nextP;
        int cost;

        public Edge(int nextP, int cost) {
            this.nextP = nextP;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
