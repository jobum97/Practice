import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 static StringBuilder output = new StringBuilder();
	 static String src = "3\n" +
			 "leo\n" +
			 "kiki\n" +
			 "eden\n" +
			 "eden\n" +
			 "kiki";
	 static int n, m, count;

	public static void main(String[] args) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		int N = Integer.parseInt(input.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String name = input.readLine();

			if (map.containsKey(name)) {
				map.put(name, map.get(name) + 1);
			} else {
				map.put(name, 1);
			}
		}
		for (int i = 0; i < N - 1; i++) {
			String name = input.readLine();
			map.replace(name, map.get(name) - 1);
		}
		for (Map.Entry<String, Integer> entrySet : map.entrySet()) {
			if (entrySet.getValue() >= 1) {
				System.out.println(entrySet.getKey());
				break;
			}
		}



	}
}