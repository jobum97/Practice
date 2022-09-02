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
    static ArrayList<Fish> fishList;
    static PriorityQueue<Fish> fishQueue;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        N = Integer.parseInt(input.readLine());

        map = new int[N + 1][N + 1];
        StringTokenizer str;
        fishList = new ArrayList<>();
        fishQueue = new PriorityQueue<>();
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
        shark_stack = 0;

        sol();
    }

    public static void sol() {
        // 아기 상어 크기 2
        // 자기 보다 작은 것만 먹을 수 있음 + 자기 보다 큰 물고기 있는 칸은 지나갈 수 없음
        // 자기 보다 작은 놈 없으면 엄마 상어 부름
        // 먹을 놈들 중 거리가 같다면 가장위, 가장 왼쪽부터 먹는다
        int time = 0;

        Comparator<Fish> fishComparator = new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                int dist1 = (shark_row - o1.row) * (shark_row - o1.row) + (shark_col - o1.col) * (shark_col - o1.col);
                int dist2 = (shark_row - o2.row) * (shark_row - o2.row) + (shark_col - o2.col) * (shark_col - o2.col);

                // 거리 오름차순으로 정렬
                // 거리 같으면 가장 위
                if (dist1 == dist2) {
                    // 같은 행이면 가장 앞쪽
                    if (o1.row == o2.row) {
                        return o1.col - o2.col;
                    } else {
                        return o1.row - o2.row;
                    }
                } else {
                    return dist1 - dist2;
                }
            }
        };

        Collections.sort(fishList, fishComparator);

        for (int i = 0; i < fishList.size(); i++) {
            System.out.println(fishList.get(i).row + " " + fishList.get(i).col + " " + fishList.get(i).size);
        }

        while (true) {
            // 먹을 물고기 없으면 멈춰
            if (fishList.get(0).size >= shark_size) {
                break;
            }

            Fish fish = fishList.get(0);
            int dist = Math.abs(shark_col - fish.col) + Math.abs(shark_row - fish.row);
            time += dist;
            shark_row = fish.row;
            shark_col = fish.col;

            Collections.sort(fishList, fishComparator);
        }

    }

    public static void move(int size){
        while (fishQueue.peek().size <= size) {
            fishList.add(fishQueue.poll());
        }
    }


    public static class Fish implements Comparable<Fish>{
        int row;
        int col;
        int size;

        public Fish(int row, int col, int size) {
            this.row = row;
            this.col = col;
            this.size = size;
        }

        @Override
        public int compareTo(Fish o) {
            return this.size - o.size;
        }
    }
}
