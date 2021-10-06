import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "3\n" +
			"1234 3411\n" +
			"1000 1\n" +
			"1 16";
	static String[] set = {"D", "S", "L", "R"};
	public static void main(String arg[]) throws IOException {

		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		int testcase = Integer.parseInt(input.readLine());

		for (int t = 0; t < testcase; t++) {
			StringTokenizer str = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(str.nextToken());
			int target = Integer.parseInt(str.nextToken());

			Queue<Integer> queue = new LinkedList<>();
			String checked[] = new String[10001];
			boolean visited[] = new boolean[10001];
			queue.add(start);
			visited[start] = true;

			while (!queue.isEmpty()) {
				int next;
				int cur = queue.poll();
				//System.out.println(cur);
				if (cur == target) {
					System.out.println(checked[cur]);
					break;
				}
				for (int i = 0; i < 4; i++) {
					if (i == 0) {
						next = D(cur);
					} else if (i == 1) {
						next = S(cur);
					} else if (i == 2) {
						next = L(cur);
					} else {
						next = R(cur);
					}


					if (!visited[next]) {
						queue.add(next);
						visited[next] = true;
						if (checked[cur] == null) {
							checked[next] = set[i];
						} else {
							checked[next] = checked[cur] + set[i];
						}
					}
				}
			}

//			for (int i = 0; i < checked.length; i++) {
//				if (checked[i] != null) {
//					System.out.print(i+":"+ checked[i]+" ");
//				}
//			}
//			System.out.println();
		}

	}

	public static int D(int input) {
		int temp = input * 2;
		if (temp > 9999) {
			temp %= 10000;
		}
		return temp;
	}

	public static int S(int input) {
		int temp;
		if (input == 0) {
			temp = 9999;
		} else {
			temp = input - 1;
		}
		return temp;
	}

	public static int L(int input) {

		return (input % 1000) * 10 + input / 1000;
	}

	public static int R(int input) {

		return (input % 10) * 1000 + input / 10;
	}

}
