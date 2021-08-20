import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="5\n" +
			"1 9\n" +
			"8 9\n" +
			"4 6\n" +
			"3 4\n" +
			"2 5";

	static int N,result;
	static boolean[][] calendar;

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		N = Integer.parseInt(input.readLine());
		StringTokenizer str;

		int maxday = 0;
		PriorityQueue<Schedule> PQ = new PriorityQueue();
		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			PQ.add(new Schedule(start, end));
			maxday = Math.max(maxday, end); //마지막날 구한다
		}

		calendar = new boolean[N][maxday + 2];

		result = 0;

		//일정 다 꺼내면서
		while (!PQ.isEmpty()) {
			Schedule schedule = PQ.poll();

			for (int i = 0; i < N; i++) {
				//이미 배치했다면
				if (calendar[i][schedule.start]) {
					continue;
				}
				//일정 배치
				for (int j = schedule.start; j <= schedule.end; j++) {
					calendar[i][j] = true;
				}
				break;
			}

		}

		/*for (int i = 0; i < N; i++) {
			for (int j = 0; j < maxday+2; j++) {
				System.out.print(calendar[i][j]+" ");
			}
			System.out.println();
		}*/

		int wideStart = 365;
		int wideEnd = 0;
		int height= 0;

		//이 과정을 통해 블럭의 좌우 끝과 높이 구함
		for(int j =1; j<calendar[0].length;j++){
			boolean stop = true;
			for (int i = 0; i < N; i++) {
				if (calendar[i][j]) {
					wideEnd = Math.max(wideEnd, j); //마지막 수업 끝
					wideStart = Math.min(wideStart, j); //첫 수업 시작
					height = Math.max(height, i + 1); //겹치는 수업 나타냄
					stop = false;
				}
			}
			//위에서 for문으로 세로로 탐색했는데 stop이 false가 안됬다는 것은
			//이 시간대에 일정이 없었다는 것이고 즉 블럭이 형성된다는 것을 의미
			//블럭 만들어지면 블럭 계산하고 초기화
			if (stop) {
				//System.out.println(wideEnd+" "+wideStart+" "+height);
				result += ((wideEnd - wideStart + 1) * height);
				wideStart = 365;
				wideEnd = 0;
				height = 0;
			}
		}

		System.out.println(result);
	}

	static class Schedule implements Comparable<Schedule> {
		public int start;
		public int end;

		public Schedule(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Schedule o) {
			if (this.start == o.start) {
				return o.end - this.end;
			} else {
				return this.start - o.start;
			}
		}
	}
}