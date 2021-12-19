import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "-6";

    public static void main(String[] args) throws IOException {
        input= new BufferedReader(new InputStreamReader(System.in));
        //input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());

        long[] fibo = new long[1000001];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i < fibo.length; i++) {
            fibo[i] = (fibo[i - 2] + fibo[i - 1])% 1000000000;
        }


        if (N > 0) {
            output.append(1 + "\n");
            output.append(fibo[N]);
        } else if (N == 0) {
            output.append(0 + "\n");
            output.append(0);
        } else {

            int absN = Math.abs(N);
            //짝수면
            if (absN % 2 == 0) {
                output.append(-1 + "\n");
            } else {
                output.append(1 + "\n");
            }
            output.append(fibo[absN]);
        }
        System.out.println(output);
    }
}
