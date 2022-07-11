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
    static String src = "4 2\n" +
            "1 2 1\n" +
            "1 3 1\n" +
            "2 3";

    static int N, E, stopover1, stopover2;
    static ArrayList<ArrayList<Edge>> adjList;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        E = Integer.parseInt(str.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            str = new StringTokenizer(input.readLine());
            int s = Integer.parseInt(str.nextToken());
            int e = Integer.parseInt(str.nextToken());
            int cost = Integer.parseInt(str.nextToken());

            //양방향 길 추가
            adjList.get(s).add(new Edge(e, cost));
            adjList.get(e).add(new Edge(s, cost));
        }

        str = new StringTokenizer(input.readLine());
        stopover1 = Integer.parseInt(str.nextToken());
        stopover2 = Integer.parseInt(str.nextToken());

        //1->N 가는 최단 경로 조건: 특정 점 2곳 지나는 경로

        // 1->sp1->sp2->N vs 1->sp2->sp1->N
        // 어차피 양방향 이동이라 sp1 -> sp2 == sp2->sp1
        // (1-> sp1) + (sp2->N) vs (1->sp2)+(sp1->N)

        int[] start = dikjistra(1);
        int[] middle = dikjistra(stopover1);
        int[] end = dikjistra(N);
//        System.out.println(Arrays.toString(start));
//        System.out.println(Arrays.toString(end));

        int result = -1;

        boolean isRoadValid1 = (start[stopover1] != Integer.MAX_VALUE && end[stopover2] != Integer.MAX_VALUE);
        boolean isRoadValid2 = (start[stopover2] != Integer.MAX_VALUE && end[stopover1] != Integer.MAX_VALUE);
        //System.out.println(isRoadValid1 + " " + isRoadValid2);
        //최단 경로 둘다 안되는 케이스
        if ((middle[stopover2] == Integer.MAX_VALUE) || (!isRoadValid1 && !isRoadValid2)) {

        } //첫번째 길만 안되는 케이스
        else if (isRoadValid1 && !isRoadValid2) {
            result = start[stopover2] + middle[stopover2] + end[stopover1];
        } // 두번째 길만 안되는 케이스
        else if (!isRoadValid1 && isRoadValid2 ) {
            result = start[stopover1] + middle[stopover2] + end[stopover2];
        } //둘다 되는 케이스
        else {
            result = Math.min((start[stopover1] + end[stopover2]), (start[stopover2] + end[stopover1]));
            result += middle[stopover2];
        }

//      System.out.println(start[stopover1] + " " + end[stopover2]);
//      System.out.println(start[stopover2] + " " + end[stopover1]);
//      System.out.println(middle[stopover2]);
        System.out.println(result);


    }

    public static int[] dikjistra(int start) {

        int[] minCost = new int[N + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Edge curEdge = pq.poll();
            int curNode = curEdge.next;
            int curCost = curEdge.cost;

            minCost[curNode] = Math.min(minCost[curNode], curCost);

            if (visited[curNode]) {
                continue;
            }

            visited[curNode] = true;

            for (int i = 0; i < adjList.get(curNode).size(); i++) {
                Edge nextEdge = adjList.get(curNode).get(i);
                pq.add(new Edge(nextEdge.next, nextEdge.cost + curCost));
            }

        }
        return minCost;
    }

    static class Edge implements Comparable<Edge> {

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
