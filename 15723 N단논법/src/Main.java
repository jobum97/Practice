import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="3\n" +
			"a is b\n" +
			"b is c\n" +
			"c is d\n" +
			"3\n" +
			"a is d\n" +
			"a is c\n" +
			"d is a";
	
	static int n,m;
	static int max = 27;
	static boolean flag;
	static boolean[][] adjArray;

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));
		
		n=Integer.parseInt(input.readLine());
		StringTokenizer str;

		adjArray = new boolean[max][max];

		//전제 구성 => 단방향 그래프?
		for (int i = 0; i < n; i++) {
			str = new StringTokenizer(input.readLine());
			int s = str.nextToken().charAt(0) - 'a';
			str.nextToken();
			int e = str.nextToken().charAt(0) - 'a';

			//System.out.println(s + " " + e);

			adjArray[s][e] = true;
		}
		for (int i = 0; i < max; i++) {
			adjArray[i][i] = true;
		}
		Floyd();

//		for (int i = 0; i < 27; i++) {
//			System.out.println(Arrays.toString(adjArray[i]));
//		}

		//명제 판독

		m = Integer.parseInt(input.readLine());

		for (int i = 0; i < m; i++) {
			str = new StringTokenizer(input.readLine());
			int s = str.nextToken().charAt(0) - 'a';
			str.nextToken();
			int e = str.nextToken().charAt(0) - 'a';

			if (adjArray[s][e]) {
				output.append("T\n");
			} else {
				output.append("F\n");
			}
		}

		System.out.println(output);
	}

	public static void Floyd() {
		// a 는 b, b는 c => a는 c
		//중간에 끼이는
		for (int k = 0; k < max; k++) {
			//시작
			for (int i = 0; i < max; i++) {
				//끝
				for (int j = 0; j < max; j++) {
					// a 는 b, b는 c => a는 c
					if(adjArray[i][k] && adjArray[k][j]){
						adjArray[i][j] = true;
					}
				}
			}
		}

	}
}