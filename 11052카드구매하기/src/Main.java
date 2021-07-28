import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src ="4\r\n"
			+ "3 5 15 16";
	
	static int N,cost;
	
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		
		N= Integer.parseInt(input.readLine());
		
		StringTokenizer str=new StringTokenizer(input.readLine());
		
		int[] data=new int[N+1];
		for(int i=1;i<=N;i++) {
			data[i]=Integer.parseInt(str.nextToken());
		}
		
		int[] dp=new int[N+1];
		dp[1]=data[1];
		
		
		for(int i=2; i<=N;i++) {
			for(int j=1;j<i;j++) {
				dp[i]=Math.max(dp[j]+data[i-j], dp[i]);
				dp[i]=Math.max(dp[i], data[i]);
			}
		}
		
//		System.out.println(Arrays.toString(data));
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
		
	}
	
	
}