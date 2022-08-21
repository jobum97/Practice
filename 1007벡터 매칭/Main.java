import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "2\n" +
            "4\n" +
            "5 5\n" +
            "5 -5\n" +
            "-5 5\n" +
            "-5 -5\n" +
            "2\n" +
            "-100000 -100000\n" +
            "100000 100000";

    static int T, N, points[][],totalX, totalY;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        T = Integer.parseInt(input.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            N = Integer.parseInt(input.readLine());
            points = new int[N][2];
            totalX = 0;
            totalY = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer str = new StringTokenizer(input.readLine());
                int x = Integer.parseInt(str.nextToken());
                int y = Integer.parseInt(str.nextToken());
                totalX += x;
                totalY += y;
                points[i][0] = x;
                points[i][1] = y;
            }
            // 점 (x1,y1), (x2,y2) 에서 벡터는 <x2-x1,y2-x1>
            // 모든 벡터의 합은 => 도착지 점들 좌표 - 출발지 점들 좌표
            // 출발지 와 도착지를 가르고 (20C10) 비교하는 방법으로 해결
            output.append(sol()).append("\n");
        }
        System.out.print(output);
    }
    public static double sol(){
        int M = N / 2;
        double min = Integer.MAX_VALUE;

        for (int i = 1; i < (1<<N); i++) {
            int endGroupX = 0;
            int endGroupY = 0;
            if (Integer.bitCount(i) == M) {
                for (int j = 0; j < N; j++) {
                    if (((1 << j) & i) > 0) {
                        endGroupX += points[j][0];
                        endGroupY += points[j][1];
                    }
                }
                int startGroupX = totalX - endGroupX;
                int startGroupY = totalY - endGroupY;

                double value = getVectorValue(startGroupX, startGroupY, endGroupX, endGroupY);
                //System.out.println(value);
                if (min > value) {
                    min = value;
                }
            }
        }
        return min;
    }

    public static double getVectorValue(int sX, int sY, int eX, int eY) {
        return Math.sqrt(Math.pow(eX - sX, 2) + Math.pow(eY - sY, 2));
    }
}
