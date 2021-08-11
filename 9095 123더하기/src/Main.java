import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="3\r\n"
			+ "4\r\n"
			+ "7\r\n"
			+ "10";
	
	static int n;
	static int result=0;
	static int[] dp;

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

        int t = Integer.parseInt(input.readLine());

        dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 11; i++) {
            //sol(0, i);
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        //System.out.println(Arrays.toString(dp));

        for (int testcase = 1; testcase <= t; testcase++) {
            output.append(dp[Integer.parseInt(input.readLine())]+"\n");
        }
        System.out.println(output);
	}

	public static void sol(int num, int target){
        if(num>target){
            return;
        }
        if (num == target) {
            dp[target]++;
        }
	    sol(num + 1, target);
        sol(num + 2, target);
        sol(num + 3, target);
    }

}
