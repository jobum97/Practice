package 스토쿠검증;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;
import java.math.*;


public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="1\r\n"
			+ "7 3 6 4 2 9 5 8 1\r\n"
			+ "5 8 9 1 6 7 3 2 4\r\n"
			+ "2 1 4 5 8 3 6 9 7\r\n"
			+ "8 4 7 9 3 6 1 5 2\r\n"
			+ "1 5 3 8 4 2 9 7 6\r\n"
			+ "9 6 2 7 5 1 8 4 3\r\n"
			+ "4 2 1 3 9 8 7 6 5\r\n"
			+ "3 9 5 6 7 4 2 1 8\r\n"
			+ "6 7 8 2 1 5 4 3 9";
			
	public static boolean CheckLines(int A[][]) {
		boolean check=true;
		for(int i=0;i<9;i++) {
			check=check&&CheckRowLine(A,i);
			check=check&&CheckColLine(A,i);
		}
		if(check) {
			return true;	
		}else {
			return false;
		}
		
	}
	
	
	public static boolean CheckRowLine(int A[][],int y) {
		int tmp;
		
		for(int i=0;i<8;i++) {
			tmp=A[y][i];
			for(int j=i+1;j<9;j++) {
				if(tmp==A[y][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean CheckColLine(int A[][],int x) {
		int tmp;
		
		for(int i=0;i<8;i++) {
			tmp=A[i][x];
			for(int j=i+1;j<9;j++) {
				if(tmp==A[j][x]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	
	
	public static boolean CheckBoxs(int A[][]) {
		if(CheckBox(A,0,0)&&CheckBox(A,0,3)&&CheckBox(A,0,6)
		&&CheckBox(A,3,0)&&CheckBox(A,3,3)&&CheckBox(A,3,6)
		&&CheckBox(A,6,0)&&CheckBox(A,6,0)&&CheckBox(A,6,6)) {
			return true;	
		}else {
			return false;
		}
	}
	public static boolean CheckBox(int A[][],int x,int y) {
		int[] num=new int[9];
		int t=0;
		int tmp;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				num[t]=A[x+i][y+j];
				t++;
			}
		}
		
		for(int i=0;i<8;i++) {
			tmp=num[i];
			for(int j=i+1;j<9;j++) {
				if(tmp==num[j]) {
					return false;
				}
			}
		}
		
		return true;
	}
			
			
	public static void main(String args[]) throws IOException {
		BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
		//input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
		for(int t=1;t<=testcase;t++) {
			StringTokenizer str;
			int[][] Array=new int[9][9];
			for(int i=0;i<9;i++) {
				str=new StringTokenizer(input.readLine());
				int j=0;
				while(str.hasMoreTokens()) {
					Array[i][j]=Integer.parseInt(str.nextToken());
					j++;
				}
			}
		
		System.out.print("#"+t+" ");
		//System.out.print(CheckLines(Array));
		//System.out.print(CheckBoxs(Array));
		if(CheckLines(Array)&&CheckBoxs(Array)) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
		
		
		}
	}
}