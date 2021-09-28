import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	 static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	    static StringBuilder output = new StringBuilder();
	    static String src = "4 7\n" +
				"20 15 10 17";
	    
	    public static void main(String arg[]) throws IOException {
	        //input= new BufferedReader(new InputStreamReader(System.in));
	        input = new BufferedReader(new StringReader(src));

	        StringTokenizer str = new StringTokenizer(input.readLine());

			int N = Integer.parseInt(str.nextToken()); // 나무 개수
			long M = Long.parseLong(str.nextToken()); // 가져갈 나무 길이

			long[] data = new long[N];
			long max = 0;

			str = new StringTokenizer(input.readLine());
			for (int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(str.nextToken());
				if (max < data[i]) {
					max = data[i];
				}
			}



			long left = 0;
			long right = max + 1;
			long mid = 0;
			long cut = 0;
			//적어도 M 미터를 가져갈수 있는 높이의 최대값을 구하는 것
			// 즉 상한
			while (left < right) {
				mid = (left + right) / 2;
				cut = cut(data, mid);

				System.out.println(left+" "+mid+" "+right);
				//남은 것이 부족한 경우
				if (cut < M) {
					right = mid;
				} //조건 만족하는 경우
				else {
					left = mid + 1;
				}
			}

			System.out.println(right - 1);

	    }

	public static long cut(long[] data, long cutLine) {
		long sum = 0;
		for (int i = 0; i < data.length; i++) {
			long temp = data[i] - cutLine;
			if (temp > 0) {
				sum += temp;
			}
		}
		return sum;
	}
}
