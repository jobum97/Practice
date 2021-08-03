import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src ="1000000";
	
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		int N = Integer.parseInt(input.readLine());

		int[] dp =new int[1000001];

		dp[1]=0;
		dp[2]=1;
		dp[3]=1;

		for (int i = 4; i < N + 1; i++) {
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i - 1] + 1);
				if (i % 2 == 0) {
					dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
				}
			} else if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
			} else {
				dp[i] = dp[i - 1] + 1;
			}
		}

		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
		
		
	}
}
		