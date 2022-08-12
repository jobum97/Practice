import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "4 1 2\n" +
            "1000000\n" +
            "1000000\n" +
            "1000000\n" +
            "1000000\n" +
            "2 1 4\n" +
            "1 2 1\n" +
            "2 1 4";

    static int N, M, K, INF = 1000000007;
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
            arr[i] = Long.parseLong(input.readLine());
        }

        init(1, N, 1);
        //System.out.println(Arrays.toString(segmentTree));
        for (int i = 0; i < M + K; i++) {
            str = new StringTokenizer(input.readLine());
            int order = Integer.parseInt(str.nextToken());
            int s = Integer.parseInt(str.nextToken());
            long e = Long.parseLong(str.nextToken());

            if (order == 1) {
                arr[s] = e;
                update(1, N, 1, s, e);
               // System.out.println(Arrays.toString(segmentTree));
            } else if (order == 2) {
                output.append(interval_mul(1, N, 1, s, (int) e)).append("\n");
            }
        }
        System.out.print(output);

    }

    public static long init(int start, int end, int idx) {
        //System.out.println(start+" "+end+" "+idx);
        if (start == end) {
            return segmentTree[idx] = arr[start];
        }
        int mid = (start + end) / 2;
        return segmentTree[idx] = (init(start, mid, idx * 2) * init(mid + 1, end, idx * 2 + 1) % INF);
    }

    public static long update(int start, int end, int idx, int what, long diff) {
        if (what < start || what > end) {
            return segmentTree[idx];
        }

        if (start == end) {
            return segmentTree[idx] = diff;
        }
        int mid = (start + end) / 2;
        return segmentTree[idx] = (update(start, mid, idx * 2, what, diff) * update(mid + 1, end, idx * 2 + 1, what, diff)) % INF;
    }

    public static long interval_mul(int start, int end, int idx, int left, int right) {
        if (left > end || right < start) {
            return 1;
        }

        if (left <= start && right >= end) {
            return segmentTree[idx];
        }

        int mid = (start + end) / 2;
        return ((interval_mul(start, mid, idx * 2, left, right) * interval_mul(mid + 1, end, idx * 2 + 1, left, right)) % INF);
    }
}
