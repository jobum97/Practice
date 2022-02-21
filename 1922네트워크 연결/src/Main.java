import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "6\n" +
            "9\n" +
            "1 2 5\n" +
            "1 3 4\n" +
            "2 3 2\n" +
            "2 4 7\n" +
            "3 4 6\n" +
            "3 5 11\n" +
            "4 5 3\n" +
            "4 6 8\n" +
            "5 6 8";

    static int N, M, data[][];

    static boolean check[];

    static ArrayList<ArrayList<Edge>> adjList;

    public static void main(String[] args) throws IOException {
        input= new BufferedReader(new InputStreamReader(System.in));
        //input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        M = Integer.parseInt(input.readLine());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        check = new boolean[N + 1];

        StringTokenizer str;
        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(input.readLine());
            int s = Integer.parseInt(str.nextToken());
            int e = Integer.parseInt(str.nextToken());
            int cost = Integer.parseInt(str.nextToken());

            adjList.get(s).add(new Edge(e, cost));
            adjList.get(e).add(new Edge(s, cost));

        }

        System.out.println(Prim(1));

    }

    public static int Prim(int start) {
        int answer = 0;
        int cnt = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            //System.out.println(cur.next + " " + cur.cost+" "+cnt);

            if (check[cur.next]) {
                continue;
            }

            answer += cur.cost;
            check[cur.next] = true;

            //현재 갈수 있는 엣지들 push
            for (int i = 0; i < adjList.get(cur.next).size(); i++) {
                if (!check[adjList.get(cur.next).get(i).next]) {
                    pq.add(adjList.get(cur.next).get(i));
                }
            }

            if (++cnt == N) {
                break;
            }

        }
        return answer;
    }


    static class Edge implements Comparable<Edge>{
        int next;
        int cost;

        public Edge( int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
