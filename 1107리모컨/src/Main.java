import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	 static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 static StringBuilder output = new StringBuilder();
	 static String src = "500000\n" +
			 "10\n" +
			 "0 1 2 3 4 5 6 7 8 9";


	public static void main(String arg[]) throws IOException {

		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		int targetChannel = Integer.parseInt(input.readLine());

		int brokenBtn = Integer.parseInt(input.readLine());

		boolean[] invalidBtn = new boolean[10];

		if (brokenBtn > 0) {
			StringTokenizer str = new StringTokenizer(input.readLine());
			for (int i = 0; i < brokenBtn; i++) {
				invalidBtn[Integer.parseInt(str.nextToken())] = true;
			}
		}

		//System.out.println(targetChannel);
		int move = Math.abs(targetChannel - 100);
		for (int i = 0; i <= 1000000; i++) {
			int len = check(invalidBtn, i);   // 숫자버튼 누르는 횟수
			if (len > 0) {
				int press = Math.abs(targetChannel - i);  // +,- 버튼 누르는 횟수
				move = Math.min(move, len + press);   // 최소 이동 횟수 계산
			}
		}
		System.out.println(move);
	}

	public static int check(boolean invalidBtn[], int n) {
		if (n == 0) {
			if (invalidBtn[0]) {
				return 0;
			} else {
				return 1;
			}
		}
		int len = 0;
		while (n > 0) {
			if (invalidBtn[n % 10]) {   // 고장난 버튼이 있는 경우
				return 0;
			}
			n /= 10;
			len += 1;   // 숫자버튼 누르는 횟수 증가
		}
		return len;
	}
	    
}
