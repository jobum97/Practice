package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

//3초 8MB
public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "100\r\n" + "5\r\n" + "2\r\n" + "3\r\n" + "1\r\n" + "4\r\n" + "2\r\n" + "3\r\n" + "5\r\n"
			+ "1\r\n" + "5\r\n" + "2\r\n" + "3\r\n" + "1\r\n" + "4\r\n" + "2\r\n" + "3\r\n" + "5\r\n" + "1\r\n"
			+ "5\r\n" + "2\r\n" + "3\r\n" + "1\r\n" + "4\r\n" + "2\r\n" + "3\r\n" + "5\r\n" + "1\r\n" + "5\r\n"
			+ "2\r\n" + "3\r\n" + "1\r\n" + "4\r\n" + "2\r\n" + "3\r\n" + "5\r\n" + "1\r\n" + "5\r\n" + "2\r\n"
			+ "3\r\n" + "1\r\n" + "4\r\n" + "2\r\n" + "3\r\n" + "5\r\n" + "1\r\n" + "5\r\n" + "2\r\n" + "3\r\n"
			+ "1\r\n" + "4\r\n" + "2\r\n" + "3\r\n" + "5\r\n" + "1\r\n" + "5\r\n" + "2\r\n" + "3\r\n" + "1\r\n"
			+ "4\r\n" + "2\r\n" + "3\r\n" + "5\r\n" + "1\r\n" + "5\r\n" + "2\r\n" + "3\r\n" + "1\r\n" + "4\r\n"
			+ "2\r\n" + "3\r\n" + "5\r\n" + "1\r\n" + "5\r\n" + "2\r\n" + "3\r\n" + "1\r\n" + "4\r\n" + "2\r\n"
			+ "3\r\n" + "5\r\n" + "1\r\n" + "5\r\n" + "2\r\n" + "3\r\n" + "1\r\n" + "4\r\n" + "2\r\n" + "3\r\n"
			+ "5\r\n" + "1\r\n" + "5\r\n" + "2\r\n" + "3\r\n" + "1\r\n" + "4\r\n" + "2\r\n" + "3\r\n" + "5\r\n"
			+ "1\r\n" + "7";

	public static void main(String args[]) throws IOException {
		// input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		int n = Integer.parseInt(input.readLine());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int temp;

		for (int i = 0; i < n; i++) {
			temp = Integer.parseInt(input.readLine());
			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}

		}

		for (Integer i : map.keySet()) {
			for (int j = 0; j < map.get(i); j++) {
				output.append(i + "\n");
			}
		}

		System.out.print(output);
	}
}