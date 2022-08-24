import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "4 2\n" +
            "4 2\n" +
            "3 1";

    static int N, M, prerequisiteCnt[];
    static ArrayList<ArrayList<Integer>> prerequisiteList;
    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken()); // 문제의 수
        M = Integer.parseInt(str.nextToken()); // 먼저 풀어야하는 문제
        prerequisiteList = new ArrayList<>();
        prerequisiteCnt = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            prerequisiteList.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(input.readLine());
            int A = Integer.parseInt(str.nextToken()); // 먼저 풀어야한다
            int B = Integer.parseInt(str.nextToken()); // 풀어야하는 문제
            prerequisiteList.get(A).add(B);
            prerequisiteCnt[B]++;
        }

        // N개의 문제 모두 풀어야함
        // 먼저 푸는 문제를 반드시 먼저 풀어야함 => 위상정렬
        // 가능하면 쉬운문제 => 숫자가 작은 순, 오름차순

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (prerequisiteCnt[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            // 해결한 문제를 선행해서 풀어야하는 문제들의 선수과목 수 -1
            for (int prerequisite : prerequisiteList.get(cur)) {
                prerequisiteCnt[prerequisite]--;
            }
            // 선행과목 없으면 수강 가능
            if (prerequisiteCnt[cur] == 0) {
                output.append(cur).append(" ");
            }

            for (int i = 0; i < prerequisiteList.get(cur).size(); i++) {
                int next = prerequisiteList.get(cur).get(i);

                // 선수과목이 0인, 풀 수 있는 문제 큐에 삽입
                if (prerequisiteCnt[next] == 0) {
                    pq.add(next);
                }
            }
        }


        System.out.println(output);
    }
}
