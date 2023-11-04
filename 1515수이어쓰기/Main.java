import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    static String src = "290119";
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static boolean[] checked = new boolean[10000000];

    public void solution() throws Exception{
//        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        String s = input.readLine();
        int pt = 0;

        int base = 0;
        while (base++ <= 30000) {
            String tmp = String.valueOf(base);
            // 문자열로 비교
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == s.charAt(pt))
                    pt++;
                if (pt == s.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }


}
