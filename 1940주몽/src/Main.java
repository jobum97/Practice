import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 static StringBuilder output = new StringBuilder();
	 static String src = "6\r\n"
	 		+ "9\r\n"
	 		+ "2 7 4 1 5 3";

	public static void main(String arg[]) throws IOException {

		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		int N = Integer.parseInt(input.readLine()); //재료의 개수 (1~15000)
		int M = Integer.parseInt(input.readLine()); //갑옷을 만드는데 필요한 수 (1 ~ 10,000,000)

		int[] data = new int[N];
		boolean[] checked = new boolean[N];
		StringTokenizer str = new StringTokenizer(input.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(str.nextToken());
		}
		//System.out.println(Arrays.toString(data));

		//숫자 두개 합쳐 M 최대한 많이 만들기
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//재료 쓴적 없고 둘의 합이 M인 경우 둘을 사용
//				if (!checked[i] && !checked[j] && data[i] + data[j] == M) {
//					checked[i] = true;
//					checked[j] = true;
//					cnt++;
//					break;
//				}
				if (data[i] + data[j] == M) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt/2);
	}
}
