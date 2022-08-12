import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "10 4\n" +
            "75\n" +
            "30\n" +
            "100\n" +
            "38\n" +
            "50\n" +
            "51\n" +
            "52\n" +
            "20\n" +
            "81\n" +
            "5\n" +
            "1 10\n" +
            "3 5\n" +
            "6 9\n" +
            "8 10";

    static int N, M;

    static int segmentTree[], data[];

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        data = new int[N + 1];
        segmentTree = new int[N * 4 + 1];
        for (int i = 1; i <= N; i++) {
            data[i] = Integer.parseInt(input.readLine());
        }
        init(1, N, 1);
        System.out.println(Arrays.toString(segmentTree));

        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(input.readLine());
            int s = Integer.parseInt(str.nextToken());
            int e = Integer.parseInt(str.nextToken());
            output.append(findMin(1, N, 1, s, e)).append("\n");

        }

        System.out.print(output);
    }

    public static int init(int start, int end, int idx) {

        if (start == end) {
            return segmentTree[idx] = data[start];
        }

        int mid = (start + end) / 2;
        return segmentTree[idx] = Math.min(init(start, mid, idx * 2), init(mid + 1, end, idx * 2 + 1));
    }

    public static int findMin(int start, int end, int idx, int left, int right) {
       // System.out.println(start+" "+end+" "+idx);
        if (right < start || end < left) {
            return Integer.MAX_VALUE;
        }

        if (left <= start && right >= end) {
            return segmentTree[idx];
        }
        int mid = (start + end) / 2;

        return Math.min(findMin(start, mid, idx * 2, left, right), findMin(mid + 1, end, idx * 2 + 1, left, right));
    }
}
