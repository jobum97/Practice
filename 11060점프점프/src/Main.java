import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 static StringBuilder output = new StringBuilder();
	 static String src = "6\n" +
			 "1 2 1 0 3 1";


	public static void main(String[] args) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		int N = Integer.parseInt(input.readLine());
		StringTokenizer str = new StringTokenizer(input.readLine());
		int data[] = new int[N];
		int dp[] = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(str.nextToken());
		}
		Arrays.fill(dp,2000);
		dp[0] = 0;
		int curIndex = 0;
		while (curIndex < N) {
			int range = data[curIndex];
//			System.out.println(curIndex+" "+range);
			for (int i = curIndex+1; i <= curIndex + range; i++) {
				if (i >= N) {
					break;
				}
				dp[i] = Math.min(dp[curIndex] + 1, dp[i]);
			}
			curIndex++;
		}
//		System.out.println(Arrays.toString(data));
//		System.out.println(Arrays.toString(dp));
		if (dp[N - 1] == 2000) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N - 1]);
		}

	}



	/*public static void main(String arg[]) throws IOException {

		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		int N = Integer.parseInt(input.readLine());
		StringTokenizer str = new StringTokenizer(input.readLine());
		int data[] = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(str.nextToken());
		}
		int curIndex = 0;
		int cnt = 0;
		while (curIndex < N) {
			int range = data[curIndex];
			System.out.println(curIndex+" "+cnt+" "+(curIndex+range));
			int maxNext = 0;
			for (int i = curIndex; i < curIndex + range; i++) {
				if (i >= N) {
					break;
				}
				//System.out.println(i+" "+(i+data[i]));
				maxNext = Math.max(i + data[i], maxNext);
			}
			if (maxNext < curIndex + range) {
				cnt = -1;
				break;
			}
			curIndex = maxNext;
			cnt++;
		}
		System.out.println(cnt);
	}*/

}
