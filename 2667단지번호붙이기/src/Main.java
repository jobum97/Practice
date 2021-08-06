import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "7\n" +
			"0110100\n" +
			"0110111\n" +
			"1010111\n" +
			"1000111\n" +
			"1100000\n" +
			"0111110\n" +
			"0111000";

	static int[][] map;
	static boolean[][] checked;
	static int N;
	static ArrayList<Integer> result;
	static int[][] moveSet = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; //하 우 상 좌

	public static void main(String args[]) throws IOException {
		// input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		result = new ArrayList<>();
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		checked = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = Stream.of((input.readLine()).split("")).mapToInt(Integer::parseInt).toArray();
		}

		/*for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}*/
		int blockNum=0;
		while(true){
			Point next = next1();
			if (next.row == N && next.col == N) {
				break;
			}
			makeBlock(next);
			blockNum++;
		}
		output.append(blockNum + "\n");
		Collections.sort(result);

		for (int num : result) {
			output.append(num+"\n");
		}
		System.out.println(output);
	}

	public static void makeBlock(Point curP){

		Queue<Point> queue = new LinkedList<>();
		checked[curP.row][curP.col] = true;
		queue.add(curP);
		int num=1;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int row= cur.row+moveSet[i][0];
				int col = cur.col + moveSet[i][1];

				if (row < 0 || row > N - 1 ||col < 0 || col > N - 1 ) { //맵밖인 경우 제외
					continue;
				}
				if (!checked[row][col] && map[row][col] == 1) { //방문한적 없고 1인 곳
					checked[row][col] = true; //방문 체크
					queue.add(new Point(row, col));
					//System.out.println(row+" "+col);
					num++;
				}
			}
		}
		result.add(num);
	}


	public static Point next1(){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!checked[i][j] && map[i][j] == 1) {
					return new Point(i, j);
				}
			}
		}
		return new Point(N, N);
	}
}

class Point{
	public int row;
	public int col;

	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}