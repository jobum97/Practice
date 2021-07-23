package 파스칼삼각형;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "2\r\n"
			+ "3\r\n"
			+ "4";
			
	public static void main(String args[]) throws IOException{
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		
		int testcase=Integer.parseInt(input.readLine());
		
		for(int i=1;i<=testcase;i++) {
			int t_scale=Integer.parseInt(input.readLine());
			int [][] tr=new int[t_scale][t_scale];
			tr[0][0]=1;
			if(t_scale>1) {
				tr[1][0]=1;
				tr[1][1]=1;
			}
			if(t_scale>2){
				for(int j=2;j<t_scale;j++) {
					tr[j][0]=1;
					for(int n=1;n<j;n++) {
						tr[j][n]=tr[j-1][n-1]+tr[j-1][n];
					}
					tr[j][j]=1;
				}
			}
			System.out.println("#"+i);
			for(int m=0;m<t_scale;m++){
				for(int n=0;n<m;n++) {
					System.out.print(tr[m][n]+" ");
				}
				System.out.println(tr[m][m]);
				//System.out.println();
			}
		}
		
	}
	
	
}
