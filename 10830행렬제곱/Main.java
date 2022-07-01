import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static String src = "5 1\n" +
            "1 0 0 0 1\n" +
            "1 0 0 0 1\n" +
            "1 0 0 0 1\n" +
            "1 0 0 0 1\n" +
            "1 0 0 0 1";
    static StringBuilder output = new StringBuilder();
    static int origin[][], N;
    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        Long B = Long.parseLong(str.nextToken());

        origin = new int[N][N];

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(str.nextToken()) % 1000;
            }
        }

        int[][] result = pow(origin, B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                output.append(result[i][j]).append(" ");
            }
            output.append("\n");
        }
        System.out.println(output);

    }


    public static int[][] pow(int[][] data, long pow) {
        int[][] result;

        if (pow == 1L) {
            return data;
        }
        int[][] temp = pow(data, pow / 2);
        temp = multiply(temp, temp);

        //홀수
        if (pow % 2 == 1L) {
            temp = multiply(temp, origin);
        }
        return temp;
    }

    public static int[][] multiply(int[][] o1, int[][] o2) {
        int[][] result = new int[N][N];
        // 행렬 전체 변화 (i,j)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 연산 처리
                for (int k = 0; k < N; k++) {
//                        System.out.println(i + " " + k + " * " + k + " " + j);
//                        System.out.println(result[i][k] + " * " + data[k][j]);
                    result[i][j] += (o1[i][k] * o2[k][j]) % 1000;
                    result[i][j] %= 1000;
                }

            }
        }
        return result;
    }
}
