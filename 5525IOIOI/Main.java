import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "1\n" +
            "13\n" +
            "OOIOIOIOIIOII";

    static int N, M;
    static char str[];
    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        N = Integer.parseInt(input.readLine());
        M = Integer.parseInt(input.readLine());
        str = input.readLine().toCharArray();

        int[] seq = new int[M];
        int result = 0;
        int count = 0;

        for (int i = 1; i < M - 1; i++) {
            if (str[i - 1] == 'I' && str[i] == 'O' && str[i + 1] == 'I') {
                count++;

                if (count == N) {
                    count--;
                    result++;
                }
                i++;
            } else {
                count = 0;
            }
        }

        System.out.println(result);


    }
}
