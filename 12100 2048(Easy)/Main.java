import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "3\n" +
            "2 2 2\n" +
            "4 4 4\n" +
            "8 8 8";

    static int N, map[][];
    static int moveSet[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        N = Integer.parseInt(input.readLine());

        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer str = new StringTokenizer(input.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }


    }

    public static void up(){
        // 이동하려는 쪽을 먼저 합쳐야함
        for (int row = 2; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                // 값이 있다면 이동해야 함
                if (map[row][col] > 0) {

                }
            }
        }
    }
    public static void move
}
