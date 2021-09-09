import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String arg[]) throws IOException {

        String expression = "100-200*300-500+20";

        System.out.println(solution(expression));
    }

    //연산자 우선순위 바꾸어 절대값이 가장 큰 숫자 만들면 됨
    static char[][] prior = {{'+', '-', '*'}, {'+', '*', '-'},
            {'-', '+', '*'}, {'-', '*', '+'},
            {'*', '-', '+'}, {'*', '+', '-'}};

    static ArrayList<Long> nums = new ArrayList<Long>();
    static ArrayList<Character> ops = new ArrayList<Character>();
    static long answer;

    public static long solution(String expression) {
        answer = 0;

        String num = "";
        for(int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                num+= expression.charAt(i);
            }else {
                nums.add(Long.parseLong(num));
                num = "";
                ops.add(expression.charAt(i));
            }
        }
        nums.add(Long.parseLong(num));


        for (int i = 0; i < prior.length; i++) {
            calculation(prior[i]);
        }
        return answer;
    }

    public static Long calc(Long num1, Long num2, char op) {
        long num = 0;
        switch (op) {
            case '+': {
                return num1 + num2;
            }
            case '-': {
                return num1 - num2;
            }
            case '*': {
                return num1 * num2;
            }
        }
        return num;
    }

    public static void calculation(char[] p) {
        // 원본 ArrayList 를 복사해준다.
        ArrayList<Long> cNums = new ArrayList<>(nums);
        ArrayList<Character> cOps = new ArrayList<Character>(ops);
        //System.out.println(cNums.size() + " " + cOps.size());

        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < cOps.size(); j++) {
                if (p[i] == cOps.get(j)) {
                    // 리스트는 지울때 한칸씩밀리고 배열의 사이즈가 동적으로 변하므로
                    // (j 를 두번 remove 하고 j-- 처리를 해준것이다.)
                    Long res = calc(cNums.remove(j), cNums.remove(j), p[i]);
                    cNums.add(j, res);
                    cOps.remove(j);
                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(cNums.get(0)));
        return;
    }

}