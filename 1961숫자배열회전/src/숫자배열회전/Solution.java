package 숫자배열회전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="2\n" +
			"3\n" +
			"1 2 3\n" +
			"4 5 6\n" +
			"7 8 9\n" +
			"6\n" +
			"6 9 4 7 0 5\n" +
			"8 9 9 2 6 5\n" +
			"6 8 5 4 9 8\n" +
			"2 2 7 7 8 4\n" +
			"7 5 1 9 7 9\n" +
			"8 9 3 9 7 6";

	static int N;

	public static void Turn90(int[][] New ,int[][] Old) {
		for (int i = 0; i < N; i++) {
			int k=N-i-1;
			for (int j = 0; j < N; j++) {
				New[j][k] = Old[i][j];
			}
		}
	}


	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
 		for(int t=1;t<=testcase;t++) {
 			N=Integer.parseInt(input.readLine());
			int[][] original = new int[N][N];
			int[][] ver90 = new int[N][N];
			int[][] ver180 = new int[N][N];
			int[][] ver270 = new int[N][N];
			StringTokenizer str;

			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(input.readLine());
				for (int j = 0; j < N; j++) {
					original[i][j] = Integer.parseInt(str.nextToken());
				}
			}

			///////////////////////////////////////////////////////
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(original[i]));
//			}
			///////////////////////////////////////////////////////

			Turn90(ver90,original);
			Turn90(ver180, ver90);
			Turn90(ver270, ver180);
			output.append("#" + t + "\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					output.append(ver90[i][j]);
				}
				output.append(" ");
				for (int j = 0; j < N; j++) {
					output.append(ver180[i][j]);
				}
				output.append(" ");
				for (int j = 0; j < N; j++) {
					output.append(ver270[i][j]);
				}
				output.append("\n");
			}
 		}
		System.out.println(output);

	}
}