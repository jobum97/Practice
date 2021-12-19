import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "6\n" +
            "1\n" +
            "4\n" +
            "2\n" +
            "3\n" +
            "30\n" +
            "0";
    static long dp[][];

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        //input = new BufferedReader(new StringReader(src));
        int N;
        dp = new long[31][31];
        dp[1][0] = 1;
        dp[2][0] = 2;
        dp[3][0] = 5;
        eat(30, 0);

        while ((N = Integer.parseInt(input.readLine())) != 0) {
            output.append(dp[N][0] + "\n");
        }
        System.out.println(output);

    }

    private static long eat(int one, int half) {

        //System.out.println(one + " " + half);
        // 한 알 짜리가 없으면(반 알만 남을 경우)
        if (one == 0)
            return 1;

        // dp에 이미 저장되어있다면
        if (dp[one][half] != 0)
            return dp[one][half];

        long cnt = 0;
        // 한 알이 있으면
        if (one != 0) {
            // 한 알 꺼내보기
            cnt += eat(one - 1, half + 1);
        }
        // 반 알이 있으면
        if (half != 0) {
            // 반 알 꺼내보기
            cnt += eat(one, half - 1);
        }

        return dp[one][half] = cnt;
    }


}
