import java.util.Arrays;

public class Main {
    static long[][] combi;
    static long Mod = (long) (Math.pow(10, 7) + 19);
    public static void main(String[] args) {

        int[][] a = {{1, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 1}};
        System.out.println("한글");
        System.out.println(solution(a));
    }


    //2차원 배열 b의 경우의 수를 (10^7+19)로 나눈 나머지 리턴
    public static int solution(int[][] a) {
        //b는 0,1로 이루어짐, a와 크기 같음
        //a의 i번째 열과 b의 i번째 열에 들어있는 1의 개수 동일
        //b의 각 행에 들어있는 1의 개수 짝수 (0포함)

        int n = a.length;
        int m = a[0].length;
        combi = new long[301][301];
        for (int i = 0; i < 301; i++) {
            Arrays.fill(combi[i], -1);
        }

        //j번째 열의 1의 개수 세는 것
        int[] oneCnts = new int[m + 1];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                oneCnts[j + 1] += a[i][j];
            }
        }
        System.out.println(Mod);
        System.out.println(Arrays.toString(oneCnts));

        //dp[colum][num] = arr[0~n][[0~column] 까지 num개의 행이 짝수인 경우
        long[][] dp = new long[m + 1][n + 1];
        dp[1][n - oneCnts[1]] = Combination(n, oneCnts[1]);

        for (int column = 1; column <= m; column++) {
            int oneCnt = oneCnts[column]; //arr 배열에서 column 열의 1의 개수
            for (int num = 0; num <= n; num++) { //세팅된 짝수 행의 개수
                //기존에 있던 행에서 짝수개의 1을 가지느 행에 세팅하고자 하는 개수
                for (int k = 0; k <= oneCnt; k++) {
                    // 기존에 있던 행 중 홀수개의 1을 가진 행에 1을 세팅하고자 하는 개수. = column 열이 가진 1의 개수 중 짝수개를 가진 행에 세팅할 1을 뺀 나머지.
                    int willSetOddRow = oneCnt - k;
                    // 1을 세팅하고 난 뒤 1을 짝수개 가진 행의 개수 = 짝수행 중 1을 세팅하지 않는 행 + 홀수행 중 1을 세팅하는 행
                    int willBeEvenRowCnt = (num - k) + willSetOddRow;

                    if (willSetOddRow < 0 || willBeEvenRowCnt > n || willBeEvenRowCnt < 0)
                        continue; // IMPOSSIBLE

                    // 경우의 수 = 짝수행에 1을 세팅하는 경우의 수 * 홀수행에 1을 세팅하는 경우의 수 % MOD
                    long numOfCase = (Combination(num, k) * Combination(n - num, oneCnt - k)) % Mod;
                    dp[column][willBeEvenRowCnt] += dp[column-1][num] * numOfCase % Mod;
                    dp[column][willBeEvenRowCnt] %= Mod;
                }

            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return (int) dp[m][n];
    }

    public static Long Combination(int n, int r) {
        if (n < r) {
            return 0L;
        }
        long ret = combi[n][r];
        if (ret != -1) {
            return ret;
        }
        if (n == r || r == 0) {
            return ret = 1;
        }

        return ret = ((Combination(n - 1, r - 1) + Combination(n - 1, r)) % Mod);
    }

}