package 요금비교;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="2\r\n"
			+ "9 100 20 3 10\r\n"
			+ "8 300 100 10 250";
			
	public static int Calculation(int[] info) {
		int a,b;
		//System.out.println(Arrays.toString(info));

		a=info[0]*info[4];
		int min=a;
		if(info[4]>info[2]) {
			b=info[1]+info[3]*(info[4]-info[2]);
		}else {
			b=info[1];
		}
		if(min>b) {
			min=b;
		}
		
		return min;
	}
	
	static int p,q,r,s,w; //P:A�� ���ʹ��� Q:B�� R���� ���Ͽ�� S:R�����̻� ���ʹ���, W:��뷮
	
	public static void main(String args[]) throws IOException {
		BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
		//input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
 		for(int t=1;t<=testcase;t++) {
 			StringTokenizer str;
 			str=new StringTokenizer(input.readLine());
 			int[] info=new int[str.countTokens()];
 			int j=0;
 			while(str.hasMoreTokens()) {
 				info[j]=Integer.parseInt(str.nextToken());
 				j++;
 			}
 			
 			System.out.println("#"+t+" "+Calculation(info));
 			
 		}
 		
	}
}
