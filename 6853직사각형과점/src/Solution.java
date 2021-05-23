
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static String src=
			"1\r\n"
			+ "0 0 2 2\r\n"
			+ "4\r\n"
			+ "-1 -1\r\n"
			+ "0 0\r\n"
			+ "1 1\r\n"
			+ "2 2";
			
	public static void main(String args[])throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		
		StringTokenizer str;
		int t= Integer.parseInt(input.readLine());
		
		int x1,y1,x2,y2,N,x,y;
		int case_in,case_line,case_out;
		
		for(int testcase=1;testcase<=t;testcase++) {
			case_in=0;
			case_line=0;
			case_out=0;
			
			str= new StringTokenizer(input.readLine());
			x1=Integer.parseInt(str.nextToken());
			y1=Integer.parseInt(str.nextToken());
			x2=Integer.parseInt(str.nextToken());
			y2=Integer.parseInt(str.nextToken());
		
			N=Integer.parseInt(input.readLine());
			
			for(int n=0;n<N;n++) {
				str= new StringTokenizer(input.readLine());
				x=Integer.parseInt(str.nextToken());
				y=Integer.parseInt(str.nextToken());
				
				if(x1<x && x<x2 && y1<y && y<y2) { // x1<x<x2, y1<y<y2 이면 사각형 내부
					case_in++;
				}
				else if((x==x1 &&y1<=y && y<=y2)||(x==x2 &&y1<=y && y<=y2)||
						(y==y1&&x1<=x && x<=x2)||(y==y2&&x1<=x && x<=x2)) {
					case_line++;
				}
				else {
					case_out++;
				}
				
			}
			output.append("#"+testcase+" "+case_in+" "+case_line+" "+case_out+"\n");
		}
		
		System.out.print(output);
	}
}