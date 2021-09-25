import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="3\n" +
			"4 2\n" +
			"1 3 1 2\n" +
			"4 2\n" +
			"1 2 1 3\n" +
			"6 0\n" +
			"1 1 9 1 1 1";

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		int t = Integer.parseInt(input.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			StringTokenizer str = new StringTokenizer(input.readLine());
			int N = Integer.parseInt(str.nextToken());
			int M = Integer.parseInt(str.nextToken()); // M번째 문서의 출력순서 가 궁금한 것

			ArrayList<element> data = new ArrayList<>();

			str = new StringTokenizer(input.readLine());
			for (int i = 0; i < N ; i++) {
				data.add(new element(i, Integer.parseInt(str.nextToken())));
			}
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if (data.get(i).weight < data.get(j).weight) {
						data.add(data.get(i));
						data.remove(i);
						i--;
						break;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				if (data.get(i).index == M) {
					output.append((i+1) + "\n");
				}
			}

		}

		//결국엔 중요도순으로 출력, 중요도가 같은 경우
		System.out.println(output);

	}

	public static class element  {
		public int index;
		public int weight;

		public element(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}

	}
}

