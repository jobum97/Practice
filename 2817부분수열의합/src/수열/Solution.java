package 수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Solution {
	static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static String src="1\r\n"
			+ "4 3\r\n"
			+ "2 2 1 1\r\n"
			+ "10 6\r\n"
			+ "6 5 5 5 4 4 3 2 2 1";

	static int K,N,answer; // N: 자연수 수열 개수,; //K : 합이 될 숫자
	static int[] data;
	public static void main(String args[])throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));		
		int t=Integer.parseInt(input.readLine());

		StringTokenizer str;

		for (int testcase = 1; testcase <= t; testcase++) {
			str = new StringTokenizer(input.readLine());
			N = Integer.parseInt(str.nextToken());
			K = Integer.parseInt(str.nextToken());
			answer=0;
			data = new int[N];
			str = new StringTokenizer(input.readLine());
			for (int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(str.nextToken());
			}

			//System.out.println(Arrays.toString(data));

			output.append("#" + testcase + " " + dfs(0, 0) + "\n");
		}
		System.out.println(output);
	}

	public static int dfs(int index, int sum){
		//System.out.println(index+" "+sum);
		if(sum==K){ // 원하는 합이 되는 경우
			return 1;
		}
		if(index ==N || sum>K){ //탐색 끝
			return 0;
		}

		return dfs(index + 1, sum + data[index]) + dfs(index + 1, sum);
	}
}