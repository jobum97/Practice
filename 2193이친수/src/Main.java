import java.io.IOException;
import java.util.Scanner;

public class Main{
	
	static StringBuilder output = new StringBuilder();
	
	public static void main(String arg[]) throws IOException {
		Scanner sc= new Scanner(System.in);
		int input= sc.nextInt();
		long[] DP=new long[91];
		DP[1]=1;
		DP[2]=1;
		for(int i=3;i<=input;i++) {
			DP[i]=DP[i-1]+DP[i-2];
		}
		System.out.print(DP[input]);
		
	}
	
}