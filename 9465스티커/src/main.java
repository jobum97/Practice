import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "2\n" +
            "5\n" +
            "50 10 100 20 40\n" +
            "30 50 70 10 60\n" +
            "7\n" +
            "10 30 10 50 100 20 40\n" +
            "20 40 30 50 60 20 80";

    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        int tc = Integer.parseInt(input.readLine());

        for (int testcase = 1; testcase <= tc; testcase++) {
            int length = Integer.parseInt(input.readLine());
            int data[][] = new int[2][length+1];
            int dp[][] = new int[2][length+1];


            for (int i = 0; i < 2; i++) {
                StringTokenizer str = new StringTokenizer(input.readLine());
                for (int j = 1; j <= length; j++) {
                    data[i][j] = Integer.parseInt(str.nextToken());
                }
                //System.out.println(Arrays.toString(data[i]));
            }

            dp[0][1] = data[0][1];
            dp[1][1] = data[1][1];

            for (int i = 2; i <= length; i++) {
                dp[0][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + data[0][i];
                dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + data[1][i];
            }


//            for (int i = 0; i < 2; i++) {
//                System.out.println(Arrays.toString(dp[i]));
//            }
//            System.out.println("=======================");
            output.append(Math.max(dp[0][length], dp[1][length]) + "\n");
        }
        System.out.print(output);
    }
}
