import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "4\n" +
            "4 3 2 1\n" +
            "0 0 0 0\n" +
            "0 0 9 0\n" +
            "1 2 3 4";

    static int N, map[][], shark_row, shark_col, shark_size, shark_stack;
    static PriorityQueue<Fish> fishList;
    static PriorityQueue<Fish> fishQueue;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        N = Integer.parseInt(input.readLine());

        map = new int[N + 1][N + 1];
        StringTokenizer str;
        fishList = new PriorityQueue<>(new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                return o1.size - o2.size;
            }
        });
        fishQueue = new PriorityQueue<>(new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                if (o1.row == o2.row) {
                    return o1.col - o2.col;
                }
                return o1.row - o2.row;
            }
        });
        for (int i = 1; i <= N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
                if (map[i][j] == 9) {
                    shark_row = i;
                    shark_col = j;
                } else if (map[i][j] != 0) {
                    fishQueue.add(new Fish(i, j, map[i][j]));
                }
            }
        }
        shark_size = 1;
        shark_stack = 0;

        sol();
    }

    public static void sol() {
        // 아기 상어 크기 2
        // 자기 보다 작은 것만 먹을 수 있음 + 자기 보다 큰 물고기 있는 칸은 지나갈 수 없음
        // 자기 보다 작은 놈 없으면 엄마 상어 부름
        // 먹을 놈들 중 거리가 같다면 가장위, 가장 왼쪽부터 먹는다

        //먹을 수 있는 놈들 중에서 거리랑 위치를 따져가면서 먹는다
        // => FishList 에서는 무게별로 리스트 확보
        // 시간

    }

    public static void eat(){
        // 먹었을 때 아기상어의 사이즈 만큼 먹었으면 사이즈업
        if (shark_size == ++shark_stack) {
            shark_size++;
            shark_stack = 0;
        }



    }

    public static void move(int size){

    }


    public static class Fish{
        int row;
        int col;
        int size;

        public Fish(int row, int col, int size) {
            this.row = row;
            this.col = col;
            this.size = size;
        }
    }
}
