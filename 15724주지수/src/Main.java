import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="4 4\n" +
			"9 14 29 7\n" +
			"1 31 6 13\n" +
			"21 26 40 16\n" +
			"8 38 11 23\n" +
			"3\n" +
			"1 1 3 2\n" +
			"1 1 1 4\n" +
			"1 1 4 4";
	
	static int N,M;
	static int[][] map,dp;

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		StringTokenizer str;

		str = new StringTokenizer(input.readLine());

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		map = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			str = new StringTokenizer(input.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		/////////맵 데이터 입력 부분까지/////////

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = map[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("#####################");
		for (int i = 1; i <= N; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}

		int t = Integer.parseInt(input.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			str = new StringTokenizer(input.readLine());

			int x1 = Integer.parseInt(str.nextToken());
			int y1 = Integer.parseInt(str.nextToken());
			int x2 = Integer.parseInt(str.nextToken());
			int y2 = Integer.parseInt(str.nextToken());

			output.append(dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1] + "\n");
		}

		System.out.println(output);
	}

}
