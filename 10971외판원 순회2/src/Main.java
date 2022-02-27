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
    static String src = "4\n" +
            "0 10 15 20\n" +
            "5 0 9 10\n" +
            "6 13 0 12\n" +
            "8 8 9 0";

    static int N, minCost, costTable[][];

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(input.readLine());
        costTable = new int[N][N];

        StringTokenizer str;

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                costTable[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        boolean[] checked = new boolean[N];
        minCost = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            BT(0, 0, 0, 0, checked);
        }
        System.out.println(minCost);
    }

    public static void BT(int start, int cur, int index, int cost, boolean[] checked) {
        //System.out.println(start + " " + cur);
        // 다 돌은 경우
        if (index == N) {
            // 시작점에 제대로 도달한 경우
            if (cur == start) {
                //System.out.println(start + "에서 " + cost);
                minCost = Math.min(minCost, cost);
            }
            return;
        } else {
            // 다 돌기전에 시작점에 돌아오는 경우
            if (index > 0 && cur == start) {

                return;
            } else {

                for (int next = 0; next < N; next++) {
                    // 길이 있고 가본적 없으면 고고
                    if (costTable[cur][next] != 0 && !checked[next]) {
                        checked[next] = true;
                        BT(start, next, index + 1, cost + costTable[cur][next], checked);
                        checked[next] = false;
                    }
                }

            }
        }
    }
}
