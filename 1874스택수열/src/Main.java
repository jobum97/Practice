import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="5\n" +
			"1\n" +
			"2\n" +
			"5\n" +
			"3\n" +
			"4";

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		int N = Integer.parseInt(input.readLine());

		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			answer[i] = Integer.parseInt(input.readLine());
		}
		//스택 push 순서 == 오름차순

		boolean flag = false;
		int index = 0;
		int num = 1;
		while (index < N) {
			int target = answer[index];
			//System.out.println(target+" "+num);
			//목표가 현재 스택에 넣는 숫자보다 큰경우
			// 스택에 푸시함
			if (target >= num) {
				stack.push(num);
				output.append("+\n");
				num++;
			} else {
				//더 작은 경우
				//스택의 맨 위 검사해보고 목표면 pop
				// 아니면 안되는 거임
				if (stack.peek() == target) {
					output.append("-\n");
					stack.pop();
					index++;
				} else {
					flag = true;
					break;
				}
			}
		}

		if (flag) {
			System.out.println("NO");
		} else {
			System.out.println(output);
		}

	}
	
}