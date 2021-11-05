import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 static StringBuilder output = new StringBuilder();
	 static String src = "5\r\n"
	 		+ "12 7 9 15 5\r\n"
	 		+ "13 8 11 19 6\r\n"
	 		+ "21 10 26 31 16\r\n"
	 		+ "48 14 28 35 25\r\n"
	 		+ "52 20 32 41 49";
	 
	 static int n, m, count;

	public static void main(String[] args) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		int N = Integer.parseInt(input.readLine());
		StringTokenizer str;
		PriorityQueue<Integer> PQ = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				PQ.add(Integer.parseInt(str.nextToken()));
				if (PQ.size() > N) {
					PQ.poll();
				}
			}
		}

		System.out.println(PQ.poll());

	}
}
