package Main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="4\r\n"
			+ "1 4 10 11";

	public static void main(String arg[]) throws IOException {
		boolean data[]=new boolean[1001]; //true는 소수x false가 소수
		data[1]=true;
		for(int i=2;i<Math.sqrt(1000);i++) {
			for(int j=2;j<=1000/i;j++) {
				data[i*j]=true;
			}
		}
		
		// input=new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		int numbers = Integer.parseInt(input.readLine());
		StringTokenizer str=new StringTokenizer(input.readLine());
		int num,result;
		result=0;
		
		for (int i = 0; i < numbers; i++) {
			num=Integer.parseInt(str.nextToken());
			if(!data[num]) {
				result++;
			}
		}
		
		System.out.print(result);
	}
}