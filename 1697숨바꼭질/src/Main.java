import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "5 17";

	public static void main(String arg[]) throws IOException {

		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		StringTokenizer str = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(str.nextToken()); //수빈 위치
		int K = Integer.parseInt(str.nextToken()); //동생 위치

		if (N == K) {
			System.out.println(0);
		} else {
			BFS(N, K);
		}
	}

	public static void BFS(int curP, int targetP) {

		Queue<Integer> PQ = new LinkedList<>();
		int[] times = new int[100001];

		PQ.add(curP);
		times[curP] = 1;

		while (!PQ.isEmpty()) {
			int cur = PQ.poll();

			for (int i = 0; i < 3; i++) {
				int next;

				if (i == 0) {
					next = cur + 1;
				} else if (i == 1) {
					next = cur - 1;
				} else {
					next = cur * 2;
				}

				if (next == targetP) {
					System.out.println(times[cur]);
					return;
				}
				// 다음이 0 이상, 100000이하 즉 범위 안에서 가보지 않은 곳이면 add
				if (next >= 0 && next < times.length && times[next] == 0) {
					PQ.add(next);
					times[next] = times[cur] + 1;
				}
			}
			
		}
		
	}
}
