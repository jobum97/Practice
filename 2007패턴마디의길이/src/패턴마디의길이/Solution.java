package 패턴마디의길이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="3\r\n"
			+ "KOREAKOREAKOREAKOREAKOREAKOREA\r\n"
			+ "SAMSUNGSAMSUNGSAMSUNGSAMSUNGSA\r\n"
			+ "GALAXYGALAXYGALAXYGALAXYGALAXY  ";
	public static void main(String args[]) throws IOException{
		
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
		String temp_str1="";
		String temp_str2="";
		int str_length;
		int[] answer=new int[testcase];
		//System.out.println(str);
		for(int k=0;k<testcase;k++) {	
			String str=input.readLine();
			
			for(int i=1;i<=str.length();i++) {
				temp_str1=str.substring(0,i);
				temp_str2=str.substring(i, i+i);
				//System.out.println(temp_str1);
				//System.out.println(temp_str2);
				if(temp_str1.equals(temp_str2)) {
					str_length=i;
					//System.out.println("#"+k+" "+str.length()/str_length);
					answer[k]=str.length()/str_length;
					break;
				}
			}
		
		}
		for(int i=1;i<=testcase;i++) {
			System.out.println("#"+i+" "+answer[i-1]);
		}
	}
}
