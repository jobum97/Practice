import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="3 5\n" +
			"0 0 0 2 0";

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		int H, W, result = 0;

		StringTokenizer str = new StringTokenizer(input.readLine());

		H = Integer.parseInt(str.nextToken());
		W = Integer.parseInt(str.nextToken());

		str = new StringTokenizer(input.readLine());
		boolean[][] Map = new boolean[H][W];

		for (int j = 0; j < W; j++) {
			int curH = Integer.parseInt(str.nextToken());
			for (int i = H - 1; i > H - curH - 1; i--) {
				Map[i][j] = true;
			}
		}

		int count;
		boolean flag; //이전에 true 가 있었는지
		//true 사이의 false 갯수 세어줄 것임
		for (int i = H - 1; i >= 0; i--) {
			flag = false;
			count = 0;
			for (int j = 0; j < W; j++) {
				//true 이면 다음 true 올때까지의 false 세어줌
				//이전에 세던 것이 있으면 count 결과에 더해줌
				if (Map[i][j]) {
					flag = true;
					//System.out.println(i+" "+ j+" "+count);
					result += count;
					count = 0;
				}
				if (!Map[i][j] && flag) {
					count++;
				}
			}

		}
		System.out.println(result);
	}

}