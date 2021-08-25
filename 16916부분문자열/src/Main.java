import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "baekjoon\n" +
            "baekjon";

    static int result, pi[];
    static String original, subStr;

    public static void main(String arg[]) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        original = input.readLine();
        subStr = input.readLine();

        pi = new int[subStr.length()];
        getPi();
        Kmp();

    }

    public static void Kmp() {
        int j = 0;
        for (int i = 0; i < original.length(); i++) {
            // 맞는 위치가 나올 때까지 j - 1칸의 공통 부분 위치로 이동
            while (j > 0 && original.charAt(i) != subStr.charAt(j)) {
                j = pi[j - 1];
            }
            // 맞는 경우
            if (original.charAt(i) == subStr.charAt(j)) {
                //부분 문자열 완성 => 탐색 종료
                if (j == subStr.length() - 1) {
                    result = 1;
                    break;
                }
                //맞았지만 패턴이 끝나지 않았다면 j를 하나 증가
                // => i는 for문으로 차피 증가 ( i, j 같이 증가하는것)
                else{
                    j++;
                }
            }
        }
        System.out.println(result);
    }

    public static void getPi() {
        int j = 0;
        for (int i = 1; i < subStr.length(); i++) {
            // 맞는 위치가 나올 때까지 j - 1칸의 공통 부분 위치로 이동
            while (j > 0 && subStr.charAt(i) != subStr.charAt(j)) {
                j = pi[j - 1];
            }
            // 맞는 경우
            if (subStr.charAt(i) == subStr.charAt(j)) {
                //i길이 문자열의 공통 길이는 j의 위치 + 1
                pi[i] = ++j;
            }
        }
    }
}