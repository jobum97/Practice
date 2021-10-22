import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 static StringBuilder output = new StringBuilder();
	 static String src = "3 7";

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		int[] data = new int[1000];

		int index = 0;
		int num = 1;
		while (index <= 999) {
			for (int i = index; i < index + num; i++) {
				if (i > 999) {
					continue;
				}
				data[i] = num;
			}
			index += num;
			num++;
		}
		StringTokenizer str = new StringTokenizer(input.readLine());
		int start = Integer.parseInt(str.nextToken());
		int end = Integer.parseInt(str.nextToken());
		int sum = 0;
		for (int i = start - 1; i < end; i++) {
			sum += data[i];
		}
		System.out.println(sum);
	}
}
