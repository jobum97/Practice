import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "6 5\r\n"
			+ "1 2\r\n"
			+ "2 5\r\n"
			+ "5 1\r\n"
			+ "3 4\r\n"
			+ "4 6";

	static boolean isChecked[];
	static ArrayList<ArrayList<Integer>> adjList;

	public static void main(String[] args) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		StringTokenizer str = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(str.nextToken()); // 정점 개수
		int M = Integer.parseInt(str.nextToken()); // 간선 개수

		adjList = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			adjList.add(new ArrayList<>());
		}
		isChecked = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			str = new StringTokenizer(input.readLine());
			int s = Integer.parseInt(str.nextToken());
			int e = Integer.parseInt(str.nextToken());

			adjList.get(s).add(e);
			adjList.get(e).add(s);

		}
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (!isChecked[i]) {
				search(i);
				answer++;
			}
		}

		System.out.println(answer);
	}

	public static void search(int s){
		ArrayList<Integer> temp = adjList.get(s);
		int cur;
		for (int i = 0; i < temp.size(); i++) {
			cur = temp.get(i);
			if (!isChecked[cur]) {
				isChecked[cur] = true;
				search(cur);
			}
		}
	}
	
}
