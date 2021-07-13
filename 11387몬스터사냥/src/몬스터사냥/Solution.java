package 몬스터사냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static String src="3\r\n"
			+ "100 0 1\r\n"
			+ "200 12 10\r\n"
			+ "10000 100 100";
			
	public static void main(String args[])throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));		
		int testcase=Integer.parseInt(input.readLine());
		StringTokenizer str;
		
		int damage,level,hit;
		long total_damage;
		for(int t=1;t<=testcase;t++) {
			str=new StringTokenizer(input.readLine());
			
			damage=Integer.parseInt(str.nextToken());
			level=Integer.parseInt(str.nextToken());
			hit=Integer.parseInt(str.nextToken());
			
			damage/=100; //데미지는 100의 배수 100으로 추후에 나눌꺼 여기서 편하게함
			//(1+L*n)%를 100곱해서 계산하였음 그래서 위에서 100나누는것
			// D*(100* n + 0~n-1 합 *L) 
			total_damage=damage*(100*hit+(level*(hit-1)*hit)/2);

			output.append("#"+t+" "+total_damage+"\n");
		}
		
		System.out.print(output);
	}
}
