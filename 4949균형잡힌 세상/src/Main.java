import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output;
    static String src = "So when I die (the [first] I will see in (heaven) is a score list).\n" +
            "[ first in ] ( first out ).\n" +
            "Half Moon tonight (At least it is better than no Moon at all].\n" +
            "A rope may form )( a trail in a maze.\n" +
            "Help( I[m being held prisoner in a fortune cookie factory)].\n" +
            "([ (([( [ ] ) ( ) (( ))] )) ]).\n" +
            " .\n" +
            ".";

    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        output = new StringBuilder();
        String line;
        Stack<Integer> stack;
        boolean isValid;

        while (!(line = input.readLine()).equals(".")) {
            stack = new Stack<>();

            isValid = true;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '(') {
                    stack.push(0);
                } else if (line.charAt(i) == '[') {
                    stack.push(1);
                } else if (line.charAt(i) == ')') {
                    // 우괄호 소모, 근데 괄호가 없어? 아님 맞는 괄호가 아녀? 그럼 컷
                    if (stack.isEmpty() || stack.pop() != 0) {
                        isValid = false;
                        break;
                    }
                } else if (line.charAt(i) == ']') {
                    // 괄호 소모, 근데 괄호가 없어? 아님 맞는 괄호가 아녀?그럼 컷
                    if (stack.isEmpty() || stack.pop() != 1) {
                        isValid = false;
                        break;
                    }
                }
            }

            //괄호가 남아 있어도 컷
            if (!stack.isEmpty()) {
                isValid = false;
            }

            if (isValid) {
                output.append("yes\n");
            } else {
                output.append("no\n");
            }
        }
        System.out.print(output);
    }
}
