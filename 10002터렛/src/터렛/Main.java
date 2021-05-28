package 터렛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	
	static String src="6\r\n"
			+ "0 0 13 40 0 37\r\n"
			+ "0 0 3 0 7 4\r\n"
			+ "1 1 1 1 1 5\r\n"
			+ "0 0 5 0 1 4\r\n"
			+ "0 0 5 0 1 2\r\n"
			+ "0 0 5 0 0 5";
	
	public static void main(String args[]) throws IOException {
		//input=new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		
		int t=Integer.parseInt(input.readLine());
		StringTokenizer str;
		double J_x,J_y,J_r;
		double B_x,B_y,B_r;
		double between_length;
		
		
		for(int testcase=1;testcase<=t;testcase++) {
			str=new StringTokenizer(input.readLine());
			
			J_x=Integer.parseInt(str.nextToken());
			J_y=Integer.parseInt(str.nextToken());
			J_r=Integer.parseInt(str.nextToken());
			B_x=Integer.parseInt(str.nextToken());
			B_y=Integer.parseInt(str.nextToken());
			B_r=Integer.parseInt(str.nextToken());
			
			between_length=Math.sqrt((J_x-B_x)*(J_x-B_x)+(J_y-B_y)*(J_y-B_y));
			
			if(J_x==B_x&&J_y==B_y&&J_r==B_r) {
				output.append("-1\n");
			}else if((between_length>J_r+B_r)||
					((between_length+Math.min(J_r,B_r)<Math.max(J_r, B_r))&&between_length<Math.max(J_r,B_r))) {//����ǥ�Ÿ��� ��ū��� ���� X
				output.append("0\n");
			}else if(between_length==J_r+B_r||between_length+Math.min(J_r,B_r)==Math.max(J_r, B_r)) { //�� ��ǥ�Ÿ��� �Ÿ��� ������ �������� ���� ������ = ���� 1��
				output.append("1\n");
			}else {
				output.append("2\n");
			}
			
		}
		System.out.print(output);
		
		
	}
}