import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class Main {

    static BufferedReader input;
    static StringBuilder output = new StringBuilder();

    static String src = "12ab112ab2ab\n" +
            "12ab";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        String str = input.readLine();
        String bomb = input.readLine();

        //문자열 폭발시 => 해당 문자열 사라짐 남은 문자열 합쳐짐 합쳐진곳에 폭발 문자열 있으면 연쇄작용

        Stack<Character> strStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            strStack.push(str.charAt(i));

            if (strStack.size() >= bomb.length()) {
                boolean isBomb = true;

                for (int j = 0; j < bomb.length(); j++) {
                    if (strStack.get(strStack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    for (int j = 0; j < bomb.length(); j++) {
                        strStack.pop();
                    }
                }
            }
        }

        if (strStack.size() == 0) {
            System.out.println("FRULA");
        }else{
            for (int i = 0; i < strStack.size(); i++) {
                output.append(strStack.get(i));
            }
            System.out.println(output);
        }


    }
}
