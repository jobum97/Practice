import java.util.*;

public class Main {
    public static void main(String[] args) {

        String input = "()))((()";

        System.out.println(solution(input));
    }

    public static String solution(String p) {
        String answer = "";
        // 주어진 문자열 u, v로 분리
        // u : 균형잡힌 최소 단위 v : 나머지, 빈문자열일수도
        //1.빈 문자열인 경우 빈문자열 반환
        if (p.equals("")) {
            return "";
        }
        //2. u v로 분리
        int leftCnt = 0;
        int rightCnt = 0;
        String u = "";
        String v = "";
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                leftCnt++;
            } else if (p.charAt(i) == ')') {
                rightCnt++;
            }
            if (leftCnt == rightCnt) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1, p.length());
                break;
            }
        }

        //System.out.println(u + " | " + v);

        //3.
        if (isValid(u)) {
            answer += u + solution(v);
        }
        //4.
        else {
            answer += "(";
            answer += solution(v);
            answer += ")";

            u = u.substring(1, u.length() - 1);
            u = u.replace("(", "!");
            u = u.replace(")", "(");
            u = u.replace("!", ")");

            answer += u;
        }

        return answer;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }

    public static boolean isBalance(String s) {
        int leftCnt = 0;
        int rightCnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCnt++;
            } else if (s.charAt(i) == ')') {
                rightCnt++;
            }
        }
        if (leftCnt == rightCnt) {
            return true;
        } else {
            return false;
        }
    }
}
