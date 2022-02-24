import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "7 7\n" +
            "1 2\n" +
            "2 7\n" +
            "3 7\n" +
            "3 4\n" +
            "5 6\n" +
            "6 4\n" +
            "1 3";

    static int N, M;

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        int[] table = new int[N + 1];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(input.readLine());
            int front = Integer.parseInt(str.nextToken());
            int back = Integer.parseInt(str.nextToken());
            adjList.get(front).add(back);
            table[back]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (table[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            output.append(cur + " ");
            for (int i = 0; i < adjList.get(cur).size(); i++) {
                int next = adjList.get(cur).get(i);

                table[next]--;
                if (table[next] == 0) {
                    queue.add(next);
                }
            }
        }

        System.out.println(output);
    }
}
