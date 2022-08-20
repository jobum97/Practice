import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "100 0 1\n" +
            "2 26 75\n";
    static int N, M, K;
    static long segmentTree[], arr[];

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());


        arr = new long[N + 1];
        segmentTree = new long[N * 4 + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        init(1, N, 1);

       // System.out.println(Arrays.toString(segmentTree));

        for (int i = 0; i < M + K; i++) {
            str = new StringTokenizer(input.readLine());
            int order = Integer.parseInt(str.nextToken());
            int s = Integer.parseInt(str.nextToken());
            long e = Long.parseLong(str.nextToken());

            if (order == 1) {
                long diff = e - arr[s];
                arr[s] = e;
                update(1, N, 1, s, diff);
                System.out.println(Arrays.toString(segmentTree));
            } else if (order == 2) {
                output.append(interval_sum(1, N, 1, s, (int) e)).append("\n");

                //System.out.println(interval_sum(0, N - 1, 1, s, (int) e));
            }
        }
        System.out.print(output);
    }

    public static long init(int start, int end, int index){
        if (start == end) {
            return segmentTree[index] = arr[start];
        }
        int mid = (start + end) / 2;

        return segmentTree[index] = init(start, mid, index * 2) + init(mid + 1, end, index * 2 + 1);
    }

    // start: 시작, end: 마지막, left, right: 구하고자 하는 구간
    public static long interval_sum(int start, int end, int index, int left, int right){
        System.out.println(start + " " + end + " " + index);
        // 범위 초과한 경우
        if (left > end || right < start) {
            System.out.println("펑");
            return 0;
        }
        if (left <= start && right >= end) {
            System.out.println("return " + segmentTree[index]);
            return segmentTree[index];
        }
        int mid = (start + end) / 2;
        // start 와 end 가 변하면서 구간 합인 부분을 더해준다고 생각
        return interval_sum(start, mid, index * 2, left, right) + interval_sum(mid + 1, end, index * 2 + 1, left, right);
    }

    // start: 시작 인덱스, end: 마지막 인덱스, what: 구간합을 수정해주고자 하는 노드, value 수정 값
    public static void update(int start, int end, int index, int what, long diff) {

        //범위 벗어나면 아웃
        if (what < start || what > end) {
            return;
        }

        segmentTree[index] += diff;
        // 끝 도달시 멈춰
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, index * 2, what, diff);
        update(mid + 1, end, index * 2 + 1, what, diff);
    }

}
