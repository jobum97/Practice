import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "5 2\n" +
			"1 2 0 0 0\n" +
			"1 2 0 0 0\n" +
			"1 2 0 0 0\n" +
			"1 2 0 0 0\n" +
			"1 2 0 0 0";

	static int n, m, count, map[][];

	public static void main(String[] args) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		StringTokenizer str = new StringTokenizer(input.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());

		map = new int[n + 1][n + 1];

		ArrayList<House> houses = new ArrayList<>();
		ArrayList<Chicken> chickens = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			str = new StringTokenizer(input.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());

				if (map[i][j] == 1) {
					houses.add(new House(i, j));
				} else if (map[i][j] == 2) {
					chickens.add(new Chicken(i, j, 0));
				}
			}
			System.out.println(Arrays.toString(map[i]));
		}
		// 0 : 빈 칸, 1 : 집, 2: 치킨집
		// 치킨 거리 : 집에서 가장 가까운 치킨집사이의 거리 (대각선 아님)
		// 치킨집 최대 m 개 고르면서 도시의 치킨 거리 최소화
		// 각 집의 치킨 거리 BFS로 구하고 어떤 치킨집을 고르는지 기록하여 치킨집에 우선순위 부여

	}

	static class House {
		int row;
		int col;
		Chicken closeChicken;

		public House(int row, int col) {
			this.row = row;
			this.col = col;
		}

		public Chicken getCloseChicken() {
			return closeChicken;
		}

		public void setCloseChicken(Chicken closeChicken) {
			this.closeChicken = closeChicken;
		}
	}

	static class Chicken {
		int row;
		int col;
		int chickenLen;

		public Chicken(int row, int col, int chickenLen) {
			this.row = row;
			this.col = col;
			this.chickenLen = chickenLen;
		}
	}
}
