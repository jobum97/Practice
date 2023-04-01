import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();

    static String src="4 3\n" +
            "1 2 3\n" +
            "2 3 2\n" +
            "2 4 4\n" +
            "1 2\n" +
            "4 1\n" +
            "3 1";
    static int N, Q;

    public static void main(String args[]) throws IOException {
        //input=new BufferedReader(new InputStreamReader(System.in));
        input=new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        Q = Integer.parseInt(str.nextToken());

        // 테이블 초기화
        ArrayList<ArrayList<Link>> adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        // 초기 값 설정
        for (int i = 1; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            int p = Integer.parseInt(str.nextToken()); //동영상 p
            int q = Integer.parseInt(str.nextToken()); //동영상 q
            int r = Integer.parseInt(str.nextToken()); // USADO r

            adjList.get(p).add(new Link(q, r));
            adjList.get(q).add(new Link(p, r));
        }

        for (int i = 0; i < Q; i++) {
            str = new StringTokenizer(input.readLine());
            int k = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());
            output.append(sol(adjList, v, k)).append("\n");
        }

        System.out.print(output);
    }

    public static int sol(ArrayList<ArrayList<Link>> adjList, int start, int limit) {
        boolean[] isVisited = new boolean[N + 1];
        isVisited[start] = true;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        pq.add(start);

        while (!pq.isEmpty()) {
            Integer cur = pq.poll();
            for (Link link : adjList.get(cur)) {
                // 방문한적없고 k 보다 값이 높으면 탐색 이어나가며 센다
                if (!isVisited[link.targetNode] && limit <= link.usado) {
                    pq.add(link.targetNode);
                    isVisited[link.targetNode] = true;
                    count++;
                }
            }
        }

        return count;
    }

    private static class Link implements Comparable<Link> {

        int targetNode;
        int usado;

        public Link(int targetNode, int usado) {
            this.targetNode = targetNode;
            this.usado = usado;
        }

        @Override
        public int compareTo(Link o) {
            return this.usado - o.usado;
        }
    }
}

