import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "3 7\n" +
            "4 0 0 0 0 0 0\n" +
            "0 6 0 5 0 6 0\n" +
            "0 0 0 0 0 0 4";

    static int N, M, map[][], moveSet[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static int[][][] seeDirs = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 1}, {2, 3}},
            {{0, 2}, {0, 3}, {1, 2}, {1, 3}},
            {{0, 2, 3}, {0, 1, 3}, {0, 1, 2}, {1, 2, 3}},
            {{1,2,3,4}}
    };
    static ArrayList<ArrayList<CCTV>> cctvList;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        map = new int[N][M];
        cctvList = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            cctvList.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvList.get(map[i][j]).add(new CCTV(i, j));
                }
            }
        }

        // cctv 의 개수는 최대 8, cctv의 행동 가짓 수 4, 2, 4, 4, 1 => 최대 4^8 가지
        // greedy 하게 선택하는 것은 어떨까?
        // 현재 상황에서 가장 많이 체크할 수 있는 경우를 선택한다면??

        // cctv 종류
        for (int cctv = 5; cctv > 0; cctv--) {
            // cctv 종류에 해당하는 cctv 처리
            for (int idx = 0; idx < cctvList.get(cctv).size(); idx++) {

                for (int seeIdx = 0; seeIdx < seeDirs[cctv].length; seeIdx++) {

                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

    }

    public static void chooseBest(){

    }

    public static void see(int row, int col, int dir) {
        // 안에서 벽에 부딪힐 때까지 탐색하며 맵 수정
        int nextRow = row + moveSet[dir][0];
        int nextCol = col + moveSet[dir][1];
        while (nextRow < N && nextRow >= 0 && nextCol < M && nextCol >= 0) {

            //벽 부딪힘
            if (map[nextRow][nextCol] == 6) {
                break;
            }

            map[nextRow][nextCol] = -1;

            nextRow += moveSet[dir][0];
            nextCol += moveSet[dir][1];
        }
    }

    public static int countBlank(){
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static class CCTV{
        int row;
        int col;

        public CCTV(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}

