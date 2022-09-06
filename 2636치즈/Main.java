import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "13 12\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 1 1 0 0 0\n" +
            "0 1 1 1 0 0 0 1 1 0 0 0\n" +
            "0 1 1 1 1 1 1 0 0 0 0 0\n" +
            "0 1 1 1 1 1 0 1 1 0 0 0\n" +
            "0 1 1 1 1 0 0 1 1 0 0 0\n" +
            "0 0 1 1 0 0 0 1 1 0 0 0\n" +
            "0 0 1 1 1 1 1 1 1 0 0 0\n" +
            "0 0 1 1 1 1 1 1 1 0 0 0\n" +
            "0 0 1 1 1 1 1 1 1 0 0 0\n" +
            "0 0 1 1 1 1 1 1 1 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0";

    static int N, M, map[][], moveSet[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}, cheeseSize;
    static boolean checked[][];

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        map = new int[N][M];
        checked = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        sol();
    }

    public static void sol() {
        // 공기에 접촉된 칸은 1시간 지나면 녹음
        // 치즈 내부의 공기 있을 경우 케이스 고려해야함

        // 0 은 공기 1은 치즈
        // -1은 외부 공기
        // 최초 init() 으로 외부 공기 내부공기 구분해주고
        // 시간의 흐름에 따라 치즈와 내부공기를 외부공기로 바꿔가면서 더이상 바꿀게 없으면 끝내는 것
        int time = 0;
        insideAirSpread(0, 0);
        while(!isOver()){
            time++;
            melt();
        }
        System.out.println(time);
        System.out.println(cheeseSize);
    }

    public static void printMap(){
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println("-------------------------------");
    }

    public static void melt(){
        LinkedList<Coord> meltList = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 간적 없고 외부 공기가 아닌 경우 외부공기화
                if (!checked[i][j] && map[i][j] != -1) {
                    for (int k = 0; k < 4; k++) {
                        int nextRow = i + moveSet[k][0];
                        int nextCol = j + moveSet[k][1];

                        // 맵 벗어나면 멈춰
                        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
                            continue;
                        }

                        // 외부 공기와 접촉시 외부공기화 하고 넘기기
                        if (map[nextRow][nextCol] == -1) {
                            meltList.add(new Coord(i, j));
                            break;
                        }
                    }
                }
            }
        }
        cheeseSize = meltList.size();
        // 치즈 녹이고
        while (!meltList.isEmpty()) {
            Coord cur = meltList.poll();
            map[cur.row][cur.col] = -1;
            checked[cur.row][cur.col] = true;
        }

        // 외부 공기와 닿은 내부 공기있으면 외부공기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!checked[i][j] && map[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int nextRow = i + moveSet[k][0];
                        int nextCol = j + moveSet[k][1];

                        // 맵 벗어나면 멈춰
                        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
                            continue;
                        }

                        // 외부 공기와 접촉시 외부공기화 하고 넘기기
                        if (map[nextRow][nextCol] == -1) {
                            insideAirSpread(i, j);
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void insideAirSpread(int sR, int sC){
        // 외부 공기 내부공기 구분
        LinkedList<Coord> pq = new LinkedList<>();
        pq.add(new Coord(sR, sC));
        while (!pq.isEmpty()) {
            Coord cur = pq.poll();
            // 오염 공기
            map[cur.row][cur.col] = -1;

            for (int i = 0; i < moveSet.length; i++) {
                int nextRow = cur.row + moveSet[i][0];
                int nextCol = cur.col + moveSet[i][1];

                // 맵 벗어나면
                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
                    continue;
                }

                // 가 본 적 없고
                if (!checked[nextRow][nextCol] && map[nextRow][nextCol] == 0) {
                    pq.add(new Coord(nextRow, nextCol));
                    checked[nextRow][nextCol] = true;
                }
            }
        }
    }
    public static boolean isOver(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != -1) {
                    return false;
                }
            }
        }
        return true;
    }
    public static class Coord{
        int row;
        int col;

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
