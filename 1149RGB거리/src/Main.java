import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "3\n" +
            "26 40 83\n" +
            "49 60 57\n" +
            "13 89 99";
    static int[][] costData, DP;
    static int N, minCost;

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(input.readLine()); //집의 수

        costData = new int[N + 1][3];
        DP = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer str = new StringTokenizer(input.readLine());
            int redCost = Integer.parseInt(str.nextToken());
            int greenCost = Integer.parseInt(str.nextToken());
            int blueCost = Integer.parseInt(str.nextToken());
            costData[i][0] = redCost;
            costData[i][1] = greenCost;
            costData[i][2] = blueCost;
        }
        //1번집과 2번집 색 같으면 안됨
        // N번집의 색과 n-1집의 색같으면 안됨
        // i번 집의 색은 i-1 ,i+1 색같으면 안됨 => 즉 인접 집과 색 다르게
        minCost = Integer.MAX_VALUE;
        //sol(-1, 1, 0);
        DP[1][0] = costData[1][0];
        DP[1][1] = costData[1][1];
        DP[1][2] = costData[1][2];
        int temp = 0;
        for (int i = 2; i <= N; i++) {
            for (int cur = 0; cur < 3; cur++) {
                temp = Integer.MAX_VALUE;
                for (int before = 0; before < 3; before++) {
                    if (cur == before) {
                        continue;
                    }
                    temp = Math.min(DP[i - 1][before] + costData[i][cur], temp);
                }
                DP[i][cur] = temp;
            }
        }

        for (int i = 0; i < 3; i++) {
            minCost = Math.min(minCost, DP[N][i]);
        }

        System.out.println(minCost);

    }

    public static void sol(int back, int index, int cost) {

        //System.out.println(back + " " + index);

        if (index > N) {
            minCost = Math.min(cost, minCost);
            return;
        }

        for (int next = 0; next < 3; next++) {
            if (back == next) {
                continue;
            }
            sol(next, index + 1, cost + costData[index][next]);
        }


    }




}
