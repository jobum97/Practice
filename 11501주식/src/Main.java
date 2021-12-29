import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 static StringBuilder output = new StringBuilder();
	 static String src = "3\n" +
			 "3\n" +
			 "10 7 6\n" +
			 "3\n" +
			 "3 5 9\n" +
			 "7\n" +
			 "1 1 3 1 7 1 5";


	public static void main(String[] args) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		int t = Integer.parseInt(input.readLine());
		for (int testcase = 1; testcase <= t; testcase++) {

			int days = Integer.parseInt(input.readLine());

			int data[] = new int[days];
			StringTokenizer str = new StringTokenizer(input.readLine());

			for (int i = 0; i < days; i++) {
				data[i] = Integer.parseInt(str.nextToken());
			}
			long totalProfit = 0;
			int highestP = 0;
			for (int i = days - 1; i >= 0; i--) {
				if (data[i] > highestP) {
					highestP = data[i];
				} else {
					totalProfit += highestP - data[i];
				}
			}
			output.append(totalProfit + "\n");
		}
		System.out.println(output);
	}

}
