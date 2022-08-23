import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "3";
    static int N, Mod = 1000000000;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        N = Integer.parseInt(input.readLine());

        int full = (1 << 10) - 1;
        long dp[][][] = new long[N + 1][11][1 << 10];

        // 0을 제외한 1~9까지를 1로 초기화함, 0은 시작 숫자가 될 수 없기에 제외
        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        // 높이 2부터 탐색
        for (int i = 2; i <= N; i++) {

            //이전 단계의 숫자 사용 여부를 기준으로 다음 단계 계산
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= full; k++) {
                    int bit = k | (1 << j);
                    // 이전 단계 숫자가 0이였으면 1이였어야함
                    if (j == 0) {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k]) % Mod;
                    } else if (j == 9) {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k]) % Mod;
                    } else {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k] + dp[i - 1][j - 1][k]) % Mod;
                    }
                }
            }
        }

        long ans = 0;
        for (int i = 0; i <= 9; i++) {
            System.out.println(Arrays.toString(dp[N][i]));
            ans = (ans + dp[N][i][full]) % Mod;
        }

        System.out.println(ans);
    }
}
