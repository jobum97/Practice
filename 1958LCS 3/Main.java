import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {
    static BufferedReader input;
    static String src = "dababcf\n" +
            "ababdef\n" +
            "df\n";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        String firstStr = input.readLine();
        String secondStr = input.readLine();
        String thirdStr = input.readLine();

        int dp[][][] = new int[firstStr.length() + 1][secondStr.length() + 1][thirdStr.length() + 1];

        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                for (int k = 1; k < dp[0][0].length; k++) {
                    if (firstStr.charAt(i - 1) == secondStr.charAt(j - 1) && secondStr.charAt(j - 1) == thirdStr.charAt(k - 1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                        max = Math.max(dp[i][j][k], max);
                    }else{
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
