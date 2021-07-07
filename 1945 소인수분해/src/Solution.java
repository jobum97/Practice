
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src=
			"10\r\n"
			+ "6791400\r\n"
			+ "1646400\r\n"
			+ "1425600\r\n"
			+ "8575\r\n"
			+ "185625\r\n"
			+ "6480\r\n"
			+ "1185408\r\n"
			+ "6561\r\n"
			+ "25\r\n"
			+ "330750";
	static int N;
	
	static int n2;
	static int n3;
	static int n5;
	static int n7;
	static int n11;
	
	public static void main(String args[]) throws IOException {
		input= new BufferedReader(new StringReader(src));
		
		int T=Integer.parseInt(input.readLine());
		for(int test_case=1; test_case<= T; test_case++) {
			N = Integer.parseInt(input.readLine());
			n2=0;
			n3=0;
			n5=0;
			n7=0;
			n11=0;
			while(true) {
				if(N%2!=0) {
					break;
				}
				N=N/2;
				n2++;
			}
			
			while(true) {
				if(N%3!=0) {
					break;
				}
				N=N/3;
				n3++;
			}
			while(true) {
				if(N%5!=0) {
					break;
				}
				N=N/5;
				n5++;
			}
			while(true) {
				if(N%7!=0) {
					break;
				}
				N=N/7;
				n7++;
			}
			while(true) {
				if(N%11!=0) {
					break;
				}
				N=N/11;
				n11++;
			}
			
			output.append("#"+test_case+" "+n2+" "+n3+" "+n5+" "+n7+" "+n11+"\n");
			
			
		}
		System.out.println(output);
	}
	
	

}
