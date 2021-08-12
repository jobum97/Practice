package 괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="6\r\n"
			+ "(())())\r\n"
			+ "(((()())()\r\n"
			+ "(()())((()))\r\n"
			+ "((()()(()))(((())))()\r\n"
			+ "()()()()(()()())()\r\n"
			+ "(()((())()(";
	
	public static void main(String args[]) throws IOException{
		// input=new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		int lines = Integer.parseInt(input.readLine());
		String[] data;
		Stack<String> stack;
		boolean check;
		String tmp;
		
		for (int i = 0; i < lines; i++) {
			check=true;
			stack=new Stack<String>();// ( ���� stack
			data=input.readLine().split("");

			for(int j=0;j<data.length;j++) {
				
				if(data[j].equals("(")){
					
					stack.push("(");
				}else {
					if(stack.empty()) {
						check=false;
						break;
					}
					stack.pop();
				}
			}
			if(!stack.empty()) {
				check=false;
			}
			
			if(check) {
				output.append("YES\n");
			}else {
				output.append("NO\n");
			}
		}
		System.out.print(output);
		
	}
	
}
