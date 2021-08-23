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
	static boolean[] checked;
	static ArrayList<ArrayList<Position>> adjList;
	static int[] itemData, distance;

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		StringTokenizer str = new StringTokenizer(input.readLine());
		N = Integer.parseInt(str.nextToken()); //지역의 개수
		M = Integer.parseInt(str.nextToken()); // 수색 범위
		R = Integer.parseInt(str.nextToken()); // 길의 개수

		//이차원 리스트
		adjList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
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

			adjList.get(start).add(new Position(end, cost));
			adjList.get(end).add(new Position(start, cost));
		}


		///////////////////////////////
		/*System.out.println(Arrays.toString(itemData));
		System.out.println("===============================");
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(adjArr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("============================");
*/
		///////////////////////////////

		//각 지역에서 어느 지역으로 가는데 최소한의 비용을 구할 것임 => minCostMap
		result = 0;
		checked = new boolean[N + 1];
		distance = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			dijkstra(i);
		}

		System.out.println(result);

	}

	static class Position implements Comparable<Position>{
		public int Pos;
		public int cost;

		public Position(int Pos, int cost) {
			this.Pos = Pos;
			this.cost = cost;
		}

		@Override
		public int compareTo(Position o) {
			return this.cost - o.cost;
		}
	}

	public static void dijkstra(int start) {
		Arrays.fill(checked, false);
		checked[0] = true;

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;

		PriorityQueue<Position> PQ = new PriorityQueue<>();
		PQ.add(new Position(start, 0));

		while (!PQ.isEmpty()) {
			Position curP = PQ.poll();
			int pos = curP.Pos;
			//System.out.println("출발"+cur);

			//가본 적 없으면
			if(!checked[pos]){
				checked[pos] = true;
				//더 나은 길 있는지 탐색
				for (Position position : adjList.get(pos)) {
					if (!checked[position.Pos] && distance[position.Pos] > distance[pos] + position.cost) {
						distance[position.Pos] = distance[pos] + position.cost;
						PQ.add(new Position(position.Pos, distance[position.Pos]));
					}

				}
			}
		}
		//System.out.println(Arrays.toString(distance));

		int tempItem = 0;
		for (int i = 1; i <= N; i++) {
			//탐색범위에 걸리는 곳
			if (distance[i] <= M) {
				tempItem += itemData[i];
			}
		}
		result = Math.max(tempItem, result);

	}

}