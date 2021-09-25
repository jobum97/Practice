import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "ABAB\n" +
            "AAB";

    //LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때,
    // 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
    //예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        String input1 = input.readLine();
        String input2 = input.readLine();
        //System.out.println(input1+" "+input2);

        //LCS(input1, input2);
        //System.out.println(Math.max(LCS(input1,input2),LCS(input2,input1)));

        System.out.println(LCS_DP(input1, input2));
    }

    public static int LCS_DP(String input1, String input2) {


        int[][] DP = new int[input2.length() + 1][input1.length() + 1];

        for (int i = 1; i < DP.length; i++) {
            for (int j = 1; j < DP[0].length; j++) {

                if (input1.charAt(j - 1) == input2.charAt(i - 1)) {
                    System.out.println(i + " " + j + " " + input1.charAt(j - 1));
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i][j - 1], DP[i - 1][j]);
                }
            }
        }

        for (int i = 0; i < DP.length; i++) {
            System.out.println(Arrays.toString(DP[i]));
        }

        return DP[input2.length()][input1.length()];
    }

}
