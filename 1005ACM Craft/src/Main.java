import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "1\n" +
            "8 8\n" +
            "10 20 1 5 8 7 1 43\n" +
            "1 2\n" +
            "1 3\n" +
            "2 4\n" +
            "4 5\n" +
            "3 6\n" +
            "5 7\n" +
            "6 7\n" +
            "8 2\n" +
            "7";

    static int T, N, K, timeTable[], sum[], parentCnt[];
    static ArrayList<ArrayList<Integer>> adjList, checkList;
    
    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        T = Integer.parseInt(input.readLine());

        for (int testcase = 0; testcase < T; testcase++) {
            StringTokenizer str = new StringTokenizer(input.readLine());
            N = Integer.parseInt(str.nextToken());
            K = Integer.parseInt(str.nextToken());

            timeTable = new int[N + 1];
            sum = new int[N + 1];
            parentCnt = new int[N + 1];

            str = new StringTokenizer(input.readLine());
            for (int i = 1; i <= N; i++) {
                timeTable[i] = Integer.parseInt(str.nextToken());
            }

            adjList = new ArrayList<>();
            checkList = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                adjList.add(new ArrayList<>());
                checkList.add(new ArrayList<>());
            }

            for (int i = 0; i < K; i++) {
                str = new StringTokenizer(input.readLine());
                int beforeBuilding = Integer.parseInt(str.nextToken());
                int targetBuilding = Integer.parseInt(str.nextToken());

                //역으로 넣어보자
                adjList.get(beforeBuilding).add(targetBuilding);
                checkList.get(targetBuilding).add(beforeBuilding);
                parentCnt[targetBuilding]++;
            }
            int End = Integer.parseInt(input.readLine());
            int answer = 0;
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (parentCnt[i] == 0) {
                    queue.add(i);
                }
            }

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                if (parentCnt[cur] == 0) {
                    int maxTime = 0;
                    for (int i = 0; i < checkList.get(cur).size(); i++) {
                        //System.out.println(cur + " " + checkList.get(cur).get(i) + " " + maxTime + " " + sum[checkList.get(cur).get(i)]);
                        maxTime = Math.max(maxTime, sum[checkList.get(cur).get(i)]);
                    }
                    sum[cur] = maxTime + timeTable[cur];
                }

                if (cur == End) {
                    output.append(sum[cur] + "\n");
                    break;
                }

                for (int i = 0; i < adjList.get(cur).size(); i++) {
                    if (--parentCnt[adjList.get(cur).get(i)] == 0) {
                        queue.add(adjList.get(cur).get(i));
                    }
                }
            }
//            System.out.println(Arrays.toString(timeTable));
//            System.out.println(Arrays.toString(parentCnt));
//            System.out.println(Arrays.toString(sum));
        }

        System.out.print(output);
    }

}
