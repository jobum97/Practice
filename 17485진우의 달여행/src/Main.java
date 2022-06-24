import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "6 4\n" +
			"5 8 5 1\n" +
			"3 5 8 4\n" +
			"9 77 65 5\n" +
			"2 1 5 2\n" +
			"5 98 1 5\n" +
			"4 95 67 58";

	static int row, col, data[][], dp[][][];


	public static void main(String[] args) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		StringTokenizer str = new StringTokenizer(input.readLine());
		row = Integer.parseInt(str.nextToken());
		col = Integer.parseInt(str.nextToken());

		data = new int[row][col];
		dp = new int[row][col][3];


		for (int i = 0; i < row; i++) {
			str = new StringTokenizer(input.readLine());
			for (int j = 0; j < col; j++) {
				data[i][j] = Integer.parseInt(str.nextToken());
			}
		}


		for (int j = 0; j < col; j++) {
			dp[0][j][0] = data[0][j];
			dp[0][j][1] = data[0][j];
			dp[0][j][2] = data[0][j];
		}

		//맨 왼쪽인데 왼쪽에서 오는 경우, 맨 오른쪽인데 오른쪽에서 오는 경우
		for (int i = 1; i < row; i++) {
			dp[i][0][0] = Integer.MAX_VALUE;
			dp[i][col - 1][2] = Integer.MAX_VALUE;
		}

		//row
		for (int i = 1; i < row; i++) {
			//col
			for (int j = 0; j < col; j++) {
				//경우의 수
				//맨 왼쪽, 맨 오른쪽, 나머지
				if (isValid(j - 1) && !isValid(j + 1)) {
					dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + data[i][j];
					dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + data[i][j];

				} else if (!isValid(j - 1) && isValid(j + 1)) {
					dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + data[i][j];
					dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + data[i][j];

				} else {
					dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + data[i][j];
					dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + data[i][j];
					dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + data[i][j];
				}

			}
		}


//		for (int i = 0; i < row; i++) {
//			System.out.println(Arrays.toString(data[i]));
//		}
//		System.out.println("====================================");
//
//			for (int i = 0; i < row; i++) {
//				for (int k = 0; k < col; k++) {
//					System.out.print(Arrays.toString(dp[i][k])+" ");
//				}
//				System.out.println();
//			}
//
//		System.out.println("====================================");



		int min = Integer.MAX_VALUE;
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < 3; j++) {
				min = Math.min(dp[row - 1][i][j], min);
			}
		}

		System.out.println(min);
	}

	public static boolean isValid(int y) {
		if (y < 0 || y >= col) {
			return false;
		} else
			return true;
	}
}
