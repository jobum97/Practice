import java.util.*;
public class Main {
    public static void main(String[] args) {

        String test = "cow45345";
        System.out.println(solution(new String[]{"bird99", "bird98", "bird101", "gotoxy"}, "bird98"));
    }
    public static String solution(String[] registered_list, String new_id) {
            String answer = new_id;

            // 모든 아이디는 S+N
            // S = 알파벳 소문자 3~6자리
            //N 은 숫자 0~6자 길이 1이상이면 0으로 시작 불
            // new id 가 이미 등록되어있지 않으면 추천 끝
            // 등록되어 있으면 newid s+N으로 분리  N+1로 ㄲ

            if (isValid(registered_list, answer)) {
                return new_id;
            }

            return findNewId(registered_list, new_id);
        }

        public static String findNewId(String[] list, String newId) {
            int idx = newId.length();
            for (int i = 0; i < newId.length(); i++) {
                int cur = (int)(newId.charAt(i)-'0');
                if (cur>=0 && cur<=9) {
                    idx = i;
                    break;
                }
            }
            //System.out.println(idx);
            String N = newId.substring(0, idx);
            String S = newId.substring(idx);
            int s = 0;
            if (!S.equals("")) {
                s = Integer.parseInt(S);
            }

            String temp = N + String.valueOf(++s);
            while (!isValid(list, temp)) {
                temp = N + String.valueOf(++s);
            }

            return temp;
        }


        public static boolean isValid(String[] list, String new_id) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].equals(new_id)) {
                    return false;
                }
            }
            return true;
        }
}
