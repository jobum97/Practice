import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "4\n" +
            "1 10\n" +
            "3 15\n" +
            "1 3\n" +
            "4 8";
    static Ball balls[];

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        int N = Integer.parseInt(input.readLine());
        StringTokenizer str;
        balls = new Ball[N];

        for (int num = 0; num < N; num++) {
            str = new StringTokenizer(input.readLine());
            int color = Integer.parseInt(str.nextToken());
            int size = Integer.parseInt(str.nextToken());

            balls[num] = new Ball(num, color, size);
        }
        Arrays.sort(balls, (o1, o2) -> o1.size - o2.size);
        // 자기공보다 크기가 작고 색이 다른 공을 잡아 잡은 공의 크기 만큼 점수 획등
        // 다른 공은 변화 X
        // 공들의 색과 크기 주어질 경우 각 플레이어가 잡을 수 있는 공들의 크기 합

        // 전체 결과
        int[] result = new int[N];
        // 색 별로 누적합
        int[] colors = new int[N + 1];
        int ballIdx = 0;
        int sum = 0;
        for (int cur = 0; cur < N; cur++) {
            // 크기가 작다면
            while (balls[ballIdx].size < balls[cur].size) {
                sum += balls[ballIdx].size;
                colors[balls[ballIdx].color] += balls[ballIdx].size;
                ballIdx++;
            }
            result[balls[cur].idx] = sum - colors[balls[cur].color];
        }

        for (int i = 0; i < N; i++) {
            output.append(result[i]).append("\n");
        }
        System.out.print(output);
    }

    public static class Ball{
        int idx;
        int color;
        int size;

        public Ball(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }
    }

}
