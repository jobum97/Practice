package 백만장자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="3\r\n"
			+ "3\r\n"
			+ "10 7 6\r\n"
			+ "3\r\n"
			+ "3 5 9\r\n"
			+ "5\r\n"
			+ "1 1 3 1 2";
	
	public static int Sol(int[] data) {
		int buy;
		int temp_profit;
		int profit;
		int total_profit=0;
		for(int i=0;i<data.length;i++) {
			buy=data[i];
			profit=0;
			for(int j=i+1;j<data.length;j++) {
				temp_profit=data[j]-buy;
				if(temp_profit>profit) {
					profit=temp_profit;
				}
			}
			//System.out.print(profit);
			total_profit+=profit;
		}
		
		return total_profit;
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
		//input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		int j;
 		for(int t=1;t<=testcase;t++) {
 			j=0;
 			int day=Integer.parseInt(input.readLine());
 			int[] data=new int[day];
 			
 			StringTokenizer str;
 			str=new StringTokenizer(input.readLine());
 			while(str.hasMoreTokens()) {
 				data[j]=Integer.parseInt(str.nextToken());
 				j++;
 			}
 			
 			System.out.println("#"+t+" "+Sol(data));
			
 		}
	}
}