import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "121\n" +
            "1231\n" +
            "12421\n" +
            "0";

    static int pi[];
    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        //풀이
        String str;
        while (!(str = input.readLine()).equals("0")) {
            String reverse = new StringBuilder(str).reverse().toString();
            if (str.equals(reverse)) {
                output.append("yes").append("\n");
            }else{
                output.append("no").append("\n");
            }
        }
        System.out.print(output);
    }
}
