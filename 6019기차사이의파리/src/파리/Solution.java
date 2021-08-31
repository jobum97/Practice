package 파리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static String src="1\r\n"
			+ "250 10 15 20";
			
	public static void main(String args[])throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));		
		int t=Integer.parseInt(input.readLine());
		StringTokenizer str;		
		int a_velo,b_velo,fly_v;
		float fly_time,temp_time,distance;
		
		for (int testcase = 1; testcase <= t; testcase++) {
			str=new StringTokenizer(input.readLine());
			distance=Integer.parseInt(str.nextToken());
			a_velo=Integer.parseInt(str.nextToken());
			b_velo=Integer.parseInt(str.nextToken());
			fly_v=Integer.parseInt(str.nextToken());
			
			fly_time=0;
			
			while(true) {
				temp_time=distance/(a_velo+b_velo+fly_v);
				fly_time+=temp_time;
				
				distance-=temp_time*(a_velo+b_velo);
				if(temp_time*(a_velo+b_velo)<0.000001) {
					break;
				}
				
			}
			
			output.append("#"+testcase+" "+fly_time*fly_v+"\n");						
		}
		System.out.println(output);
	}
}
