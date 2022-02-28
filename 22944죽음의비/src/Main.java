import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4 10 4\n" +
            "S..U\n" +
            "....\n" +
            "....\n" +
            "...E";

    static int N, HP, umbrellaHP, startRow, startCol, endRow, endCol, answer;
    static boolean visited[];
    static int moveSet[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<int[]> umbrellaList;
    static char map[][];

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken()); //정사각형 한변길이
        HP = Integer.parseInt(str.nextToken()); // 현재 체력
        umbrellaHP = Integer.parseInt(str.nextToken()); // 내구도도

        umbrellaList = new ArrayList<>();
        answer = Integer.MAX_VALUE;
        visited = new boolean[11]; // 우산 개수 최대 10

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = input.readLine().toCharArray();
            //System.out.println(Arrays.toString(map[i]));
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                }
                if (map[i][j] == 'E') {
                    endRow = i;
                    endCol = j;
                }
                if (map[i][j] == 'U') {
                    umbrellaList.add(new int[]{i, j});
                }
            }
        }

        sol(startRow, startCol, HP, 0, 0);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void sol(int row, int col, int hp, int umbHP, int cnt) {
        if (Math.abs(endRow - row) + Math.abs(endCol - col) <= hp + umbHP) {
            answer = Math.min(answer, cnt + Math.abs(endRow - row) + Math.abs(endCol - col));
            return;
        }
        for(int i=0;i<umbrellaList.size();i++) {
            // 현재 위치랑 우산 거리 구하기
            int dis = Math.abs(umbrellaList.get(i)[0] - row) + Math.abs(umbrellaList.get(i)[1] - col);
            // 우산까지 가기에 HP가 부족하거나 이미 사용한 우산이면 컷
            if(hp + umbHP <= dis-1 || visited[i] == true)
                continue;

            //우산 hp가 부족하다면 hp 까고 우산 도달 아니면 보존
            if(umbHP < dis) {
                visited[i] = true;
                sol(umbrellaList.get(i)[0], umbrellaList.get(i)[1], hp - (dis - umbHP), umbrellaHP, cnt + dis);
                visited[i] = false;
            } else {
                visited[i] = true;
                sol(umbrellaList.get(i)[0], umbrellaList.get(i)[1], hp, umbrellaHP, cnt + dis);
                visited[i] = false;
            }
        }
    }

    static class Coord{
        int row;
        int col;

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
