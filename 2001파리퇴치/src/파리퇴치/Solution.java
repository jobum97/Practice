package 파리퇴치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;
public class Solution {
	
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="3\r\n"
			+ "5 2\r\n"
			+ "1 3 3 6 7\r\n"
			+ "8 13 9 12 8\r\n"
			+ "4 16 11 12 6\r\n"
			+ "2 4 1 23 2\r\n"
			+ "9 13 4 7 3\r\n"
			+ "6 3\r\n"
			+ "29 21 26 9 5 8\r\n"
			+ "21 19 8 0 21 19\r\n"
			+ "9 24 2 11 4 24\r\n"
			+ "19 29 1 0 21 19\r\n"
			+ "10 29 6 18 4 3\r\n"
			+ "29 11 15 3 3 29\r\n"
			+ "7 5\r\n"
			+ "17 24 11 29 18 21 11\r\n"
			+ "8 5 14 0 19 15 17\r\n"
			+ "18 25 29 1 29 16 16\r\n"
			+ "3 26 27 20 6 2 27\r\n"
			+ "20 13 19 8 13 29 15\r\n"
			+ "8 22 8 23 21 7 6\r\n"
			+ "14 9 9 27 16 23 29";
	static int N,M;
	
	public static int makescore(int A[][],int M) {	
		int tmp;
		int max=0;
		for(int i=0;i+M<=A.length;i++) {
			for(int j=0;j+M<=A.length;j++) {
				tmp=plus(A,i,j,M);
				if(tmp>max) {
					max=tmp;
				}
			}
		}
		return max;
	}
	
	public static int plus(int A[][],int x,int y,int M) {
		int sum=0;
		for(int i=0;i<M;i++) {
			for(int j=0;j<M;j++) {
				sum+=A[x+i][y+j];
			}
		}
		
		return sum;		
	}
	
	
	public static void main(String args[]) throws IOException{
		
		BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
		//input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		int[] score=new int[testcase];
		for(int i=1;i<=testcase;i++) {
			StringTokenizer str;
			str=new StringTokenizer(input.readLine());
			N=Integer.parseInt(str.nextToken());
			M=Integer.parseInt(str.nextToken());
			int[][] board=new int[N][N];
			for(int k=0;k<N;k++) {
				int p=0;
				str=new StringTokenizer(input.readLine());
				
				while(str.hasMoreTokens()) {
					board[k][p]=Integer.parseInt(str.nextToken());
					//System.out.println(board[k][p]);
					p++;
				}
			}
			
			System.out.println("#"+i+" "+makescore(board,M));
		
		}
		
		
	}


}


