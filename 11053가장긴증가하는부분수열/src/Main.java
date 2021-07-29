import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src ="6\r\n"
			+ "10 20 1 2 3 50";
			
	static int[] data;
	static int N;
	
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		
		N=Integer.parseInt(input.readLine());
		StringTokenizer str=new StringTokenizer(input.readLine());
		data=new int[N+1];
		int max_length=0;
		
		
		for(int i=1;i<=N;i++) {
			data[i]=Integer.parseInt(str.nextToken());
		}
		
		int[] dp=new int[N+1];// dp: i번째 원소를 마지막으로 하는 최대 증가 부분 수열 길이
		dp[1]=1;
		int point=0; // 1~i-1번째까지의 원소 중 i번째 원소 보다 값 작은 것들 중 가장 큰 dp 값
		
		//dp 구하는 반복문 
		
		for(int i=2;i<=N;i++) {
			point=0;
			max_length=0;
			for(int j=i-1;j>0;j--) {
				if(data[j]<data[i]) { //i 번째 원소보다 작다면
					point=Math.max(point, dp[j]); //point 값 갱신
				}
			}
			
			dp[i]=point+1; //point 최대값 +1 why? i-1 까지의 최대길이에서 i번째 원소를 추가하였기에 
			
		}
		
		//dp가 i번째 원소까지의 최대길이를 나타내는 것이 아니기에 dp의 마지막 원소가 답이아님=> 검사하여 찾아낸다
		for(int i=1;i<=N;i++) {
			max_length=Math.max(max_length, dp[i]);
		}
		
		/////////////////////////////////////////////
//		System.out.println(Arrays.toString(data));
//		System.out.println(Arrays.toString(dp));
		/////////////////////////////////////////////
		
		System.out.println(max_length);
		
		
	}
	
	
}


