package 상자바꾸기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="1\r\n"
			+ "5 2\r\n"
			+ "1 3\r\n"
			+ "2 4";
	
	static int size;
	static int order; //���� ��ȣ�ٲٴ� ��� Ƚ��
	static int L,R;
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
 		for(int t=1;t<=testcase;t++) {
 			StringTokenizer str;
 			str=new StringTokenizer(input.readLine());
 			size=Integer.parseInt(str.nextToken());
 			order=Integer.parseInt(str.nextToken());
 			int[] box=new int[size];
 			for(int i=1;i<=order;i++) {
 				str=new StringTokenizer(input.readLine());
 				L=Integer.parseInt(str.nextToken());
 				R=Integer.parseInt(str.nextToken());
 				for(int j=L-1;j<R;j++) {
 					box[j]=i;
 				}
 				
 			}
 			System.out.print("#"+t);
 			for(int i=0;i<size;i++) {
 				System.out.print(" "+box[i]);
 			}
 			System.out.println();
 		}
	}	
}