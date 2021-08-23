import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="5 5 5\n" +
			"5 7 8 2 3\n" +
			"1 4 5\n" +
			"5 2 4\n" +
			"3 2 3\n" +
			"3 1 1\n" +
			"1 2 3";

	static int N, M, R, result;
	static int[][] distance;
	static int[] itemData;

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		StringTokenizer str = new StringTokenizer(input.readLine());
		N = Integer.parseInt(str.nextToken()); //지역의 개수
		M = Integer.parseInt(str.nextToken()); // 수색 범위
		R = Integer.parseInt(str.nextToken()); // 길의 개수

		//이차원 배열
		distance = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					continue;
				}
				distance[i][j] = 10000;
			}
		}

		//지역 가치 담을 배열
		itemData = new int[N + 1];
		str = new StringTokenizer(input.readLine());
		for (int i = 1; i <= N; i++) {
			itemData[i] = Integer.parseInt(str.nextToken());
		}

		for (int i = 0; i < R; i++) {
			str = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			int cost = Integer.parseInt(str.nextToken());

			distance[start][end] = cost;
			distance[end][start] = cost;

		}

		//플로이드 와샬 : k가 중간지점
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					//중간지점 거쳐 가는 것이 더 빠르면 갱신
					if (distance[i][k] + distance[k][j] < distance[i][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}

		result = 0;
		int temp;

		for (int i = 1; i <= N; i++) {
			temp = itemData[i]; //시작지점
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					continue;
				}
				//탐색범위 안이면
				if (distance[i][j] <= M) {
					temp += itemData[j];
				}

			}
			result = Math.max(result, temp);
		}

		System.out.println(result);

	}


}