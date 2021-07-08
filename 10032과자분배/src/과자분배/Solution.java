package 과자분배;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="3\r\n"
			+ "1 1\r\n"
			+ "7 3\r\n"
			+ "100 10";
	
	static int n,k;
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
		for(int t=1;t<=testcase;t++) {
			StringTokenizer str;
			str=new StringTokenizer(input.readLine());
			n=Integer.parseInt(str.nextToken());
			k=Integer.parseInt(str.nextToken());
			
			System.out.print("#"+t+" ");
			if(n%k==0) {
				System.out.println(0);
			}else {
				System.out.println(1);
			}
			output.append("abc");
			
		}
		
	}	
}