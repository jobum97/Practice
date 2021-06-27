package 중간평균값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;
import java.math.*;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="3\r\n"
			+ "3 17 1 39 8 41 2 32 99 2\r\n"
			+ "22 8 5 123 7 2 63 7 3 46\r\n"
			+ "6 63 2 3 58 76 21 33 8 1";
	
	public static void bubbleSort(int[] A,int length) {
		int tmp;
		for(int i=length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(A[j]<A[j+1]) {
					tmp=A[j];
					A[j]=A[j+1];
					A[j+1]=tmp;
				}
			}
		}
	}
	
	public static int Average(int A[]) {
		int sum=0;
		float tmp;
		for(int i=1;i<A.length-1;i++) {
			sum+=A[i];
		}
		tmp=sum;
		
		sum=Math.round(tmp/(A.length-2));
		
		return sum;
	}
	
	
	public static void main(String args[]) throws IOException {
		//BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());

		for(int i=1;i<=testcase;i++) {
			StringTokenizer str;
			str=new StringTokenizer(input.readLine());
			int j=0;
			int[] tempArray=new int[str.countTokens()];
			while(str.hasMoreTokens()) {
				tempArray[j]=Integer.parseInt(str.nextToken());
				j++;
				
			}
			bubbleSort(tempArray,tempArray.length);
			for(int k=0;k<tempArray.length;k++) {
				//System.out.print(tempArray[k]+" ");
			}
			System.out.println("#"+i+" "+Average(tempArray));
			
			
			
		}
		
	}
	
}
