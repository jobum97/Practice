import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Stack;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "(()[[]])([])";
	
	static int result;
	static boolean flag;
	static char[] data;
	static Stack<Character> stack;
	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		data = input.readLine().toCharArray();

		//System.out.println(Arrays.toString(data));

		stack = new Stack<>();
		result = 0;
		int temp = 1;

		for (int i = 0; i < data.length; i++) {
			// 입력이 (,[ 인 경우
			if (data[i] == '(') {
				temp *= 2;
				stack.add('(');
			} else if (data[i] == '[') {
				temp *= 3;
				stack.add('[');
			}
			//불가능한 경우
			else if (data[i] == ')' && (stack.empty() || stack.peek() != '(')) {
				flag = true; //불가능한 경우 저장할 boolean 체크하고 break 으로 탈출
				break;
			} else if (data[i] == ']' && (stack.empty() || stack.peek() != '[')) {
				flag = true;
				break;
			}
			// ), ] 으로 마무리되는 경우
			else if (data[i] == ')') {
				if (data[i - 1] == '(') { //바로 앞이 ( 이였다면
					result += temp; // 2를 곱했던 값 result에 더하고
				}
				stack.pop(); // 스택에서 ( 꺼낸후 
				temp /= 2; // temp/2 해줌   
			} //위의 ] 버전
			else if (data[i] == ']') {
				if (data[i - 1] == '[') {
					result += temp;
				}
				stack.pop();
				temp /= 3;
			}
		}

		if (flag || !stack.empty()) { //불가능한 경우이거나 stack을 다 안비운 경우
			System.out.println(0); 
		} else {
			System.out.println(result);
		}
	}
}