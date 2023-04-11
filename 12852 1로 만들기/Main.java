import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "10";
    static int N;
    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        N = Integer.parseInt(input.readLine());

        // X가 3으로 나누어 떨어지면, 3으로 나눈다.
        // X가 2로 나누어 떨어지면, 2로 나눈다.
        // 1을 뺀다.


        // N ==> 1 로 만드는 최소 연산
        // 연산 과정에서 거쳐가는 수

        // 역으로 생각하면 2,3 곱하고 +1 가능한 상태에서 최소 연산과 같지 않을까?
        int dp[] = new int[1000001];
        int mem[] = new int[1000001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        mem[2] = 2;
        mem[3] = 3;

        for (int i = 4; i <= N; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                if (dp[i / 3] + 1 > dp[i / 2] + 1) {
                    dp[i] = dp[i / 2] + 1;
                    mem[i] = 2;
                } else {
                    dp[i] = dp[i / 3] + 1;
                    mem[i] = 3;
                }
            }else if (i % 3 == 0) {
                dp[i] = dp[i / 3] + 1;
                mem[i] = 3;
            } else if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 1;
                mem[i] = 2;
            }
            if (dp[i] > dp[i - 1] + 1) {
                dp[i] = dp[i - 1] + 1;
                mem[i] = 1;
            }
        }

        output.append(dp[N]).append("\n");
        int num = N;
        while (num != 1) {
            output.append(num).append(" ");
            if (mem[num] == 1) {
                num -= 1;
            } else {
                num /= mem[num];
            }
        }
        output.append(num);
        System.out.println(output);
    }

}
