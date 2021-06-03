package 삼육구;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
		
	public static void main(String args[]) throws IOException{
		
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int number=Integer.parseInt(input.readLine());
		String numberstr;
		int stack;
		String temp_str="";
		int temp_int;
		for(int i=1;i<=number;i++) {
			numberstr=String.valueOf(i);
			String[] array=numberstr.split("");
			stack=0;
			for(int k=0;k<array.length;k++) {
				//System.out.println(array[k]);
				if(array[k].equals("3")) {
					stack++;
				}
				if(array[k].equals("6")) {
					stack++;
				}
				if(array[k].equals("9")) {
					stack++;
				}
			}
			if(stack>0) {
				for(int k=0;k<stack;k++) {
					System.out.print("-");
				}
				System.out.print(" ");
			}
			else {
				System.out.print(i+" ");
			}
			
		}
		
	}
	
}
