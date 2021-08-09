package 정수배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src ="6\r\n"
			+ "3\r\n"
			+ "3 0 1\r\n"
			+ "11\r\n"
			+ "9 8 7 6 5 4 3 2 1 1 0\r\n"
			+ "10\r\n"
			+ "9 0 8 7 6 5 4 3 2 1\r\n"
			+ "100\r\n"
			+ "3 6 7 5 3 5 6 2 9 1 2 7 0 9 3 6 0 6 2 6\r\n"
			+ "1 8 7 9 2 0 2 3 7 5 9 2 2 8 9 7 3 6 1 2\r\n"
			+ "9 3 1 9 4 7 8 4 5 0 3 6 1 0 6 3 2 0 6 1\r\n"
			+ "5 5 4 7 6 5 6 9 3 7 4 5 2 5 4 7 4 4 3 0\r\n"
			+ "7 8 6 8 8 4 3 1 4 9 2 0 6 8 9 2 6 6 4 9\r\n"
			+ "100\r\n"
			+ "7 2 7 5 4 7 4 4 5 8 1 5 7 7 0 5 6 2 0 4\r\n"
			+ "3 4 1 1 0 6 1 6 6 2 1 7 9 2 4 6 9 3 6 2\r\n"
			+ "8 0 5 9 7 6 3 1 4 9 1 9 1 2 6 4 2 9 7 8\r\n"
			+ "3 9 5 5 2 3 3 8 4 0 6 8 2 5 5 0 6 7 1 8\r\n"
			+ "5 1 4 8 1 3 7 3 3 5 3 0 6 0 6 5 3 2 2 2\r\n"
			+ "1\r\n"
			+ "3";
	
	public static void main(String arg[]) throws IOException {
		// input=new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		int t = Integer.parseInt(input.readLine());
		int N,line,index,check_num,check_range;
		String[] data;
		StringTokenizer str;
		String temp;
		HashSet<Integer> set;
		
		
		for (int testcase = 1; testcase <= t; testcase++) {
			set=new HashSet<Integer>();
			N=Integer.parseInt(input.readLine());
			data=new String[1001];
			line=N/20;
			index=0;
			
			if(N%20>0) 
				line++;
			
			//�迭�� �� �Է�
			for(int j=0;j<line;j++) {
				str=new StringTokenizer(input.readLine());
				while(str.hasMoreTokens()) {
					data[index]=str.nextToken();
					index++;
				}
			}
			//System.out.println(Arrays.toString(data));
			
			
			//숫자 길이가 1인 것부터 hashset에 넣음   
			check_range=1;
			check_num=0;
			Loop1:
			for(int length=1;length<=N;length++) {
				for(int start=0;start<=N-length;start++) {
					temp="";
					for(int i=start;i<start+length;i++) {
						temp+=data[i];
					}
					check_num=Integer.parseInt(temp);
					set.add(check_num);
				}
				
				if(!set.contains(0)) {
					output.append("#"+testcase+" 0\n");
					break;
				}
				
				for(int k=check_range;k<check_range*10;k++) {
					if(!set.contains(k)) {
						output.append("#"+testcase+" "+k+"\n");
						break Loop1;
					}
				}
				check_range*=10;
			}
		}
		System.out.println(output);
	}

	
}
