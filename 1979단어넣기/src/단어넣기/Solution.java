package 단어넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="2\r\n"
			+ "5 3\r\n"
			+ "0 0 1 1 1\r\n"
			+ "1 1 1 1 0\r\n"
			+ "0 0 1 0 0\r\n"
			+ "0 1 1 1 1\r\n"
			+ "1 1 1 0 1\r\n"
			+ "5 3\r\n"
			+ "1 0 0 1 0\r\n"
			+ "1 1 0 1 1\r\n"
			+ "1 0 1 1 1\r\n"
			+ "0 1 1 0 1\r\n"
			+ "0 1 1 1 0";
	static int N,word_length;
	
	public static int CheckCol(int A[][],int word,int y) {
		int tmp=0;
		int place=0;
		for(int i=0;i<A.length;i++) {
			if(A[i][y]==1) {
				tmp+=1;
				if((i==A.length-1)&&(tmp==word)) {
					place++;
				}
				
			}else {
				if(tmp==word) {
					place++;
				}
				tmp=0;
			}
		}
		
		return place;
	}
	
	
	public static int CheckRow(int A[][],int word,int x) {
		int tmp=0;
		int place=0;
		for(int i=0;i<A.length;i++) {
			if(A[x][i]==1) {
				tmp+=1;
				if((i==A.length-1)&&(tmp==word)) {
					place++;
				}
				
			}else {
				if(tmp==word) {
					place++;
				}
				tmp=0;
			}
		}
		
		return place;
	}
	
	public static int Check(int A[][],int word) {
		int result=0;
		for(int i=0;i<A.length;i++) {
			result+=CheckRow(A,word,i);
			result+=CheckCol(A,word,i);
			//System.out.println("row"+i+" "+CheckRow(A,word,i));
			//System.out.println("col"+i+" "+CheckCol(A,word,i));
		}
		return result;
	}
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
		//input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
 		for(int t=1;t<=testcase;t++) {
 			StringTokenizer str;
 			str=new StringTokenizer(input.readLine());
 			N = Integer.parseInt(str.nextToken());
            word_length = Integer.parseInt(str.nextToken());
			int[][] map=new int[N][N];
			
			for(int i=0;i<N;i++) {
				str=new StringTokenizer(input.readLine());
				int j=0;
				while(str.hasMoreTokens()) {	
					map[i][j]=Integer.parseInt(str.nextToken());
					j++;
				}
			}
			
			System.out.println("#"+t+" "+Check(map,word_length));
		}
	}
}
