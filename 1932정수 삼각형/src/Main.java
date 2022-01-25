import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 static StringBuilder output = new StringBuilder();
	 static String src = "5\n" +
			 "7\n" +
			 "3 8\n" +
			 "8 1 0\n" +
			 "2 7 4 4\n" +
			 "4 5 2 6 5";


	public static void main(String[] args) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		StringTokenizer str;
		int N = Integer.parseInt(input.readLine());

		int map[][] = new int[N][N];
		int dp[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(input.readLine());
			int j = 0;
			while (str.hasMoreTokens()) {
				map[i][j] = Integer.parseInt(str.nextToken());
				j++;
			}
		}
		dp[0][0] = map[0][0];
		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i - 1][0] + map[i][0];
			for (int j = 1; j < i+1 ; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + map[i][j];
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(dp[N - 1][i], answer);
		}
		System.out.println(answer);
	}
}
