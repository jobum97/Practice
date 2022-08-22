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

        getSubsequence(0,N/2,0,left); // 앞쪽 절반 모든 부분 수열의 합들 구하기
        getSubsequence(N/2,N,0,right); // 뒤쪽 절반 모든 부분 수열의 합들 구하기

        // 둘 다 오름차순으로 정렬
        Collections.sort(left);
        Collections.sort(right);

        //투 포인터 알고리즘으로 답을 구한다
        long cnt = getCnt();

        // 공집합끼리 더해 0이 되는 경우가 답에 섞일 경우 count--
        if(S==0){
            cnt--;
        }

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

    // 투 포인터 알고리즘으로 0이 되는 경우 구하기
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
