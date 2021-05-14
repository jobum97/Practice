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
		
		//dfs(num,0);
		sol(num);
		output.append(min_bag);
		System.out.print(output);
	}
	
	public static void dfs(int num,int bag) {
		//System.out.println(num+" "+bag);
		if(num==0) {
			min_bag=Math.min(min_bag, bag);
			return;
		}
		if(num<0) {
			return;
		}
		dfs(num-5,bag+1);
		dfs(num-3,bag+1);
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