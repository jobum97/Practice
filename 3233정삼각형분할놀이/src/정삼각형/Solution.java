package 정삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static String src="2\r\n"
			+ "2 1\r\n"
			+ "3 3";
			
	public static void main(String args[])throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));		
		int t=Integer.parseInt(input.readLine());
		StringTokenizer str;		
		long A,B;
		
		for(int testcase = 1; testcase <= t; testcase++) {
			str=new StringTokenizer(input.readLine());
			A=Integer.parseInt(str.nextToken());
			B=Integer.parseInt(str.nextToken());
			//�� ���������� �ǳ�?? =>B�� A�� ��� 
			output.append("#"+testcase+" "+(A*A)/(B*B)+"\n");
			
		}
		System.out.println(output);
		
	}
}
