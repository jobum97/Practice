import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="6 6\n" +
			"0 0 0 1 0 0\n" +
			"0 0 0 2 1 0\n" +
			"0 0 2 0 0 0\n" +
			"0 1 0 0 0 0\n" +
			"2 0 0 0 0 0\n" +
			"0 0 0 0 0 0";
	
	static int N, M;
	static int[][] dp;

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		StringTokenizer str = new StringTokenizer(input.readLine());

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		dp = new int[N + 1][M + 1];
		int Max = 0;

		for (int i = 1; i < N + 1; i++) {
			str = new StringTokenizer(input.readLine());
			for (int j = 1; j < M + 1; j++) {
				if (Integer.parseInt(str.nextToken()) == 0) {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					Max = Math.max(Max, dp[i][j]);
				}
			}
		}

		for (int i = 0; i < N + 1; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}

		System.out.println(Max);
	}


}