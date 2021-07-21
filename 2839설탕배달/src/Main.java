import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int min_bag=0;
	public static void main(String arg[]) throws IOException {
		input= new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(input.readLine());
		
		sol(num);
		output.append(min_bag);
		System.out.print(output);
	}
	
	public static void sol(int num) {
		if(num<0) {
			min_bag=-1;
			return;
		}
		if(num==0) {
			return;
		}
		
		if(num%5==0) {
			min_bag+=num/5;
			return;
		}else {
			min_bag++;
			sol(num-3);
		}
		
	}
	
}