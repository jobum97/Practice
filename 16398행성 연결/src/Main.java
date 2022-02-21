import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "3\n" +
            "0 2 3\n" +
            "2 0 1\n" +
            "3 1 0";

    static int V, E, p[];

    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        V = Integer.parseInt(input.readLine());
        pq = new PriorityQueue<>();
        p = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            StringTokenizer str = new StringTokenizer(input.readLine());

            for (int j = 1; j <= V; j++) {
                if (j <= i) {
                    str.nextToken();
                } else {
                    pq.add(new Edge(i, j, Integer.parseInt(str.nextToken())));
                }
            }
        }

        for (int i = 0; i <= V ; i++) {
            p[i] = i;
        }

        System.out.println(Kruskal());

    }

    static class Edge implements Comparable<Edge>{
        int cur;
        int next;
        int cost;

        public Edge(int cur, int next, int cost) {
            this.cur = cur;
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
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

    public static long Kruskal() {
        long answer = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

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
