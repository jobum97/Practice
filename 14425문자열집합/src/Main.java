import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 static StringBuilder output = new StringBuilder();
	 static String src = "5 11\n" +
			 "baekjoononlinejudge\n" +
			 "startlink\n" +
			 "codeplus\n" +
			 "sundaycoding\n" +
			 "codingsh\n" +
			 "baekjoon\n" +
			 "codeplus\n" +
			 "codeminus\n" +
			 "startlink\n" +
			 "starlink\n" +
			 "sundaycoding\n" +
			 "codingsh\n" +
			 "codinghs\n" +
			 "sondaycoding\n" +
			 "startrink\n" +
			 "icerink";
	 static int n, m, count;

	public static void main(String[] args) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		StringTokenizer str = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());

		HashSet<String> set = new HashSet<>();
		int Cnt = 0;
		for (int i = 0; i < N; i++) {
			set.add(input.readLine());
		}
		for (int i = 0; i < M; i++) {
			String check = input.readLine();

			if (set.contains(check)) {
				Cnt++;
			}
		}

		System.out.println(Cnt);

	}
}