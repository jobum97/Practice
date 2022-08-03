import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "1 1 5 5\n" +
            "6 10 10 6";

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        //풀이

        Point data[] = new Point[4];

        for (int i = 0; i < 2; i++) {
            StringTokenizer str = new StringTokenizer(input.readLine());

            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());
            data[i * 2] = new Point(x, y);
            x = Integer.parseInt(str.nextToken());
            y = Integer.parseInt(str.nextToken());
            data[i * 2 + 1] = new Point(x, y);
        }

        if (isValid(data)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static int CCW(Point A, Point B, Point C) {
        long ans = A.x * B.y + B.x * C.y + C.x * A.y - A.y * B.x - B.y * C.x - C.y * A.x;

        if (ans < 0) {
            return -1;
        } else if (ans > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static boolean isValid(Point[] data){
        // 선분 AB, CD 가 있다고 할때 교차 확인하는 방법은
        // CCW(A,B,C), CCW(A,B,D) 의 곱이 음수 혹은 0
        // CCW(C,D,A), CCW(C,D,B) 의 곱이 음수 혹은 0
        boolean state1 = (CCW(data[0], data[1], data[2]) * CCW(data[0], data[1], data[3])) < 0;
        boolean state2 = (CCW(data[2], data[3], data[0]) * CCW(data[2], data[3], data[1])) < 0;

        return state1 && state2;
    }

    public static class Point{
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
