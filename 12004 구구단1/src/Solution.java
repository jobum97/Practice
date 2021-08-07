
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="4\r\n"
			+ "10\r\n"
			+ "11\r\n"
			+ "50\r\n"
			+ "81";
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		
		int testcase= Integer.parseInt(input.readLine());
		int num;
		
		for(int tc=1;tc<=testcase;tc++) {
			
			num=Integer.parseInt(input.readLine());
			
			if(sol(num)) {
				output.append("#"+tc+" Yes\n");
			}else {
				output.append("#"+tc+" No\n");
			}
		}
		
		System.out.println(output);
	}
	
	public static boolean sol(int num) {
		int temp;
		
		for(int i=9;i>0;i--) {
			if(num%i==0) {
				temp=num/i;
				if(temp>0&&temp<10) {
					return true;
				}
			}
		}
		
		return false;
	}
}
