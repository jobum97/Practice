package 달팽이숫자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="2\r\n"
			+ "3\r\n"
			+ "4";
	static int size;
	static int num=1;
	static int x=0;
	static int y=0;
	
	public static void Forward(int[][] table) {
		System.out.println("forward");
		System.out.println(num+" "+x+" "+y);
		while(true) {
			if(size-1==y) {
				break;
			}
			
			if(table[x][y+1]!=0) {
				table[x][y]=num;
				num++;
				break;
			}
			y++;
			table[x][y]=num;
			num++;
		}
	}
	
	public static void Back(int[][] table) {
		System.out.println("back");
		while(true) {
			if(y==0) {
				break;
			}
			if(table[x][y-1]!=0) {
				table[x][y]=num;
				num++;
				break;
			}
			table[x][y]=num;
			y--;
			num++;
		}
	}
	
	public static void Down(int[][] table) {
		System.out.println("down");
		while(true) {
			if(size-1==x) {
				break;
			}
			if(table[x+1][y]!=0) {
				table[x][y]=num;
				num++;
				break;
			}
			table[x][y]=num;
			x++;
			num++;
		}
	}
	
	public static void Up(int[][] table) {
		System.out.println("up");
		while(true) {
			if(x==0) {
				break;
			}
			if(table[x-1][y]!=0) {
				System.out.println("up"+x+" "+y+" "+num);
				table[x][y]=num;
				num++;
				break;
			}
			table[x][y]=num;
			x--;
			num++;
		}
	}
	
	public static void Move(int[][] table) {
		while(true) {
			if(num==size*size) {
				break;
			}
			Forward(table);
			if(num==size*size) {
				break;
			}
			Down(table);
			if(num==size*size) {
				break;
			}
			Back(table);
			if(num==size*size) {
				break;
			}
			Up(table);
			if(num==size*size) {
				break;
			}
		}
	}
	
	
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
 		for(int t=1;t<=testcase;t++) {
 			size=Integer.parseInt(input.readLine());
 			
 			int[][] table=new int[size][size];
 			//table[0][0]=1;
 			Move(table);
 			System.out.println("#"+t);
 			for(int i=0;i<size;i++) {
 				for(int j=0;j<size;j++) {
 					System.out.print(table[i][j]+" ");
 				}
 				System.out.println();
 			}
 		
 			num=1;
 			x=0;
 			y=0;
 		}
	}	
}