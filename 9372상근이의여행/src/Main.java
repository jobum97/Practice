import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static int nations, airplanes;

	public static void main(String arg[]) throws IOException {
		input= new BufferedReader(new InputStreamReader(System.in));
		//input= new BufferedReader(new StringReader(src));

		int t = Integer.parseInt(input.readLine());

		StringTokenizer str;

		for (int testcase = 1; testcase <= t; testcase++) {
			str = new StringTokenizer(input.readLine());
			nations = Integer.parseInt(str.nextToken());
			airplanes = Integer.parseInt(str.nextToken());
			for (int M = 0; M < airplanes; M++) {
				input.readLine();
				/*int s = Integer.parseInt(str.nextToken());
				int e = Integer.parseInt(str.nextToken());
				adjArray[s][e] = true;
				adjArray[e][s] = true;
				checkedFlight[s][e] = true;
				checkedFlight[e][s] = true;*/
			}
/*
			for (int i = 1; i <= nations; i++) {
				System.out.println(Arrays.toString(adjArray[i]));
			}*/
			//문제가 결국에는 최소의 간선을 선택하여 모든 정점을 탐색하는 것,
			//결국엔 연결되어있는 그래프 => 간선 n-1개 있으면 n개의 나라 탐색가능

			output.append(nations - 1 + "\n");
		}
		System.out.println(output);
	}

}
