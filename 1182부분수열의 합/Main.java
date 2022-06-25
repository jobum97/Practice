import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "5 0\n" +
            "-7 -3 -2 5 8";

    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(input.readLine());
        int data[] = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(str.nextToken());
        }

        int result = 0;

        for (int i = 1; i < (1 << N); i++) {

//            System.out.println(Integer.toBinaryString(i));
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    sum += data[j];
//                    System.out.print(j + ":" + data[j] + " ");
                }
            }
//            System.out.println();
//            System.out.println("sum: " + sum);

            if (sum == M) {
                result++;
            }

        }

        System.out.println(result);
    }
}
