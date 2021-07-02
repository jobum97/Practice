package 회문검사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;


public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="3\r\n"
			+ "level\r\n"
			+ "samsung\r\n"
			+ "eye";
	
	public static int Check(String str[]) {
		for(int i=0;i<=str.length/2;i++) {
			if(str[i].equals(str[str.length-i-1])) {
			}else
				return 0;
		}
		return 1;
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
		//input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
 		for(int t=1;t<=testcase;t++) {
 			String str=input.readLine();
 			String[] array=str.split("");
 			System.out.println("#"+t+" "+Check(array)); 			
 		}
	}
}
