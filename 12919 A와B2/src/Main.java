import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="A\n" +
			"BABA";

	static int diff;
	static String S;
	static boolean flag;

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		S = input.readLine();
		String T = input.readLine();
		diff = T.length() - S.length();
		flag = false;

		sol(T, 0);
		if (flag) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}

	}

	public static void sol(String T, int index) {
		//System.out.println("sol : " +T);
		if (index == diff) {
			if (T.equals(S)) {
				flag = true;
			}
			return;
		}

		//맨 앞이 B인 경우 B삭제
		if (T.charAt(0) == 'B') {
			sol_reverse(T.substring(1, T.length()), index + 1);
		}

		//맨 뒤가 A인 경우
		if (T.charAt(T.length() - 1) == 'A') {
			sol(T.substring(0, T.length() - 1), index + 1);
		}
	}

	public static void sol_reverse(String T, int index) {
		//System.out.println("sol_reverse : " +T);
		if (index == diff) {
			StringBuffer sb = new StringBuffer(T);
			if (sb.reverse().toString().equals(S)) {
				flag = true;
			}
			return;
		}

		//맨 뒤가 B인 경우 B삭제
		if (T.charAt(T.length() - 1) == 'B') {
			sol(T.substring(0, T.length()-1), index + 1);
		}

		//맨 앞이 A인 경우
		if (T.charAt(0) == 'A') {
			sol_reverse(T.substring(1, T.length()), index + 1);
		}
	}

}
