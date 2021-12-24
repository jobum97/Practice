import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 static StringBuilder output = new StringBuilder();
	 static String src = "1000";


	public static void main(String[] args) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		//StringTokenizer str = new StringTokenizer(input.readLine());

		int dp[] = new int[1001];

		dp[1]=1;
		dp[2]=2;
		for (int i = 3; i < dp.length; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2])%10007;
		}

		System.out.println(dp[Integer.parseInt(input.readLine())]);

	}
}
