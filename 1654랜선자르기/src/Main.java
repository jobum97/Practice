import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="4 11\n" +
			"802\n" +
			"743\n" +
			"457\n" +
			"539";

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		StringTokenizer str = new StringTokenizer(input.readLine());

		int K = Integer.parseInt(str.nextToken()); //가지고 있는 랜선의 개수
		int N = Integer.parseInt(str.nextToken()); //필요한 랜선의 개수

		int[] lenSun = new int[K];
		long max = 0;
		for (int i = 0; i < K; i++) {
			lenSun[i] = Integer.parseInt(input.readLine());
			if (max < lenSun[i]) {
				max = lenSun[i];
			}
		}
		max++;

		long left = 0;
		long right = max;

		/*
		upper bound	(상한) => 찾고자 하는 특정 값 초과하는 첫위치
		lower bound(하한) => 찾고자 하는 특정 값 이상인 첫위치

		 1,1 인 경우 left =0 right =1 mid=0 => 0으로 나눗셈됨
		 0~max+1 범위에서 탐색해야...
		 */


		while (left < right) {
			long mid = (left + right) / 2;
			//System.out.println(mid);
			//자른것 갯수가 부족한경우
			if (cut(lenSun, mid) < N) {
				right = mid;
			} else{
				left = mid + 1;
			}
		}

		System.out.println(left - 1);


	}

	public static long cut(int[] lensun, long length) {
		long temp = 0;
		for (int i = 0; i < lensun.length; i++) {
			temp += lensun[i] / length;
		}
		return temp;
	}


}