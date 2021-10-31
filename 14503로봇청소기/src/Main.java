import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "11 10\n" +
			"7 4 0\n" +
			"1 1 1 1 1 1 1 1 1 1\n" +
			"1 0 0 0 0 0 0 0 0 1\n" +
			"1 0 0 0 1 1 1 1 0 1\n" +
			"1 0 0 1 1 0 0 0 0 1\n" +
			"1 0 1 1 0 0 0 0 0 1\n" +
			"1 0 0 0 0 0 0 0 0 1\n" +
			"1 0 0 0 0 0 0 1 0 1\n" +
			"1 0 0 0 0 0 1 1 0 1\n" +
			"1 0 0 0 0 0 1 1 0 1\n" +
			"1 0 0 0 0 0 0 0 0 1\n" +
			"1 1 1 1 1 1 1 1 1 1";

	static int direction, n, m,count, map[][];
	static boolean checked[][], flag;
	static int[][] moveSet = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		StringTokenizer str = new StringTokenizer(input.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());

		str = new StringTokenizer(input.readLine());
		int robot_row = Integer.parseInt(str.nextToken());
		int robot_col = Integer.parseInt(str.nextToken());
		direction = Integer.parseInt(str.nextToken());
		//0:북, 1:동, 2:남, 3:서

		map = new int[n][m];
		checked = new boolean[n][m];
		count = 0;
		flag = false;
		for (int i = 0; i < n; i++) {
			str = new StringTokenizer(input.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
			//System.out.println(Arrays.toString(map[i]));
		}
		Sol(robot_row, robot_col, direction);
		System.out.println(count);
	}

	//1.현재 위치를 청소한다.
	//2.현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색한다.
	//	왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
	//	왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
	//	네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
	//	네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
	//로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.

	public static void Sol(int robot_row, int robot_col, int robot_dir) {
		int curRow = robot_row;
		int curCol = robot_col;
		int curDir = robot_dir;
		if (flag) {
			return;
		}
		checked[curRow][curCol] = true; //1.현재 위치를 청소한다.
		count++;
		//System.out.println("청소 " + curRow + " " + curCol + " " + count + " " + curDir);
		Sol2(curRow, curCol, curDir);

	}
	public static void Sol2(int robot_row, int robot_col, int robot_dir) {
		if (flag) {
			return;
		}
		int curRow = robot_row;
		int curCol = robot_col;
		int curDir = robot_dir;
		int nextRow;
		int nextCol;

		boolean noDir = true;
		for (int i = 0; i < 4; i++) {
			//회전
			if (curDir == 0) {
				curDir = 3;
			} else {
				curDir--;
			}
			nextRow = curRow + moveSet[curDir][0];
			nextCol = curCol + moveSet[curDir][1];

			//맵을 벗어나는 경우 or 벽인 경우
			if ((nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m) || map[nextRow][nextCol] == 1) {
				continue;
			}
			//왼쪽 방향에 청소할 공간 있는 경우
			if (map[nextRow][nextCol] == 0 && !checked[nextRow][nextCol]) {
				Sol(nextRow, nextCol, curDir); //1번으로 돌아간다
			}

			noDir |= (checked[nextRow][nextCol] || map[nextRow][nextCol] == 1); //4방향 모두 청소되거나 벽인 경우를 카운트
		}

		//4방향이 모두 청소되어 있는 경우
		if (noDir) {
			//후진 안되는 경우 끝나야함
			int backRow = curRow - moveSet[curDir][0];
			int backCol = curCol - moveSet[curDir][1];
			if (map[backRow][backCol] == 1 || (backRow < 0 || backCol < 0 || backRow >= n || backCol >= m)) {
				flag = true;
				return;
			}
			//후진
			Sol2(backRow, backCol, curDir);
		}


	}
}
