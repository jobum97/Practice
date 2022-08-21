import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "6\n" +
            "aabaaa";

    static int L, pi[];
    static String snapshot;
    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        L = Integer.parseInt(input.readLine());
        snapshot = input.readLine();

        // 보인 문자열을 반복으로 만들 수 있는 문자열 중 가장 짧은 문자열

        // 가능할 수 있는 풀이
        pi = new int[L];
        getPi();
        System.out.println(L - pi[L - 1]);
    }

    public static void getPi(){
        int j = 0;
        for (int i = 1; i < L; i++) {
            while (j > 0 && snapshot.charAt(i) != snapshot.charAt(j)) {
                j = pi[j - 1];
            }
            if (snapshot.charAt(i) == snapshot.charAt(j)) {
                pi[i] = ++j;
            }
        }
    }
}
