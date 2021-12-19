import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 static StringBuilder output = new StringBuilder();
	 static String src = "6 6\n" +
			 "011110\n" +
			 "100110\n" +
			 "110110\n" +
			 "000110\n" +
			 "011110\n" +
			 "000000";

    static int[][] moveSet = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String arg[]) throws IOException {

		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		StringTokenizer str = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());

		int[][] map = new int[N][M];
		boolean visited[][][] = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			char[] temp = input.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = (int) temp[j] - '0';
			}
		}

		int answer = -1;
		Queue<footPrint> queue = new LinkedList<>();
		queue.add(new footPrint(0, 0, 1, 1));
		visited[0][0][1] = true;
		while (!queue.isEmpty()) {
			footPrint curStatus = queue.poll();
			//System.out.println(curStatus.row+" "+curStatus.col+" "+ curStatus.chance+" "+ curStatus.length);
			if (curStatus.row == N - 1 && curStatus.col == M - 1) {
				answer= curStatus.length;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nextRow = curStatus.row + moveSet[i][0];
				int nextCol = curStatus.col + moveSet[i][1];
				int chance = curStatus.chance;
				//범위 벗어나면 컷
				if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) {
					continue;
				}

				// 벽을 만났는데 못부시면 컷
				if (map[nextRow][nextCol] == 1 && chance == 0) {
					continue;
				}
				if (map[nextRow][nextCol] == 1 && chance == 1) {
					chance = 0;
				}

				// 방문 한적 없는 곳이면 드가자~
				if (!visited[nextRow][nextCol][chance]) {
					queue.add(new footPrint(nextRow, nextCol, chance, curStatus.length + 1));
					visited[nextRow][nextCol][chance] = true;
				}

			}

		}
		System.out.println(answer);

	}

	static class footPrint{
		int row;
		int col;
		int chance;
		int length;

		public footPrint(int row, int col, int chance, int length) {
			this.row = row;
			this.col = col;
			this.chance = chance;
			this.length = length;
		}
	}
}