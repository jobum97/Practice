import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "10 8\n" +
			"1 2\n" +
			"2 3\n" +
			"3 4\n" +
			"4 5\n" +
			"6 7\n" +
			"7 8\n" +
			"8 9\n" +
			"9 10";

	static int N, K, INF = 1000;

	public static void main(String[] args) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		StringTokenizer str = new StringTokenizer(input.readLine());

		N = Integer.parseInt(str.nextToken()); //사람 수 1~N
		K = Integer.parseInt(str.nextToken()); // 관계 수

		boolean adj[][] = new boolean[N + 1][N + 1];
		int dist[][] = new int[N + 1][N + 1];

		for (int i = 0; i < K; i++) {
			str = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			adj[start][end] = true;
			adj[end][start] = true;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					dist[i][j] = 0;
				else if (adj[i][j])
					dist[i][j] = 1;
				else
					dist[i][j] = INF;
			}
		}

		/*for (int i = 1; i <= N; i++) {
			System.out.println(Arrays.toString(dist[i]));
		}*/

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		/*for (int i = 1; i <= N; i++) {
			System.out.println(Arrays.toString(dist[i]));
		}*/

		boolean isBig = false;

		Loop:
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (dist[i][j] >= 7) {
					isBig = true;
					break Loop;
				}
			}
		}

		if (isBig) {
			System.out.println("Big World!");
		} else {
			System.out.println("Small World!");
		}
	}
	
}
