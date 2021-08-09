package 수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Solution {
	static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static String src="2\r\n"
			+ "6\r\n"
			+ "12";
	
	static long[] data=new long[101];
	
	public static void main(String args[])throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));		
		int t=Integer.parseInt(input.readLine());
		int index;
		data[1]=1;
		data[2]=1;
		data[3]=1;
		data[4]=2;
		data[5]=2;
		
		for(int i=6;i<101;i++) {
			data[i]=data[i-5]+data[i-1];
		}
		//System.out.println(Arrays.toString(data));
		
		for (int testcase = 1; testcase <= t; testcase++) {
			index=Integer.parseInt(input.readLine());
			output.append("#"+testcase+" "+data[index]+"\n");
		}
		System.out.print(output);
	}
}
