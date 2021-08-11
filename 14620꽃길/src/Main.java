import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="6\n" +
			"1 0 2 3 3 4\n" +
			"1 1 1 1 1 1\n" +
			"0 0 1 1 1 1\n" +
			"3 9 9 0 1 99\n" +
			"9 11 3 1 0 3\n" +
			"12 3 0 0 0 1";
	
	static int N;
	static int CenterRange;
	static int Cost = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] set = {{0, 0}, {-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static boolean[][] checked;

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));
		StringTokenizer str;

		N = Integer.parseInt(input.readLine());
		CenterRange = N - 1;
		map = new int[N][N];
		checked = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}

//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		placeFlower(0, 0);
		System.out.println(Cost);


	}

	public static void placeFlower(int cost, int flower) {
		//꽃이 3개 심어지면 비용 비교하여 최소비용 갱신하고 리턴
		if (flower == 3) {
			//System.out.println("다심음 " +cost);
			Cost = Math.min(Cost, cost);
			return;
		}
		for (int row = 0; row < N - 1; row++) {
			for (int col = 0; col < N - 1; col++) {
				if (checkPlace(row, col)) {
					int flowerCost =0;
					for (int i = 0; i < 5; i++) {
						int flowerRow = row + set[i][0];
						int flowerCol = col + set[i][1];
						checked[flowerRow][flowerCol] = true;
						flowerCost += map[flowerRow][flowerCol];
					}
					placeFlower(cost + flowerCost, flower + 1);
					//System.out.println("심는다 "+row+" "+col);

					checked[row][col] = false;
					for (int i = 0; i < 5; i++) {
						int flowerRow = row + set[i][0];
						int flowerCol = col + set[i][1];
						checked[flowerRow][flowerCol] = false;
					}
				}
			}
		}

	}

	//꽃이 심어질수 있는지 체크하는 메소드
	public static boolean checkPlace(int row, int col){
		if(checked[row][col]){
			return false;
		}
		for (int i = 1; i < 5; i++) {
			int nextRow = row + set[i][0];
			int nextCol = col + set[i][1];
			if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > N - 1 || checked[nextRow][nextCol])  {
				return false;
			}
		}
		return true;
	}

}