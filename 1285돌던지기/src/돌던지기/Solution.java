package 돌던지기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="2\r\n"
			+ "2\r\n"
			+ "-100 100\r\n"
			+ "3\r\n"
			+ "-5 -1 3";
			
	public static void bubbleSort(int[] A,int length) {
		int tmp;
		for(int i=length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(A[j]>A[j+1]) {
					tmp=A[j];
					A[j]=A[j+1];
					A[j+1]=tmp;
				}
			}
		}
	}
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		int num;
		int overlap;
 		for(int t=1;t<=testcase;t++) {
 			overlap=0;
 			num=Integer.parseInt(input.readLine());
 			StringTokenizer str;
 			str=new StringTokenizer(input.readLine());
 			int[] data=new int[num];
 			for(int i=0;i<num;i++) {
 				data[i]=Math.abs(Integer.parseInt(str.nextToken()));
 			}
 			bubbleSort(data,data.length);
 			for(int k=0;k<data.length;k++) {
 				if(data[0]<data[k]) {
 					break;
 				}
 				overlap++;
 			}
 			System.out.println("#"+t+" "+data[0]+" "+overlap);
 		
 		}
	}
}
