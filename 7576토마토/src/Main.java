import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "6 4\n" +
			"0 -1 0 0 0 0\n" +
			"-1 0 0 0 0 0\n" +
			"0 0 0 0 0 0\n" +
			"0 0 0 0 0 1";

	static int row, col, data[][], moveSet[][] = {{0, -1}, {1, 0}, {-1, 0}, {0, 1}};
	static boolean isChecked[][];

	public static void main(String[] args) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		StringTokenizer str = new StringTokenizer(input.readLine());


		col = Integer.parseInt(str.nextToken());
		row = Integer.parseInt(str.nextToken());

		data = new int[row][col];
		isChecked = new boolean[row][col];

		PriorityQueue<Coord> pq = new PriorityQueue<>();

		for (int i = 0; i < row; i++) {
			str = new StringTokenizer(input.readLine());
			for (int j = 0; j < col; j++) {
				data[i][j] = Integer.parseInt(str.nextToken());
				if (data[i][j] == 1) {
					pq.add(new Coord(i, j, 0));
					isChecked[i][j] = true;
				} else if (data[i][j] == -1) {
					isChecked[i][j] = true;
				}
			}
			//System.out.println(Arrays.toString(data[i]));
		}

		// 1은 익은 토마토, 0 은 안 익은 토마토, -1 은 빈칸
		// 익은 토마토 하루 마다 상하좌우 토마토 익게 만듬
		// 최소 일수로 모두 익게 하는 날수는?

		int curRow, curCol, nextRow, nextCol, curDay = 0;

		while (!pq.isEmpty()) {
			Coord cur = pq.poll();
			curRow = cur.row;
			curCol = cur.col;
			curDay = cur.day;

			//System.out.println(curRow + " " + curCol+" "+curDay);

			for (int i = 0; i < 4; i++) {
				nextRow = curRow + moveSet[i][0];
				nextCol = curCol + moveSet[i][1];

				//범위 벗어나면 컷
				if (nextRow < 0 || nextCol < 0 || nextRow >= row || nextCol >= col) {
					continue;
				}

				//빈칸 아니고 이미 간곳 아니면 체크
				if (!isChecked[nextRow][nextCol] && data[nextRow][nextCol] != -1) {

					isChecked[nextRow][nextCol] = true;
					pq.add(new Coord(nextRow, nextCol, curDay + 1));
				}

			}
		}


		boolean isValid = true;
		loop:
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (!isChecked[i][j]) {
					isValid = false;
					break loop;
				}
			}
		}

		if (isValid) {
			System.out.println(curDay);
		} else {
			System.out.println(-1);
		}

	}

	public static class Coord implements Comparable<Coord> {
		int row;
		int col;
		int day;

		public Coord(int row, int col, int day) {
			this.row = row;
			this.col = col;
			this.day = day;
		}

		@Override
		public int compareTo(Coord o) {
			return this.day - o.day;
		}
	}
}
