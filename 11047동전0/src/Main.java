import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="10 4790\r\n"
			+ "1\r\n"
			+ "5\r\n"
			+ "10\r\n"
			+ "50\r\n"
			+ "100\r\n"
			+ "500\r\n"
			+ "1000\r\n"
			+ "5000\r\n"
			+ "10000\r\n"
			+ "50000";
	
	static int[] coin;
	static int n;
	static int result=0;
	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));
		StringTokenizer str;
		str=new StringTokenizer(input.readLine());
		
		n=Integer.parseInt(str.nextToken());
		int money=Integer.parseInt(str.nextToken());
		
		coin=new int[n];
		for(int i=n-1;i>=0;i--) {
			coin[i]=Integer.parseInt(input.readLine());
		}
		
		//System.out.println(Arrays.toString(coin));
		sol(money,0);
		System.out.println(result);
	}
	
	public static void sol(int money,int index) {
		if(index>=n) {
			return;
		}
		
		result+=money/coin[index];;
		sol(money%coin[index],index+1);
	}
}
