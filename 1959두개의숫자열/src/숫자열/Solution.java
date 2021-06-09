package 숫자열;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="2\r\n"
			+ "3 5\r\n"
			+ "1 5 3\r\n"
			+ "3 6 -7 5 4\r\n"
			+ "7 6\r\n"
			+ "6 0 5 5 -1 1 6\r\n"
			+ "-4 1 8 7 -9 3";
	
	static int array_size1,array_size2;
	
	public static int Max_sum(int[] array1,int[] array2) {
		//array1�� �� �۰ų����� ���
		int max=0;
		int tmp=0;;
		for(int i=0;i<array2.length-array1.length+1;i++) {
			for(int j=0;j<array1.length;j++) {
				tmp+=array1[j]*array2[i+j];
			}
			//System.out.println(tmp);
			if(max<tmp) {
				max=tmp;
				tmp=0;
			}
			tmp=0;
		}
		
		return max;
	}
	
	
	public static void main(String args[]) throws IOException {
		input= new BufferedReader(new InputStreamReader(System.in));
		//input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
 		for(int t=1;t<=testcase;t++) {
 			StringTokenizer str;
 			str=new StringTokenizer(input.readLine());
 			array_size1=Integer.parseInt(str.nextToken());
 			array_size2=Integer.parseInt(str.nextToken());
 			int[] array1=new int[array_size1];
 			int[] array2=new int[array_size2];
 			str=new StringTokenizer(input.readLine());
 			
 			for(int i=0;i<array1.length;i++) {
 				array1[i]=Integer.parseInt(str.nextToken());
 			}
 			str=new StringTokenizer(input.readLine());
 			for(int i=0;i<array2.length;i++) {
 				array2[i]=Integer.parseInt(str.nextToken());
 			}
 			if(array1.length<=array2.length) {
 				System.out.println("#"+t+" "+Max_sum(array1,array2));
 			}else {
 				System.out.println("#"+t+" "+Max_sum(array2,array1));
 			}
 			
 			
 		}
 		
	} 		
}