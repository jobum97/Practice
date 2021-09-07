import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String input = "try  hello   world";
        System.out.println(solution(input));
    }

    public static String solution(String s) {
        String answer = "";

        ArrayList<String> list = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                temp += s.charAt(i);
            } else {
                if (!temp.equals("")) {
                    list.add(temp);
                    list.add(" ");
                    temp = "";
                } else {
                    list.add(" ");
                }
            }
        }
        if (!temp.equals("")) {
            list.add(temp);
        }


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(" ")) {
                answer += " ";
            } else {
                answer += trans(list.get(i));

            }
        }

        return answer;
    }

    public static String trans(String input) {
        char str[] = input.toCharArray();

        for (int i = 0; i < str.length; i++) {
            //짝수인 경우 소문자 => 대문자
            if (i % 2 == 0) {
                //a97 A65
                if (str[i] >= 'a' && str[i] <= 'z') {
                    str[i] = (char) (str[i] - 32);
                }
            } //홀수인덱스 인경우 대문자 => 소문자
            else if (i % 2 == 1) {
                if (str[i] >= 'A' && str[i] <= 'Z') {
                    str[i] = (char) (str[i] + 32);
                }
            }
        }

        return String.valueOf(str);
    }
}
