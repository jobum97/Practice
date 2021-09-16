import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "2\r\n"
			+ "10 8 17\r\n"
			+ "0 0\r\n"
			+ "1 0\r\n"
			+ "1 1\r\n"
			+ "4 2\r\n"
			+ "4 3\r\n"
			+ "4 5\r\n"
			+ "2 4\r\n"
			+ "3 4\r\n"
			+ "7 4\r\n"
			+ "8 4\r\n"
			+ "9 4\r\n"
			+ "7 5\r\n"
			+ "8 5\r\n"
			+ "9 5\r\n"
			+ "7 6\r\n"
			+ "8 6\r\n"
			+ "9 6\r\n"
			+ "10 10 1\r\n"
			+ "5 5";

	static boolean[][] map, visited;
	static int width, height, answer;
	static int[][] moveSet = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public static void main(String[] args) throws IOException, InterruptedException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		StringTokenizer str;

		for (int testcase = 1; testcase <= T; testcase++) {
			str = new StringTokenizer(input.readLine());
			width = Integer.parseInt(str.nextToken());
			height = Integer.parseInt(str.nextToken());
			int cabbage = Integer.parseInt(str.nextToken());

			map = new boolean[height][width];
			visited = new boolean[height][width];

			for (int i = 0; i < cabbage; i++) {
				str = new StringTokenizer(input.readLine());
				int x = Integer.parseInt(str.nextToken());
				int y = Integer.parseInt(str.nextToken());

				map[y][x] = true;
			}

			int curRow = 0;
			int curCol = 0;
			answer = 0;

			while (true) {

				Point curP = nextSearch(curRow, curCol);
				curRow = curP.row;
				curCol = curP.col;
				//System.out.println(curRow + " " + curCol);

				if (curRow == -1 && curCol == -1) {
					break;
				}
				makeBlock(curRow, curCol);
				answer++;
			}

			System.out.println(answer);
		}


	}


	/*public static boolean nextSearch2(int curRow, int curCol) {
		int row = curRow;
		int col = curCol;
		while (true) {
			if (row == height - 1 && col == width) {
				break;
			}

			col++;
			row += col / width;
			col %= width;

			System.out.println(row+" "+col);

		}
		return false;
	}*/


	public static Point nextSearch(int curRow, int curCol) {
		for (int i = curRow; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (!visited[i][j] && map[i][j]) {
					return new Point(i, j);
				} else {
					visited[i][j] = true;
				}
			}
		}
		return new Point(-1, -1);
	}

	public static void makeBlock(int curRow, int curCol) {

		PriorityQueue<Point> PQ = new PriorityQueue<>();
		PQ.add(new Point(curRow, curCol));
		while (!PQ.isEmpty()) {
			Point curP = PQ.poll();
			//System.out.println("블록만들기 "+curP.row + " " + curP.col);
			visited[curP.row][curP.col] = true;
			for (int i = 0; i < 4; i++) {
				int nextRow = curP.row + moveSet[i][0];
				int nextCol = curP.col + moveSet[i][1];

				//맵 밖으로 나가지면 스킾
				if (nextRow < 0 || nextCol < 0 || nextRow >= height || nextCol >= width) {
					continue;
				}

				//가본적 없고,배추있으면 ok 없으면 x , 공통적으로 방문 체크
				if (!visited[nextRow][nextCol] && map[nextRow][nextCol]) {
					PQ.add(new Point(nextRow, nextCol));
				}
				visited[nextRow][nextCol] = true;
			}
		}
	}


	static class Point implements Comparable<Point> {
		int row;
		int col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public int compareTo(Point o) {
			return 0;
		}
	}
}
