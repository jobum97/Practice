import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "2\n" +
            "3 3 1\n" +
            "1 2 2\n" +
            "1 3 4\n" +
            "2 3 1\n" +
            "3 1 3\n" +
            "3 2 1\n" +
            "1 2 3\n" +
            "2 3 4\n" +
            "3 1 8";

    static int N, M, W;
    static ArrayList<ArrayList<Road>> adjList;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        int tc = Integer.parseInt(input.readLine());

        for (int testcase = 1; testcase <= tc; testcase++) {
            StringTokenizer str = new StringTokenizer(input.readLine());

            N = Integer.parseInt(str.nextToken()); // 지점
            M = Integer.parseInt(str.nextToken()); // 도로
            W = Integer.parseInt(str.nextToken()); // 웜홀

            adjList = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                adjList.add(new ArrayList<>());
            }


            for (int i = 0; i < M; i++) {
                str = new StringTokenizer(input.readLine());

                int S = Integer.parseInt(str.nextToken()); // 출발
                int E = Integer.parseInt(str.nextToken()); // 도착
                int T = Integer.parseInt(str.nextToken()); // 시간

                adjList.get(S).add(new Road(E, T));
                adjList.get(E).add(new Road(S, T));
            }

            for (int i = 0; i < W; i++) {
                str = new StringTokenizer(input.readLine());

                int S = Integer.parseInt(str.nextToken()); // 출발
                int E = Integer.parseInt(str.nextToken()); // 도착
                int T = Integer.parseInt(str.nextToken()); // 시간

                adjList.get(S).add(new Road(E, -T));
            }

            boolean isPossible = false;
            for (int i = 1; i <= N; i++) {
                if (getCost(i) < 0) {
                    isPossible = true;
                    break;
                }
            }

            if (isPossible) {
                output.append("YES").append("\n");
            }else{
                output.append("NO").append("\n");
            }


        }
        System.out.println(output);

    }

    public static int getCost(int start){

        Queue<Integer> queue = new LinkedList<>();
        int[] costTable = new int[N + 1];
        Arrays.fill(costTable, 10001);

        for (Road road : adjList.get(start)) {
            queue.add(road.next);
            costTable[road.next] = road.time;
        }


        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (costTable[start] < 0) {
                break;
            }

            for (Road road : adjList.get(cur)) {
                if (costTable[road.next] > costTable[cur] + road.time) {
                   /// System.out.println(Arrays.toString(costTable));
                    queue.add(road.next);
                    costTable[road.next] = costTable[cur] + road.time;

                }
            }
        }
        return costTable[start];
    }


    public static class Road{
        int next;
        int time;

        public Road(int next, int time) {
            this.next = next;
            this.time = time;
        }
    }
}
