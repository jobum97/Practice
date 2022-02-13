import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "7\n" +
            "0 0 0 1 0 0 0\n" +
            "0 0 0 0 0 0 1\n" +
            "0 0 0 0 0 0 0\n" +
            "0 0 0 0 1 1 0\n" +
            "1 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 1\n" +
            "0 0 1 0 0 0 0";


    static int N, M, data[][], maxValue;
    static int canGo[][];
    static ArrayList<ArrayList<Integer>> adjList;



    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(input.readLine()); // 정점의 개수
        adjList = new ArrayList<>();
        canGo = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        StringTokenizer str;
        for (int i = 1; i <= N; i++) {
            str = new StringTokenizer(input.readLine());

            for (int j = 1; j <= N; j++) {
                int temp = Integer.parseInt(str.nextToken());
                if (temp == 1) {
                    adjList.get(i).add(j);
                }
            }
        }



        for (int i = 1; i <=N ; i++) {
            sol(i);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                output.append(canGo[i][j] + " ");
            }
            output.append("\n");
        }
        System.out.print(output);

    }

    public static void sol(int start) {
        boolean checked[] = new boolean[N + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(start);
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            for (int i = 0; i < adjList.get(cur).size(); i++) {
                //가본적 없으면
                if (!checked[adjList.get(cur).get(i)]) {
                    pq.add(adjList.get(cur).get(i));
                    checked[adjList.get(cur).get(i)] = true;
                    canGo[start][adjList.get(cur).get(i)] = 1;
                }
            }
        }


    }
}

