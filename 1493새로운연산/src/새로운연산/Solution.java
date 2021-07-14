package 새로운연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="2\r\n"
			+ "1 5\r\n"
			+ "3 9";
	
	static int input1,input2;
	static int x1,y1,x2,y2,x3,y3;
	static int x,y;
	
	public static int coordinate(int input1,int input2) {
		int line=2;
		int i1=input1;
		int i2=input2;
		int i3;
		int sum=0;
		int i=1;
		while(i1-i>0){
			i1=i1-i;
			i++;
			line++;
		}
		x1=1;
		y1=line-x1;
		//System.out.print(i1);
		for(int j=1;j<i1;j++) {
			x1++;
			y1--;
		}
		
		i=1;
		line=2;
		while(i2-i>0){
			i2=i2-i;
			i++;
			line++;
		}
		x2=1;
		y2=line-x2;
		//System.out.print(i2);
		for(int j=1;j<i2;j++) {
			
			x2++;
			y2--;
		}
		
		x=x1+x2;
		y=y1+y2;

		i=1;
		i3=x+y;
		x3=1;
		y3=x+y-x3;
		for(int k=1;k<x+y-1;k++) {
			sum+=k;
		}
		while(true) {
			if((x3==x)&&(y3==y)) {
				break;
			}
			x3++;
			y3--;
			sum++;
		}
		
		return sum+1;
	}
	
	
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
		for(int t=1;t<=testcase;t++) {
			StringTokenizer str;
			str=new StringTokenizer(input.readLine());
			input1=Integer.parseInt(str.nextToken());
			input2=Integer.parseInt(str.nextToken());
			
			System.out.println("#"+t+" "+coordinate(input1,input2));
			//System.out.println("#########");
			
			
		}
		
	}
}