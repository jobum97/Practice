import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "ABRACADABRA\n" +
            "ECADADABRBCRDARA";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        String firstStr = input.readLine();
        String secondStr = input.readLine();

        int[][] dp = new int[firstStr.length() + 1][secondStr.length() + 1];

        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (firstStr.charAt(i - 1) == secondStr.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        System.out.println(max);
    }
}
