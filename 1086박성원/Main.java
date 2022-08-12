import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "3\n" +
            "3\n" +
            "2\n" +
            "1\n" +
            "2";

    static int N, K;
    static long nums[];
    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        N = Integer.parseInt(input.readLine());
        nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(input.readLine());
        }
        K = Integer.parseInt(input.readLine());

        // 집합의 순열을 합쳐서 만들었을 때 K 로 나눠떨어지는 순열을 구할 때
        // 맞출 수 있는 확률
        // 즉 순열 합이 K로 나눠떨어지는 경우의 수 / 전체 경우의 수

        for (int i = 0; i < N; i++) {
            nums[i] %= K;
        }
        permutation(0);

        System.out.println(Arrays.toString(nums));

    }

    public static void permutation(int depth) {
        if (depth == N) {
            System.out.println(Arrays.toString(nums));
        }

        for (int i = depth; i < N; i++) {
            swap(depth, i);
            permutation(depth+1);
            swap(i, depth);
        }

    }

    public static void swap(int i, int j) {
        long temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static class Point implements Comparable<Point>{
        int cost;
        int x;
        int y;

        public Point(int cost, int x, int y) {
            this.cost = cost;
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point i){
            return this.cost - i.cost;
        }
    }

}
