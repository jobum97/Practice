import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "ABC ABCDAB ABCDABCDABDE\n" +
            "ABCDABD";

    static String original, keyStr;
    static int pi[], result = 0;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        original = input.readLine(); // 원문
        keyStr = input.readLine(); // 키워드
        pi = new int[keyStr.length()];
        getPi();
        Kmp();
        if (original.length() < keyStr.length()) {
            System.out.println(result);
        } else {
            System.out.println(result);
        }

        System.out.println(output);
    }
    public static void Kmp() {
        int j = 0;
        for (int i = 0; i < original.length(); i++) {
            // 틀리면 다시 탐색 시작할 위치 조정 ( 무의미한 부분 스킾 )
            while (j > 0 && original.charAt(i) != keyStr.charAt(j)) {
                j = pi[j - 1];
            }
            // 맞는 경우
            if (original.charAt(i) == keyStr.charAt(j)) {
                //부분 문자열 완성 => prefix맞는 부분부터 다시?
                if (j == keyStr.length() - 1) {
                    result++;
                    output.append(i - keyStr.length() + 2).append(" ");
                    j = pi[j];
                }
                //맞았지만 패턴이 끝나지 않았다면 j를 하나 증가
                // => i는 for문으로 차피 증가 ( i, j 같이 증가하는것)
                else{
                    j++;
                }
            }
        }
    }

    public static void getPi() {
        int j = 0;
        for (int i = 1; i < keyStr.length(); i++) {
            // 맞는 위치가 나올 때까지 j - 1칸의 공통 부분 위치로 이동
            while (j > 0 && keyStr.charAt(i) != keyStr.charAt(j)) {
                j = pi[j - 1];
            }
            // 맞는 경우
            if (keyStr.charAt(i) == keyStr.charAt(j)) {
                //i길이 문자열의 공통 길이는 j의 위치 + 1
                pi[i] = ++j;
            }
        }
    }
}
