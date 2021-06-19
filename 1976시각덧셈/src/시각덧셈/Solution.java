package 시각덧셈;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="3\r\n"
			+ "3 17 1 39\r\n"
			+ "8 22 5 10\r\n"
			+ "6 53 2 12";
	
	static int h1,h2,m1,m2;
	static int hour,minute;
	public static void main(String args[]) throws IOException {
		BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
		//input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
 		for(int t=1;t<=testcase;t++) {
 			StringTokenizer str;
			str=new StringTokenizer(input.readLine());
			h1=Integer.parseInt(str.nextToken());
			m1=Integer.parseInt(str.nextToken());
			h2=Integer.parseInt(str.nextToken());
			m2=Integer.parseInt(str.nextToken());
			hour=(h1+h2)%12+(m1+m2)/60;
			minute=(m1+m2)%60;
			
			System.out.println("#"+t+" "+hour+" "+minute);
			
 		}
 	}
}