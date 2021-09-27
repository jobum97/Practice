import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="5\n" +
			"-1\n" +
			"-2\n" +
			"-3\n" +
			"-1\n" +
			"-2";

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		int N = Integer.parseInt(input.readLine());

		int[] data = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(input.readLine());
			sum += data[i];
		}

		Arrays.sort(data);

		PriorityQueue<element> PQ = new PriorityQueue<>();

		//System.out.println(Arrays.toString(data));

		int temp = data[0];
		int count = 1;
		for (int i = 1; i < N; i++) {

			if (temp == data[i]) {
				count++;
			} else {
				PQ.add(new element(temp, count));
				count = 1;
			}
			temp = data[i];
		}
		PQ.add(new element(temp, count));

		element M = PQ.poll();
		int many = M.num;
		if (!PQ.isEmpty() && M.count == PQ.peek().count) {
			many = PQ.peek().num;
		}

		int middle = N / 2;
		if (N == 1) {
			middle = 0;
		}
		//산술평균
		System.out.println(Math.round((double) sum / N));
		//중앙값
		System.out.println(data[middle]);
		//최빈값
		System.out.println(many);
		//범위
		System.out.println(data[N - 1] - data[0]);
	}

	public static class element implements Comparable<element> {

		int num;
		int count;

		public element(int num, int count) {
			this.num = num;
			this.count = count;
		}

		@Override
		public int compareTo(element o) {
			if (o.count == this.count) {
				return this.num - o.num;
			} else {
				return o.count - this.count;
			}
		}
	}
}