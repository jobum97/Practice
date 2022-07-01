import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigInteger;

public class Main {
    static BufferedReader input;
    static String src = "1000";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        long N = Long.parseLong(input.readLine());

        long first = 0;
        long second = 1;

        long div = 1000000007;

        long[][] fiboArr = {{1, 1}, {1, 0}};
        long[][] result = pow(fiboArr, N);
        System.out.println(result[1][0]);

    }
    public static long[][] pow(long[][] data, long pow) {

        if (pow == 1L) {
            return data;
        }
        long[][] temp = pow(data, pow / 2);
        temp = multiply(temp, temp);

        //홀수
        if (pow % 2 == 1L) {
            temp = multiply(temp, data);
        }
        return temp;
    }

    public static long[][] multiply(long[][] o1, long[][] o2) {
        int N = o1.length;
        long[][] result = new long[N][N];
        // 행렬 전체 변화 (i,j)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 연산 처리
                for (int k = 0; k < N; k++) {
//                        System.out.println(i + " " + k + " * " + k + " " + j);
//                        System.out.println(result[i][k] + " * " + data[k][j]);
                    result[i][j] += (o1[i][k] * o2[k][j]) % 1000000007;
                    result[i][j] %= 1000000007;
                }

            }
        }
        return result;
    }
}
