import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "1 1\n" +
            "7 3\n" +
            "5 5";


    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        StringTokenizer str = new StringTokenizer(input.readLine());
        int x1 = Integer.parseInt(str.nextToken());
        int y1 = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(input.readLine());
        int x2 = Integer.parseInt(str.nextToken());
        int y2 = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(input.readLine());
        int x3 = Integer.parseInt(str.nextToken());
        int y3 = Integer.parseInt(str.nextToken());


        System.out.println(CCW(x1, y1, x2, y2, x3, y3));
    }

    public static int CCW(int x1, int y1, int x2, int y2, int x3, int y3) {
        long ans = x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1;
        //System.out.println(ans);
        if (ans < 0) {
            return -1;
        } else if (ans > 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
