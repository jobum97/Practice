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
	
	static int index,result;
	static boolean flag;
	static char[] data;
	static Stack<Character> stack;
	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		data = input.readLine().toCharArray();

		//System.out.println(Arrays.toString(data));

		stack = new Stack<>();
		index = 0;
		result = 0;

		while (index < data.length) {
			if (flag) {
				result = 0;
				break;
			}
			result += bracket();
		}
		System.out.println(result);
	}

	//한꺼풀씩
	public static int bracket() {
		int temp = 0;
		//System.out.println("재귀"+index +" "+data[index]);
		if (data[index] == '(' || data[index] == '[') {
			stack.push(data[index]);
			index++;
		}

		//스택이 빌 때까지 반복
		while (!stack.isEmpty()) {
			//이어지는 () or []
			if (data[index] == '(' || data[index] == '[') {
				temp += bracket(); //안의 괄호 값 재귀해서 구함

			}// () 이 완성될 때 2
			else if (stack.peek() == '(' && data[index] == ')') {
				stack.pop();
				index++;
				if (temp == 0) {
					temp = 1;
				}
				return 2 * temp;

			} // [] 이 완성될 때 3
			else if (stack.peek() == '[' && data[index] == ']') {
				stack.pop();
				index++;
				if (temp == 0) {
					temp = 1;
				}
				return 3 * temp;
			} //올바르지 않은 입력인 경우
			else{
				flag = true;
				return 0;
			}
		}

		return temp;
	}
}