import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "6\n" +
            "5\n" +
            "E 2 3\n" +
            "E 1 4\n" +
            "E 3 5\n" +
            "F 4 6\n" +
            "E 1 2";
    static int N, M, parent[];

    static ArrayList<ArrayList<Integer>> adjList;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        N = Integer.parseInt(input.readLine());
        M = Integer.parseInt(input.readLine());
        parent = new int[N + 1];
        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
            adjList.add(new ArrayList<>());
        }

        // 내친구의 친구는 친구 => 유니온 파인드
        // 내 원수의 원수도 친구 => 모든 관계가 나오고 탐색 돌아봐야할듯

        for (int i = 0; i < M; i++) {
            StringTokenizer str = new StringTokenizer(input.readLine());
            String flag = str.nextToken();
            int p = Integer.parseInt(str.nextToken());
            int q = Integer.parseInt(str.nextToken());

            if (flag.equals("F")) {
                union(p, q);
            } else if (flag.equals("E")) {
                adjList.get(p).add(q);
                adjList.get(q).add(p);
            }
        }

        for (int i = 1; i <= N; i++) {
            enermyXenermy(i);
        }
        int cnt = 0;
        boolean visited[] = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = getParent(i);
            if (!visited[parent[i]]) {
                visited[parent[i]] = true;
                cnt++;
            }
        }
        //System.out.println(Arrays.toString(parent));
        System.out.println(cnt);
    }

    public static void enermyXenermy(int start) {
        Queue<Link> queue = new LinkedList<>();
        queue.add(new Link(0, start));
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        while (!queue.isEmpty()) {
            Link cur = queue.poll();

            if (cur.stack == 2) {
                union(start, getParent(cur.idx));
                continue;
            }
            for (int i = 0; i < adjList.get(cur.idx).size(); i++) {
                if (visited[adjList.get(cur.idx).get(i)]) {
                    continue;
                }

                visited[cur.idx] = true;
                queue.add(new Link(cur.stack + 1, adjList.get(cur.idx).get(i)));
            }
        }
    }

    public static class Link {
        int stack;
        int idx;

        public Link(int stack, int idx) {
            this.stack = stack;
            this.idx = idx;
        }
    }

    public static int getParent(int x) {
        if (x == parent[x]) {
            return parent[x];
        }
        return getParent(parent[x]);
    }

    public static void union(int x, int y) {
        int pX = getParent(x);
        int pY = getParent(y);
        if (pX < pY) {
            parent[pY] = pX;
        } else {
            parent[pX] = pY;
        }
    }

}
