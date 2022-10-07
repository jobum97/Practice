import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "11339";

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        int N = Integer.parseInt(input.readLine());

        //N을 최소 개수의 제곱수 합으로 표현할 때 최소 개수==?
        // 자연수는 모두 제곱수의 합으로 표현 가능
        // 1) 큰 것 부터 검사해보면서 greedy하게 가져가보자 =>X
        // 2) 작은 것 부터 DP로?
        int cnt = 0;
        int[] dp = new int[50001];

        for (int i = 1; i <= (int) Math.sqrt(50000); i++) {
            if (i == (int) Math.sqrt(i) * (int) Math.sqrt(i)) {
                dp[i] = 1;
            }
        }
        System.out.println(Arrays.toString(dp));
    }

    public static int subBiggestSquare(int N) {
        int s = (int) Math.sqrt(N);
        System.out.println(s + " " + (N - s * s));
        return N - s * s;
    }
}
