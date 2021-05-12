import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="380";
	
	static int[] coin= {500,100,50,10,5,1};
	static int result=0;
	
	public static void main(String arg[]) throws IOException {
		input= new BufferedReader(new InputStreamReader(System.in));
		
		int money=1000-Integer.parseInt(input.readLine());
		sol(money,0);
		
		System.out.print(result);
	}
	
	public static void sol(int money,int index) {
		if(index>=6) {
			return;
		}
		
		int Coin=money/coin[index];
		result+=Coin;
		sol(money%coin[index],index+1);
	}
	
}