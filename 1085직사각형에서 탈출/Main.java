import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "6 2 10 3";

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        StringTokenizer str = new StringTokenizer(input.readLine());
        int x = Integer.parseInt(str.nextToken());
        int y = Integer.parseInt(str.nextToken());
        int w = Integer.parseInt(str.nextToken());
        int h = Integer.parseInt(str.nextToken());


        int ans = Integer.MAX_VALUE;
        ans = Math.min(x, ans);
        ans = Math.min(y, ans);
        ans = Math.min(Math.abs(x - w), ans);
        ans = Math.min(Math.abs(y - h), ans);
        System.out.println(ans);
    }
}
