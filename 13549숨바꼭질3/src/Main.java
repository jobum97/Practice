import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "5 99998";

	static int N, K, count, timeTable[][], dp[];
	static boolean checked[];
	static PriorityQueue<footPrint> PQ;

	public static void main(String[] args) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		StringTokenizer str = new StringTokenizer(input.readLine());

		N = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());

		dp = new int[100001];
		checked = new boolean[100001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[N] = 0;
		PQ = new PriorityQueue<>();

		PQ.add(new footPrint(N, 0));
		while (!PQ.isEmpty()) {
			footPrint cur = PQ.poll();
			//System.out.println(cur.position+" "+ cur.time);

			if (cur.position == K) {
				//System.out.println(cur.time);
				break;
			}

			for (int i = 0; i < 3; i++) {

				int next = 0;
				if (i == 0) {
					next = cur.position - 1;
				} else if (i == 1) {
					next = cur.position + 1;
				} else if (i == 2) {
					next = cur.position * 2;
				}

				if (next < 0 || next > 100000) {
					continue;
				}

				if (i == 2) {
					//시간을 줄인다면
					if (dp[next] > cur.time) {
						dp[next] = cur.time;
						PQ.add(new footPrint(next, cur.time));
					}
				} else {
					if (dp[next] > cur.time + 1) {
						dp[next] = cur.time + 1;
						PQ.add(new footPrint(next, cur.time + 1));
					}
				}

			}
		}

		System.out.println(dp[K]);
	}


	static class footPrint implements Comparable<footPrint> {
		int position;
		int time;

		public footPrint(int position, int time) {
			this.position = position;
			this.time = time;
		}

		@Override
		public int compareTo(footPrint o) {
			if (this.time == o.time) {
				return this.position - o.position;
			} else {
				return this.time - o.time;
			}
		}
	}
}
