import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "4 10 50\n" +
            "10 100 20 90\n" +
            "80 100 60 70\n" +
            "70 20 30 40\n" +
            "50 20 100 10";

    static int N, L, R, map[][], parent[][], sumAndCnt[][];

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken()); // 각 나라의 인구수
        L = Integer.parseInt(str.nextToken()); // 인구 이동의 기준
        R = Integer.parseInt(str.nextToken());

        map = new int[N + 1][N + 1];
        parent = new int[N][N];
        sumAndCnt = new int[2][N * N];

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        System.out.println(sol());
    }

    public static int sol(){
        int day = 0;

        initParent();

        // 인구이동이 멈출 때까지 반복
        while (canMove()) {
            // 국경선 열린 나라들 연합 이룸 => 인합의 인구수/연합의 칸 수 (소숫점 버림)
            // 합
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int p = find(parent[i][j]);
                    sumAndCnt[0][p] += map[i][j];
                    sumAndCnt[1][p]++;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int idx = find(i * N + j);
                    if (sumAndCnt[1][idx] > 0) {
                        map[i][j] = sumAndCnt[0][idx] / sumAndCnt[1][idx];
                    }
                }
            }

            day++;
            initParent();
        }
        return day;
    }
    public static void initParent(){
        int k = 0;
        Arrays.fill(sumAndCnt[0], 0);
        Arrays.fill(sumAndCnt[1], 0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                parent[i][j] = k++;
            }
        }
    }

    public static int find(int x){
        if (x == parent[x / N][x % N]) {
            return x;
        } else {
            return find(parent[x / N][x % N]);
        }
    }

    public static void union(int xRow, int xCol, int yRow, int yCol){
        int x = xRow * N + xCol;
        int y = yRow * N + yCol;
        x = find(x);
        y = find(y);

        //System.out.println(xRow + " " + xCol + " " + yRow + " " + yCol + " " + x + " " + y);
        if (x < y) {
            parent[y / N][y % N] = x;
        }else{
            parent[x / N][x % N] = y;
        }
    }

    public static boolean canMove(){
        boolean canMove = false;
        // 우, 아래 만 확인하면 4방향 다 확인하는 것
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 인접한 두나라의 인구 차이 L ~ R 이면 인구 인동
                int rightDiff = Math.abs(map[i][j] - map[i][j + 1]);
                int downDiff = Math.abs(map[i][j] - map[i + 1][j]);
               // System.out.println(i + " " + j + " " + rightDiff + " " + downDiff);
                if (j + 1 < N && rightDiff >= L && rightDiff <= R) {
                   // System.out.println("union " + i + " " + j + " + " + i + " " + (j + 1));
                    union(i, j, i, j + 1);
                    canMove = true;
                }

                if (i + 1 < N && downDiff >= L && downDiff <= R) {
                    //System.out.println("union " + i + " " + j + " + " + (i + 1) + " " + j);
                    union(i, j, i + 1, j);
                    canMove = true;
                }
            }
        }
        return canMove;
    }
}
