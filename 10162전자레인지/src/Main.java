import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="100";
	
	static int[] button= {300,60,10};
	static int[] count= {0,0,0};
	static boolean pos=true;
	
	public static void main(String arg[]) throws IOException {
		input= new BufferedReader(new InputStreamReader(System.in));
		
		int time=Integer.parseInt(input.readLine());
		sol(time,0);
		
		if(pos) {
			output.append(count[0]+" "+count[1]+" "+count[2]+"\n");
		}else {
			output.append("-1\n");
		}
		System.out.print(output);
	}
	
	public static void sol(int time,int index) {
		if(index>=3) {
			if(time>0) {
				pos=false;
			}
			return;
		}
		
		count[index]+=time/button[index];
		sol(time%button[index],index+1);
	}
	
}