package 압축풀기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="1\r\n"
			+ "3\r\n"
			+ "A 10\r\n"
			+ "B 7\r\n"
			+ "C 5";
	static String alp;
	static int num;
	static int line;
	public static void main(String args[]) throws IOException {
		BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
		//input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
 		for(int t=1;t<=testcase;t++) {
 			line=0;
 			int letter=Integer.parseInt(input.readLine());
 			System.out.println("#"+t);
 			for(int i=0;i<letter;i++) {
 				StringTokenizer str;
 				str=new StringTokenizer(input.readLine());
 				alp=str.nextToken();
 				num=Integer.parseInt(str.nextToken());
 				for(int k=0;k<num;k++) {
 					System.out.print(alp);
 					line++;
 					if(line==10) {
 						System.out.println();
 						line=0;
 					}		
 				}
 			}
 			System.out.println();
 		}	
	}
}