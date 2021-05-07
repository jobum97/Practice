import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
	
	static StringBuilder output = new StringBuilder();
	
	public static void main(String arg[]) throws IOException {
		Scanner sc= new Scanner(System.in);
		int input= sc.nextInt();
		long[][] DP=new long [101][10];
		long result=0;
		
		for(int i=1;i<10;i++) {
			DP[1][i]=1;
		}
		
		for(int n=2;n<=input;n++) {
			DP[n][0]=DP[n-1][1];
			for(int i=1;i<9;i++) {
				DP[n][i]=(DP[n-1][i-1]+DP[n-1][i+1])%1000000000;	
			}
			DP[n][9]=DP[n-1][8];
		}
		
		for(int i=0;i<10;i++) {
			result+=DP[input][i];
		}
		
		//System.out.println(Arrays.toString(DP[input]));
		
		
		System.out.print(result%1000000000);
		
	}
	
}