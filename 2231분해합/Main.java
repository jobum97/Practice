import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "216";

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        String str = input.readLine();
        int N = Integer.parseInt(str);
        int answer = 0;
        int start = N - 9 * str.length();
        for (int i = start; i < N; i++) {
            if (sum(i) == N) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    public static int sum(int n) {
        int sum = n;
        while (n % 10 > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
