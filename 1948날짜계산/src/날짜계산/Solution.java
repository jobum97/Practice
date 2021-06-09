package 날짜계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="10\r\n"
			+ "3 1 3 31\r\n"
			+ "5 5 8 15\r\n"
			+ "7 17 12 24\r\n"
			+ "3 22 5 10\r\n"
			+ "2 13 6 12\r\n"
			+ "4 30 11 9\r\n"
			+ "7 10 9 28\r\n"
			+ "6 30 9 20\r\n"
			+ "4 19 12 12\r\n"
			+ "1 1 12 31\r\n"
			+ "5 23 9 12\r\n"
			+ "2 12 9 4";
	static int[] month= {31,28,31,30,31,30,31,31,30,31,30,31};
	static int m1,m2,d1,d2;
	public static int count(int month[],int m1,int d1,int m2,int d2) {
		int sum=0;
		for(int i=m1;i<m2-1;i++) {
			sum+=month[i];
		}
		if(m1==m2) {
			sum+=(d2-d1+1);
		}else {
			sum+=d2+1;
			sum+=(month[m1-1]-d1);
		}
		
		
		return sum;
	}
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
 		for(int t=1;t<=testcase;t++) {
 			StringTokenizer str;
 			str=new StringTokenizer(input.readLine());
 			m1=Integer.parseInt(str.nextToken());
 			d1=Integer.parseInt(str.nextToken());
 			m2=Integer.parseInt(str.nextToken());
 			d2=Integer.parseInt(str.nextToken());
 			
 			System.out.println("#"+t+" "+count(month,m1,d1,m2,d2));
 		}
	}
}
