import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "7\r\n"
			+ "0110100\r\n"
			+ "0110101\r\n"
			+ "1110101\r\n"
			+ "0000111\r\n"
			+ "0100000\r\n"
			+ "0111110\r\n"
			+ "0111000";

	static PriorityQueue<Integer> houses = new PriorityQueue<>();
	static int N;
	static int[][] map;
	static boolean[][] checked;

	public static void main(String args[]) throws IOException {
		// input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		checked = new boolean[N][N];
		for(int y=0; y<N; y++) {
			int x = 0;
			String line = input.readLine();
			for(char c : line.toCharArray())
				map[y][x++] = c - '0';
		}
		
		solve();
		
		output.append(houses.size() + "\n");
		while(!houses.isEmpty())
			output.append(houses.poll() + "\n");
		System.out.print(output);
		
	}
	
	static int dfs(int y, int x) {
		if(y < 0 || y >= N || x < 0 || x >= N) //맵 밖으로 나가면 0 리턴 
			return 0;
		if(checked[y][x]) //갔던 곳이면 0 리턴
			return 0;
		
		//여기 도달하면 방문 가능한 상태 => 방문 체크
		checked[y][x] = true;
	
		if(map[y][x] == 0) // 0이면 블럭 구성하지 않기에 리턴 0
			return 0;
		
		// 1로 블럭 구성하는 지점에 도달했으면 상하좌우로 탐색이어나감 +(블럭 구성수 +1) 
		return 1 + dfs(y-1, x) + dfs(y+1, x) + dfs(y, x-1) + dfs(y, x+1);
	}
	
	static void solve() {
		for(int y=0; y<N; y++)
			for(int x=0; x<N; x++)
				if(!checked[y][x]) { //갔던 곳 아닌곳에서 
					int ret = dfs(y, x); //dfs 탐색 돌면서 블럭 체크함 
					if(ret != 0) //블럭 구성하면 1이상 일것 
						houses.add(ret);
				}
	}
	
}
