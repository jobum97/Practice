
public class Main {
    public static void main(String[] args) {

        String input = "abcdefghijklmn.p";

        System.out.println(solution(input));

    }

    //아이디 알파벳 소문자 , 숫자, - , _ , . 으로 구성
    // . 처음과 끝, 연속 사용 안됨


    public static String solution(String new_id) {
        String answer = "";

        System.out.println(new_id);

        char curChar;
        //대문자 -> 소문자
        // 소문자, 숫자 빼기, - , _ , . 이외의 문자 제거
        for (int i = 0; i < new_id.length(); i++) {
            curChar = new_id.charAt(i);
            if (curChar >= 'A' && curChar <= 'Z') {
                answer += (char) (curChar + 32);
            } else if ((curChar >= 'a' && curChar <= 'z') || (curChar >= '0' && curChar <= '9') || curChar == '-' || curChar == '_' || curChar == '.') {
                answer += curChar;
            }
        }

        System.out.println(answer);

        // 연속된 . => 1개의 .
        answer = answer.replaceAll("\\.+", ".");

        System.out.println(answer);

        // 처음과 끝의 . 제거
        if (answer.length() > 0 && answer.charAt(0) == '.') {
            answer = answer.substring(1, answer.length());

        }
        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') {

            answer = answer.substring(0, answer.length() - 1);
        }
        System.out.println(answer);

        // 빈문자열이면 a 대입
        if (answer.length() == 0) {
            answer = "a";
        }

        //16자 이상이면 15문자 이후의 문자들 제거, 제거후 마지막에 . 있으면 제거

        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            if (answer.charAt(14) == '.') {
                answer = answer.substring(0, 14);
            }
        }

        // 2자 이하면 마지막 문자를 3자될때까지 붙임
        int length = answer.length();
        if (answer.length() <= 2) {
            for (int i = 0; i < 3 - length; i++) {
                answer += answer.charAt(length - 1);
            }
        }

        return answer;
    }
}
