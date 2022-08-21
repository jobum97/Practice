import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "40 0\n" +
            "100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000\n";

    static int N, S;
    static long data[];
    static List<Long> left = new ArrayList<>();
    static List<Long> right = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        S = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(input.readLine());
        data = new long[N];
        for (int i = 0; i < N; i++) {
            data[i] = Long.parseLong(str.nextToken());
        }

        getSubsequence(0,N/2,0,left);
        getSubsequence(N/2,N,0,right);

        Collections.sort(left);
        Collections.sort(right);

        long cnt = getCnt();
        if(S==0){
            cnt--;
        }

        //부분 수열 = 증가 수열, 연속일 필요X
        System.out.println(cnt);
    }

    public static void getSubsequence(int idx, int end, long sum, List<Long> list){
        if (idx == end) {
            list.add(sum);
            return;
        }

        getSubsequence(idx + 1, end, sum + data[idx], list);
        getSubsequence(idx + 1, end, sum, list);
    }

    public static long getCnt() {

        int pl = 0;
        int pr = right.size() - 1;
        long cnt = 0;

        while (pl < left.size() && pr >= 0) {

            long sum = left.get(pl) + right.get(pr);

            if (sum == S) {
                long a = left.get(pl);
                long cnt1 = 0;
                while (pl < left.size() && left.get(pl) == a) {
                    pl++;
                    cnt1++;
                }

                long b = right.get(pr);
                long cnt2 = 0;
                while (pr >= 0 && right.get(pr) == b) {
                    pr--;
                    cnt2++;
                }

                cnt += cnt1 * cnt2;
            }

            else if (sum < S)
                pl++;
            else
                pr--;
        }

        return cnt;
    }

}
