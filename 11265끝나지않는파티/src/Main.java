import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 static StringBuilder output = new StringBuilder();
	 static String src = "5 10\n" +
			 "0 4 4 8 7\n" +
			 "7 0 7 7 4\n" +
			 "1 4 0 5 4\n" +
			 "5 2 2 0 7\n" +
			 "1 4 1 6 0\n" +
			 "1 3 8\n" +
			 "2 4 1\n" +
			 "4 1 1\n" +
			 "1 5 5\n" +
			 "3 2 1\n" +
			 "3 2 5\n" +
			 "4 5 10\n" +
			 "5 3 2\n" +
			 "1 4 1\n" +
			 "1 4 11";

	 static int N, M, count, timeTable[][];

	public static void main(String[] args) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		StringTokenizer str = new StringTokenizer(input.readLine());

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		timeTable = new int[N + 1][N + 1];
		int temp = 0;

		for (int i = 1; i <= N; i++) {
			str = new StringTokenizer(input.readLine());
			for (int j = 1; j <= N; j++) {
				temp = Integer.parseInt(str.nextToken());
				if (i == j) {
					continue;
				}
				//길이 없을 경우도 고려 해야함
				timeTable[i][j] = temp;
			}
			//System.out.println(Arrays.toString(timeTable[i]));
		}

		//플로이드-와샬 경유지 for 문이 맨위로 올라와야함
		for (int m = 1; m <= N; m++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					timeTable[s][e] = Math.min(timeTable[s][e], timeTable[s][m] + timeTable[m][e]);
				}
			}
		}
//		System.out.println("=====================");
//		for (int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(timeTable[i]));
//		}

		for (int i = 0; i < M; i++) {
			str = new StringTokenizer(input.readLine());
			int s = Integer.parseInt(str.nextToken());
			int e = Integer.parseInt(str.nextToken());
			int limit = Integer.parseInt(str.nextToken());
			//시간맞추면
			if (timeTable[s][e] <= limit) {
				output.append("Enjoy other party\n");
			} else {
				output.append("Stay here\n");
			}
		}
		System.out.print(output);


	}

}
