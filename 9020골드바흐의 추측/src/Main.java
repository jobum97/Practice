import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "3\n" +
            "8\n" +
            "10\n" +
            "16";

    static int N, accumulateSums[];
    static boolean nonPrimeNums[];

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        int testcase = Integer.parseInt(input.readLine());

        // N : 4 ~ 10000
        int size = 20001;
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

        //소수 리스트를 활용했으면 좀더 단축할 수 있을 지도?

        for (int i = 0; i < testcase; i++) {

            N = Integer.parseInt(input.readLine());

            loop:
            for (int s = N / 2; s > 1; s--) {
                if (!nonPrimeNums[s]) {
                    for (int e = N / 2; s + e <= N; e++) {
                        if (!nonPrimeNums[e] && s + e == N) {
                            output.append(s + " " + e + "\n");
                            break loop;
                        }
                    }
                }
            }
        }
        System.out.print(output);
    }
}
