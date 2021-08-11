import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
	
	static StringBuilder output = new StringBuilder();
	
	public static void main(String arg[]) throws IOException {
		Scanner sc= new Scanner(System.in);
		int input= sc.nextInt();
		long[] DP=new long[1001];
		DP[1]=1;
		DP[2]=3;
		
		for(int i=3;i<=input;i++) {
			DP[i]=(DP[i-1]+2*DP[i-2])%10007;
		}
		
		System.out.print(DP[input]%10007);
		
	}
	
}