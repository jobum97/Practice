package 외로운문자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="6\r\n"
			+ "xxyyzz\r\n"
			+ "yc\r\n"
			+ "aaaab\r\n"
			+ "bca\r\n"
			+ "ppzqq\r\n"
			+ "qnwerrewmq";
	
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		int count;
		for(int t=1;t<=testcase;t++) {
			count=0;
			String str=input.readLine();
			char[] strT=str.toCharArray();
			ArrayList<Character> List=new ArrayList<Character>();
			for(int i=0;i<strT.length;i++) {
				for(int j=i+1;j<strT.length;j++) {
					if(strT[i]==strT[j]) {
						strT[i]=' ';
						strT[j]=' ';
					}
					
				}
			}
			
			for(int i=0;i<strT.length;i++) {
				if(strT[i]!=' ') {
					List.add(strT[i]);
				}else {
					count++;
				}
				
			}
			/*Collections.sort(List, new Comparator<T>() {

				@Override
				public int compare(Character o1, Character o2) {
					// TODO Auto-generated method stub
					return 0;
				}
			});*/
			Collections.sort(List);
			System.out.print("#"+t+" ");
			if(count==strT.length) {
					System.out.print("Good");
			}else {
				for(int i=0;i<List.size();i++) {
					System.out.print(List.get(i));
				}
			}
			System.out.println();
		}
		
	}
}