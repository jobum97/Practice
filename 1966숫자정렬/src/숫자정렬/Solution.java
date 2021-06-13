package 숫자정렬;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="3\r\n"
			+ "5\r\n"
			+ "1 4 7 8 0\r\n"
			+ "10\r\n"
			+ "15 20 8 28 16 27 17 27 10 12\r\n"
			+ "15\r\n"
			+ "17 22 20 21 29 6 10 25 20 4 9 21 14 26 23";
	
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
		BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
		//input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		int j,num;
 		for(int t=1;t<=testcase;t++) {
 			j=0;
 			num=Integer.parseInt(input.readLine());
 			int[] array=new int[num];
 			StringTokenizer str;
			str=new StringTokenizer(input.readLine());
			
			for(int k=0;k<array.length;k++) {
				//System.out.println(str.nextToken());
				array[k]=Integer.parseInt(str.nextToken());
			}
			
		
			bubbleSort(array,array.length);
			System.out.print("#"+t);
			for(int k=0;k<array.length;k++) {
				System.out.print(" "+array[k]);
			}
			System.out.println();
 		}
	}
}