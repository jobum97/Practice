package 늘어지는소리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="2\r\n"
			+ "wow\r\n"
			+ "3\r\n"
			+ "2 3 2\r\n"
			+ "hoi\r\n"
			+ "3\r\n"
			+ "0 0 0";
	
	static int control;
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		int num;
		int insert;
		for(int t=1;t<=testcase;t++) {
			String str=input.readLine();
			num=Integer.parseInt(input.readLine());
			int[] data=new int[num];
			StringTokenizer strT;
			strT=new StringTokenizer(input.readLine());
			for(int i=0;i<num;i++) {
				data[i]=Integer.parseInt(strT.nextToken());
			}
			String[] strD=str.split("");
			System.out.print("#"+t+" ");
			for(int i=0;i<str.length();i++) {
				for(int k=0;k<data.length;k++) {
					if(data[k]==i) {
						System.out.print("-");
					}
				}
				System.out.print(strD[i]);
			}
			for(int k=0;k<data.length;k++) {
				if(data[k]==str.length()) {
					System.out.print("-");
				}
			}
			
			
			System.out.println();
			
		}
		
	}
}