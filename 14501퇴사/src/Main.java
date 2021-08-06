import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "10\r\n"
			+ "5 50\r\n"
			+ "4 40\r\n"
			+ "3 30\r\n"
			+ "2 20\r\n"
			+ "1 10\r\n"
			+ "1 10\r\n"
			+ "2 20\r\n"
			+ "3 30\r\n"
			+ "4 40\r\n"
			+ "5 50";

	static int[] T,P;
	static int N,max;

	public static void main(String args[]) throws IOException {
		// input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		
		StringTokenizer str;
		N=Integer.parseInt(input.readLine());
		T=new int[N+1];
		P=new int[N+1];
		max=Integer.MIN_VALUE;
		
		for(int i=1;i<=N;i++) {
			str = new StringTokenizer(input.readLine());
			T[i]=Integer.parseInt(str.nextToken());
			P[i]=Integer.parseInt(str.nextToken());
		}
		
		sol(0,1);
		System.out.println(max);
	}
	
	public static void sol(int profit, int day) {
		if(day>N) { //정해진 기간 지났을 때 
			max=Math.max(profit, max); //벌은 돈과 기존의 최대값을 비교 
			return;
		}
		
		if(day+T[day]<=N+1) { //처리할 수 있을 때 선택하는경우
			sol(profit+P[day],day+T[day]);
		}
		sol(profit,day+1); //선택하지 않는 경우
	}
}