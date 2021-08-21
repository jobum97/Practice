import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="3 9 5\n" +
			"2 5\n" +
			"4 6\n" +
			"3 3\n" +
			"4 3\n" +
			"1 4";
	
	static int N, K, result;
	static long M;
	static int[][] data;
	static boolean[] checked;

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		StringTokenizer str = new StringTokenizer(input.readLine());

		N = Integer.parseInt(str.nextToken()); //축제 기간
		M = Integer.parseInt(str.nextToken()); // 선호도 합 (목표치)
		K = Integer.parseInt(str.nextToken()); // 맥주 종류

		//하루에 1병, 먹었던 맥주 다시X
		//마시는 도수레벨 보다 간레벨 높아야됨
		//선호도(초과) 채우면서 N개의 맥주 모두 마실 수 있는 최소 간레벨

		data = new int[K][2];
		checked = new boolean[K];
		result = Integer.MAX_VALUE;

		for (int i = 0; i < K; i++) {
			str = new StringTokenizer(input.readLine());
			int v = Integer.parseInt(str.nextToken()); //선호도
			int c = Integer.parseInt(str.nextToken()); //도수 레벨
			data[i][0] = v;
			data[i][1] = c;
		}

		//도수레벨 오름차순,같은 경우 선호도가 더 높은 순
		Arrays.sort(data, ((o1, o2) -> {
			if (o1[1] == o2[1]) {
				return Integer.compare(o2[0], o1[0]);
			} else {
				return Integer.compare(o1[1], o2[1]);
			}
		}));

		for (int i = 0; i < K; i++) {
			System.out.println(data[i][0]+" "+data[i][1]);
		}


		long tempScore = 0;
		int tempLevel = -1;
		boolean flag = false;
		//비트마스킹 이진수에서 1이 선택한것 0이 선택하지 않은 것
		for (int i = 0; i < 1 << K; i++) {
			// 1을 arr의 크기 K만큼 왼쪽 쉬프트 : 2^K-1, 십진법으로 0부터 2^K-1 까지 모든 경우의수
			if (Integer.bitCount(i) == N) {
				//그중에서 K개 중 N개를 선택 경우 ( 이진법으로 1이 2개인 경우)

				for (int j = 0; j < K; j++) {
					if ((i & (1 << j)) > 0) {
						//1을 j만큼 밀면서 j번째 원소를 선택했는지 확인
						tempScore += data[j][0];
						tempLevel = Math.max(data[j][1], tempLevel);
					}
				}

				if (tempScore >= M) {
					//System.out.println("목표선호넘김 "+tempScore);
					flag = true;
					result = Math.min(tempLevel, result);

				}
				tempScore = 0;
				tempLevel = -1;
			}
		}

		if (flag) {
			System.out.println(result);
		}else {
			System.out.println(-1);
		}
	}

}