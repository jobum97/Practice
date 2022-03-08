import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output;
    static String src = "2\n" +
            "GCF\n" +
            "ACDEB";

    public static void main(String[] args) throws IOException{
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        output = new StringBuilder();

        int N = Integer.parseInt(input.readLine());

        Integer[] data = new Integer[26];
        Arrays.fill(data, 0);
        for (int i = 0; i < N; i++) {
            String string = input.readLine();

            int multiple = 1;
            for (int j = string.length() - 1; j >= 0; j--) {
                data[(string.charAt(j) - 'A')] += multiple;
                multiple *= 10;
            }
        }
        //System.out.println(Arrays.toString(data));
        Arrays.sort(data,Collections.reverseOrder());
        //System.out.println(Arrays.toString(data));

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += (9 - i) * data[i];
        }
        System.out.println(result);
    }


}
