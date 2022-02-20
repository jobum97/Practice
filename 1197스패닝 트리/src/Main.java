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
    static String src = "3 3\n" +
            "1 2 1\n" +
            "2 3 2\n" +
            "1 3 3";

    static int V, E, p[];

    static boolean Table[][];
    static ArrayList<ArrayList<Edge>> adjList;
    static PriorityQueue<Edge2> pq;

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        V = Integer.parseInt(str.nextToken());
        E = Integer.parseInt(str.nextToken());

        p = new int[V + 1];
        pq = new PriorityQueue<>();

        for (int i = 0; i <= V; i++) {
            p[i] = i;
        }

        adjList = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            str = new StringTokenizer(input.readLine());
            int s = Integer.parseInt(str.nextToken());
            int e = Integer.parseInt(str.nextToken());
            int cost = Integer.parseInt(str.nextToken());

            adjList.get(s).add(new Edge(e, cost));
            adjList.get(e).add(new Edge(s, cost));
            pq.add(new Edge2(s, e, cost));
        }

        //System.out.println(Prim(1));
        System.out.println(Kruskal());
    }

    // Prim : 이전 단계에서 확장하는 방식
    // 인접 정점 중 최소 간선 연결된 정점 선택
    public static int Prim(int start) {
        int answer = 0;
        int cnt = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean checked[] = new boolean[V + 1];
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            //이미 방문한 곳이면 컷
            if (checked[cur.next]) {
                continue;
            }

            checked[cur.next] = true;
            answer+= cur.cost;

            for (int i = 0; i < adjList.get(cur.next).size(); i++) {
                if (!checked[adjList.get(cur.next).get(i).next]) {
                    pq.add(adjList.get(cur.next).get(i));
                }
            }

            if (++cnt == V) {
                break;
            }
        }
        return answer;
    }

    static class Edge implements Comparable<Edge>{
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

    static class Edge2 implements Comparable<Edge2>{
        int cur;
        int next;
        int cost;

        public Edge2(int cur, int next, int cost) {
            this.cur = cur;
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge2 o) {
            return this.cost - o.cost;
        }
    }

    //x가 속한 집합의 부모를 찾는다.
    public static int findSet(int[] p, int x) {
        if (p[x] == x)
            return x;
        else
            return p[x] = findSet(p, p[x]);
    }

    //x와 y를 같은 집합으로 합친다.
    public static void union(int[] p, int x, int y) {
        if (x < y)
            p[findSet(p, y)] = findSet(p, x);
        else
            p[findSet(p, x)] = findSet(p, y);
    }

    public static int Kruskal() {
        int answer = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            Edge2 cur = pq.poll();

            // 시작과 끝의 부모가 같지 않다면 => 같은 그래프 소속 아님
            if (findSet(p, cur.cur) != findSet(p, cur.next)) {
                // 간선 채택, 노드 합치기
                answer+= cur.cost;
                union(p, cur.cur, cur.next);

                //다돌으면 정지
                if (++cnt == V) {
                    break;
                }

            }
        }

        return answer;
    }



}
