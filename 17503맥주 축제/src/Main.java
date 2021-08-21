import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="3 9 5\n" +
			"2 5\n" +
			"4 6\n" +
			"3 3\n" +
			"4 3\n" +
			"1 4";
	
	static int N, K, result;
	static long M;
	static int[][] data;
	static boolean[] checked;

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		StringTokenizer str = new StringTokenizer(input.readLine());

		N = Integer.parseInt(str.nextToken()); //축제 기간
		M = Integer.parseInt(str.nextToken()); // 선호도 합 (목표치)
		K = Integer.parseInt(str.nextToken()); // 맥주 종류

		//하루에 1병, 먹었던 맥주 다시X
		//마시는 도수레벨 보다 간레벨 높아야됨
		//선호도(초과) 채우면서 N개의 맥주 모두 마실 수 있는 최소 간레벨

		data = new int[K][2];
		checked = new boolean[K];
		result = Integer.MAX_VALUE;
		PriorityQueue<Integer> PQ = new PriorityQueue<>();

		for (int i = 0; i < K; i++) {
			str = new StringTokenizer(input.readLine());
			int v = Integer.parseInt(str.nextToken()); //선호도
			int c = Integer.parseInt(str.nextToken()); //도수 레벨
			data[i][0] = v;
			data[i][1] = c;
			//PQ.add(new Beer(v, c));
		}

		//도수레벨 오름차순,같은 경우 선호도가 더 높은 순
		Arrays.sort(data, ((o1, o2) -> {
			if (o1[1] == o2[1]) {
				return Integer.compare(o2[0], o1[0]);
			} else {
				return Integer.compare(o1[1], o2[1]);
			}
		}));

		long tempScore = 0;
		boolean noAnswer = true;

		for (int i = 0; i < K; i++) {
			PQ.add(data[i][0]); //선호도 저장
			tempScore += data[i][0]; //선호도 더해줌

			if (PQ.size() > N) { //만약 사이즈가 초과하면
				tempScore -= PQ.poll(); // 가장 작은 선호도 요소 꺼내서 빼줌
			}
			// 조건에 맞는 경우에 도달하면
			if (PQ.size() == N && tempScore >= M) {
				noAnswer = false; //정답이 있다고 변경
				System.out.println(data[i][1]); // 레벨 출력(data를 도수 오름차순으로 정렬했기에 가능)
				break;
			}
		}
		if (noAnswer) {
			System.out.println(-1);
		}
	}

}