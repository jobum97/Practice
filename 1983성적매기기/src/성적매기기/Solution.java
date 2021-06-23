package 성적매기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="10\r\n"
			+ "10 2 0\r\n"
			+ "87 59 88\r\n"
			+ "99 94 78\r\n"
			+ "94 86 86\r\n"
			+ "99 100 99\r\n"
			+ "69 76 70\r\n"
			+ "76 89 96\r\n"
			+ "98 95 96\r\n"
			+ "74 69 60\r\n"
			+ "98 84 67\r\n"
			+ "85 84 91";
	
	public static void bubbleSort(float[][] A,int length) {
		float tmp;
		for(int i=length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(A[1][j]<A[1][j+1]) {
					tmp=A[1][j];
					A[1][j]=A[1][j+1];
					A[1][j+1]=tmp;
					tmp=A[0][j];
					A[0][j]=A[0][j+1];
					A[0][j+1]=tmp;
				}
			}
		}
	}
	
	public static void main(String args[]) throws IOException{
		
		//BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		float[][] scoreBoard=new float[2][testcase];
		float temp_s1;
		float temp_s2;
		float temp_s3;
		float rankcut;
		
		String temp_string;
		String[] temp_array= {"0","0","0"};
		
		for(int i=0;i<testcase;i++) {
			temp_string=input.readLine();
			temp_array=temp_string.split(" ");
			
			//System.out.println(temp_array[0]);
			//System.out.println(temp_array[1]);
			//System.out.println(temp_array[2]);
			
			temp_s1=Integer.parseInt(temp_array[0]);
			temp_s2=Integer.parseInt(temp_array[1]);
			temp_s3=Integer.parseInt(temp_array[2]);
			scoreBoard[0][i]=i+1;
			scoreBoard[1][i]=(float) ((temp_s1*0.35)+(temp_s2*0.45)+(temp_s3*0.2));
			
		}
		bubbleSort(scoreBoard,scoreBoard[1].length);
		for(int i=0;i<testcase;i++) {
			System.out.print(scoreBoard[0][i]+" ");
			System.out.println(scoreBoard[1][i]);
		}
		
		rankcut=testcase/scoreBoard[1].length;
		for(int i=0;i<testcase;i++) {
			
		}
		
		
	}
}
