import java.io.*;
import java.lang.management.BufferPoolMXBean;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "2143";

    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        char[] temp = input.readLine().toCharArray();
        Arrays.sort(temp);

        for (int i = temp.length - 1; i >= 0; i--) {
            output.append(temp[i]);
        }
        System.out.println(output);

    }
}
