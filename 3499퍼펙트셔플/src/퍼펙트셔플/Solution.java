package 퍼펙트셔플;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="3\r\n"
			+ "6\r\n"
			+ "A B C D E F\r\n"
			+ "4\r\n"
			+ "JACK QUEEN KING ACE\r\n"
			+ "5\r\n"
			+ "ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA";
	
	static int size;
	static int t_size1,t_size2;
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		int j;
 		for(int t=1;t<=testcase;t++) {
 			size=Integer.parseInt(input.readLine());
 			j=0;
 			if(size%2==0) {
 				t_size1=size/2;
 				t_size2=size/2;
 			}else {
 				t_size1=(size/2)+1;
 				t_size2=size/2;
 			}
 			
 			String[] array=new String[size];
 			String[] t_array1=new String[t_size1];
 			String[] t_array2=new String[t_size2];
 			StringTokenizer str;
 			str=new StringTokenizer(input.readLine());
 			for(int i=0;i<t_size1;i++) {
 				t_array1[i]=str.nextToken();
 			}
 			for(int i=0;i<t_size2;i++) {
 				t_array2[i]=str.nextToken();
 			}
 			
 			for(int i=0;i<t_size2;i++) {
 				array[j]=t_array1[i];
 				j++;
 				array[j]=t_array2[i];
 				j++;
 			}
 			if(size%2==1) {
 				array[size-1]=t_array1[t_size1-1];
 			}
 			
 			System.out.print("#"+t+" ");
 			for(int i=0;i<size;i++) {
 				System.out.print(array[i]+" ");
 			}
 			System.out.println();
 			
 		
 			
 		}
	}	
}