package RC카;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.math.*;
public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="1\r\n"
			+ "25\r\n"
			+ "2 1\r\n"
			+ "2 1\r\n"
			+ "0\r\n"
			+ "0\r\n"
			+ "0\r\n"
			+ "1 2\r\n"
			+ "0\r\n"
			+ "2 2\r\n"
			+ "1 2\r\n"
			+ "2 1\r\n"
			+ "1 1\r\n"
			+ "2 1\r\n"
			+ "0\r\n"
			+ "0\r\n"
			+ "0\r\n"
			+ "1 1\r\n"
			+ "1 2\r\n"
			+ "0\r\n"
			+ "0\r\n"
			+ "1 2\r\n"
			+ "2 2\r\n"
			+ "0\r\n"
			+ "2 2\r\n"
			+ "0\r\n"
			+ "1 1";
	static int command;
	static int type;
	static int accel;
	static int velo;
	static int distance;
	public static void main(String args[]) throws IOException {
		//BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
 		for(int t=1;t<=testcase;t++) {
 			command=Integer.parseInt(input.readLine());
 			velo=0;
 			distance=0;
 			for(int i=0;i<command;i++) {
 				StringTokenizer str;
 				str=new StringTokenizer(input.readLine());
 				type=Integer.parseInt(str.nextToken());
 				if(type!=0) {
 					accel=Integer.parseInt(str.nextToken());
 				}
 				switch(type) {
 				case 1:
 					velo+=accel;
 					distance+=Math.abs(velo);
 					break;
 				case 0:
 					distance+=Math.abs(velo);
 					break;
 				case 2:
 					velo-=accel;
 					distance+=Math.abs(velo);
 					break;
 				default:
 					System.out.print("error");
 					break;
 				}
 				
 			}
 			System.out.println("#"+t+" "+distance);
	
 		}

	}
}
