import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static String src = "100 6";

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        if (M > N / 2) {
            M = N - M;
        }

        BigInteger parent = BigInteger.valueOf(1);
        BigInteger child = BigInteger.valueOf(1);
        for (int i = 0; i < M; i++) {
            child = child.multiply(BigInteger.valueOf(N - i));
            parent = parent.multiply(BigInteger.valueOf(i + 1));
            //System.out.println(child + " | " + parent);
        }
        System.out.println(child.divide(parent));
    }


}
