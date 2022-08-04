import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "50";
    static int counts[] = new int[10];
    static int CT = 1; // count 자릿수


    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        int N = Integer.parseInt(input.readLine());
        int A = 1;
        while (A <= N) {

            // N은 일의 자리 9, A는 일의 자리 0이 되게 조정하면서 일의 자리수 count
            while (N % 10 != 9 && A <= N) {
                count(N);
                N--;
            }
            while (A % 10 != 0 && A <= N) {
                count(A);
                A++;
            }
            if (A > N) {
                break;
            }
            A /= 10;
            N /= 10;

            // A(aa0) ~ N(nn9) 자릿수 계산
            for (int i = 0; i < 10; i++) {
                counts[i] += (N - A + 1) * CT;
            }
            CT *= 10;
        }

        for (int i = 0; i < 10; i++) {
            output.append(counts[i]).append(" ");
        }
        System.out.println(output);
    }

    public static void count(int cur) {
        while (0 < cur) {
            counts[cur % 10] += CT;
            cur /= 10;
        }
    }

}
