import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "1\n" +
            "10\n" +
            "13\n" +
            "100\n" +
            "1000\n" +
            "10000\n" +
            "100000\n" +
            "0";

    static int N, accumulateSums[];
    static boolean nonPrimeNums[];


    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        // N : 1~ 123456
        int size = 123456 * 2 + 1;
        int range = ((int) Math.sqrt(size)) + 1;

        //소수 구하기 - 에라토스테네스의 체
        // 2 ~ 루트(N) 숫자들의 배수들를 배제하면 남은 것이 소수
        // 왜 루트(N)이냐 루트 N을 넘어가면 배수에 포함됨
        nonPrimeNums = new boolean[size];
        nonPrimeNums[1] = true;
        for (int i = 2; i <= range; i++) {
            for (int j = i * 2; j < size; j += i) {
                nonPrimeNums[j] = true;
            }
        }

        //누적합 배열 구하기
        accumulateSums = new int[size];
        for (int i = 1; i < size; i++) {
            if (!nonPrimeNums[i]) {
                accumulateSums[i] = accumulateSums[i - 1] + 1;
            } else {
                accumulateSums[i] = accumulateSums[i - 1];
            }
        }

        while (true) {
            N = Integer.parseInt(input.readLine());
            if (N == 0) {
                break;
            }

            output.append(accumulateSums[2 * N] - accumulateSums[N] + "\n");
        }
        System.out.print(output);
    }
}
