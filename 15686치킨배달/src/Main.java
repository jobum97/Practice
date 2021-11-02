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
	static String src = "5 1\n" +
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
					chickens.add(new Chicken(i, j));
				}
			}
			//System.out.println(Arrays.toString(map[i]));
		}
		// 0 : 빈 칸, 1 : 집, 2: 치킨집
		// 치킨 거리 : 집에서 가장 가까운 치킨집사이의 거리 (대각선 아님)
		// 치킨집 최대 m 개 고르면서 도시의 치킨 거리 최소화
		// 각 집의 치킨 거리 BFS로 구하고 어떤 치킨집을 고르는지 기록하여 치킨집에 우선순위 부여
		// 치킨집 조합 =>

		int minChickenLen = Integer.MAX_VALUE;

		for (int i = 1; i < (1 << chickens.size()); i++) {
			//i 를 2진수로 표현했을 때 1의 개수로 몇개를 선택했는지 표현할 수 있음
			// 아래의 경우 2개를 선택한 경우를 보려고 함
			if (Integer.bitCount(i) == m) {
				ArrayList<Chicken> selected = new ArrayList<>();
				// 0001에서 1을 한칸씩 이동시키면서 & 연산으로 어떤 요소를 선택했는지 검사
				for (int j = 0; j < chickens.size(); j++) {
					// & 연산했는데 0 이 아니라는 것은 둘다 1 즉 j 번째 요소 선택했다는 의미
					if ((i & (1 << j)) != 0) {
						//System.out.print(chickens.get(j).row+" "+chickens.get(j).col+" | ");
						selected.add(new Chicken(chickens.get(j).row, chickens.get(j).col));
					}
				}
				//System.out.println();
				int totalLen = 0;
				for (int j = 0; j < houses.size(); j++) {
					int curH_Row = houses.get(j).row;
					int curH_Col = houses.get(j).col;
					int chickenLen = Integer.MAX_VALUE;
					for (int k = 0; k < selected.size(); k++) {
						chickenLen = Math.min(chickenLen, Math.abs(curH_Row - selected.get(k).row) + Math.abs(curH_Col - selected.get(k).col));
					}
					totalLen += chickenLen;
				}
				//System.out.println(totalLen);
				minChickenLen = Math.min(totalLen, minChickenLen);
			}
		}
		System.out.println(minChickenLen);
	}

	static class House {
		int row;
		int col;

		public House(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static class Chicken {
		int row;
		int col;

		public Chicken(int row, int col ){
			this.row = row;
			this.col = col;
		}
	}
}
