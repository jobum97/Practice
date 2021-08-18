import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="6\r\n"
			+ "10\r\n"
			+ "20\r\n"
			+ "15\r\n"
			+ "25\r\n"
			+ "10\r\n"
			+ "20";

	static int stairs;
	static int[] data;
	static int[][] dp;

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		stairs = Integer.parseInt(input.readLine());

		data = new int[stairs + 1];
		dp = new int[stairs + 1][3];

		for (int i = 1; i <= stairs; i++) {
			data[i] = Integer.parseInt(input.readLine());
		}

		dp[1][1] = data[1];

		for (int i = 2; i <= stairs; i++) {
			dp[i][1] = Math.max(dp[i - 2][2] + data[i], dp[i - 2][1] + data[i]); // 1개밟은 상태로 오는 것 == 2칸 이동
			dp[i][2] = dp[i - 1][1] + data[i]; // 연속 2개 밟는 상태로 오는 것 1개 밟은 상태에서 1칸 이동
		}
		/*for (int i = 1; i <= stairs; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}*/

		System.out.println(Math.max(dp[stairs][1], dp[stairs][2]));
	}

}
