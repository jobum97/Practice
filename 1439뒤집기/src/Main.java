import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output;
    static String src = "01011010";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        output = new StringBuilder(src);

        String temp = input.readLine();

        int cnt[] = new int[2];


        char before = '2';
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) != before) {
                cnt[(temp.charAt(i) - '0')]++;
                before = temp.charAt(i);
            }
        }
        System.out.println(Math.min(cnt[0], cnt[1]));


    }
}
