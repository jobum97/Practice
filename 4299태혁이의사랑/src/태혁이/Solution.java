package 태혁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="3\r\n"
			+ "14 23 59\r\n"
			+ "11 11 11\r\n"
			+ "11 3 7";
	
	static int[] kick=new int[3]; 
	
	static int n,k;
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
		for(int t=1;t<=testcase;t++) {
			StringTokenizer str;
			str=new StringTokenizer(input.readLine());
			for(int i=0;i<3;i++) {
				kick[i]=Integer.parseInt(str.nextToken());
			}
			
			System.out.print(t+" ");
			if(kick[0]<11||((kick[0]==11)&&kick[1]<11)||((kick[0]==11)&&(kick[1]==11)&&(kick[2]<11))) {
				System.out.println("-1");
			}else {
				System.out.println(1440*(kick[0]-11)+60*(kick[1]-11)+kick[2]-11);
			}

		}
		
	}	
}