package 포도주시식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src ="6\r\n"
			+ "6\r\n"
			+ "10\r\n"
			+ "13\r\n"
			+ "9\r\n"
			+ "8\r\n"
			+ "1";
	
	static int max_drink;
	static int[] cups=new int[10003];
	static int[] dp=new int[10003];
	
	public static void main(String arg[]) throws IOException {
		// input=new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		int cup = Integer.parseInt(input.readLine());
		

		for (int i= 1; i<= cup; i++) {
			cups[i]=Integer.parseInt(input.readLine());
		}
		dp[1]=cups[1];
		dp[2]=cups[1]+cups[2];
		for (int i = 3; i <= cup; i++) {
	        dp[i] = Math.max(dp[i-3] + cups[i-1] + cups[i], dp[i-2] + cups[i]);
	        dp[i] = Math.max(dp[i-1], dp[i]);
	    }
		//System.out.println(Arrays.toString(cups));
		//System.out.println(Arrays.toString(dp));
		System.out.print(dp[cup]);
	}

	
}