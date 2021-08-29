package 건초더미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="1\r\n"
			+ "4\r\n"
			+ "2\r\n"
			+ "10\r\n"
			+ "7\r\n"
			+ "1";

	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		int dummy;
		int sum,avg,deviation;
 		for(int t=1;t<=testcase;t++) {
 			dummy=Integer.parseInt(input.readLine());
 			int[] data=new int[dummy];
 			sum=0;
 			avg=0;
 			deviation=0;
 			for(int i=0;i<dummy;i++) {
 				data[i]=Integer.parseInt(input.readLine());
 			}
 			for(int i=0;i<dummy;i++) {
 				sum+=data[i];
 			}
 			avg=sum/dummy;
 			for(int i=0;i<dummy;i++) {
 				deviation+=Math.abs(data[i]-avg);
 			}
			//deviation+=Math.abs(dummy-avg);
			//System.out.println(avg);
			System.out.println("#"+t+" "+deviation/2);
 		}
	}
}