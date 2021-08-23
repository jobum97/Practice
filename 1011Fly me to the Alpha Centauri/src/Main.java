import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "3\r\n"
    		+ "0 3\r\n"
    		+ "1 5\r\n"
    		+ "45 50";

    static int result, pi[];
    static String original, subStr;

    public static void main(String arg[]) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        int testcase = Integer.parseInt(input.readLine());
        StringTokenizer str;

        // 바로 전에 k 이동하면 k-1 ~ k+1 의 이동거리 가짐
        // 처음엔 -1 ~ 1 (음수는 의미 없어서 1)
        // 도착 직전엔 1 로만 이동하려고한다

        // 아이디어 1
        // 1 .... n (최고시속)... 1
        // 이라고하면  2n-1 번의 이동으로 n^2 거리를 이동하는 것이 최적

        // 아이디어 2
        // 1(1), 11(2), 111(3), 121(4) , 1121(5),1221(6),12211(7)

        //아이디어 3
        // 이동횟수당 최고거리 구하기
        // 1(1), 2(2), 4(3), 6(4), 9(5),123321 12(6) ,1234321 16(7), 12344321 20(8)


        for (int i = 0; i < testcase; i++) {
            str = new StringTokenizer(input.readLine());

            int curX = Integer.parseInt(str.nextToken());
            int curY = Integer.parseInt(str.nextToken());

            int dist = curY - curX;
            int n = (int) Math.sqrt(dist);

            if (dist == n * n) {
                output.append(2 * n - 1 + "\n");
            } else if (n * n < dist && dist <= n * n + n) {
                output.append(2 * n + "\n");
            } else {
                output.append(2 * n + 1 + "\n");
            }

        }
        System.out.println(output);
    }
}