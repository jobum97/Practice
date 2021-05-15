package 수찾기;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	
	static String src="5\r\n"
			+ "4 1 5 2 3\r\n"
			+ "5\r\n"
			+ "1 3 7 9 5";
	
	public static void main(String args[]) throws IOException {
		//input=new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int temp;
		HashSet<Integer> set=new HashSet<Integer>();
		
		int number_N=Integer.parseInt(input.readLine());
		StringTokenizer str= new StringTokenizer(input.readLine());
		
		while(str.hasMoreTokens()) {
			temp=Integer.parseInt(str.nextToken());
			set.add(temp);
		}
		
		
		int number_M=Integer.parseInt(input.readLine());
		str= new StringTokenizer(input.readLine());
		
		while(str.hasMoreTokens()) {
			temp=Integer.parseInt(str.nextToken());
			if(set.contains(temp)) {
				output.append("1\n");			
			}else {
				output.append("0\n");
			}
		}
		
		System.out.print(output);
		
	}
}

		