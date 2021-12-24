import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 static StringBuilder output = new StringBuilder();
	 static String src = "2\n" +
			 "6\n" +
			 "22";

	public static void main(String[] args) throws IOException {
		//
		// input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());

		int[] dp0 = new int[41];
		int[] dp1 = new int[41];
		dp0[0] = 1;
		dp1[0] = 0;
		dp0[1] = 0;
		dp1[1] = 1;

		for (int i = 2; i < dp0.length; i++) {
			dp0[i] = dp0[i - 1] + dp0[i - 2];
			dp1[i] = dp1[i - 1] + dp1[i - 2];
		}

		int temp;
		for (int i = 0; i < N; i++) {
			temp = Integer.parseInt(input.readLine());
			output.append(dp0[temp] + " " + dp1[temp] + "\n");
		}

		System.out.println(output);
	}
}
