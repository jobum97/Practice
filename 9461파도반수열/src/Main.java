import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	public static void main(String arg[]) throws IOException {
		input= new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(input.readLine());
		int max=0;
		
		
		int[] data=new int[testcase];
		for(int i=0;i<testcase;i++) {
			int n=Integer.parseInt(input.readLine());
			data[i]=n;
			max=Math.max(max, n); // DP 계산 최소화하기위해 최댓값 저장
		}
		
		
		long[] DP=new long[101];
		
		DP[1]=1;
		DP[2]=1;
		DP[3]=1;
		DP[4]=2;
		DP[5]=2;
		
		for(int i=6;i<=max;i++) {
			DP[i]=(DP[i-1]+DP[i-5]);
		}
		
		for(int i=0;i<testcase;i++) {
			output.append(DP[data[i]]+"\n");
		}
		
		System.out.print(output);
	}
}