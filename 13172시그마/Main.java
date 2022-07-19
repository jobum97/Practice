import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "1\n" +
            "3 7";

    static int M;
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        M = Integer.parseInt(input.readLine());
        StringTokenizer str;


        // X 에 대한 b의 모듈러 곱셈에 대한 역원은 b^(X-2)

        long result = 0;
        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(input.readLine());
            long a = Long.parseLong(str.nextToken());
            long b = Long.parseLong(str.nextToken());

            if(a%b==0L){
                result += a / b;
            }else{
                long g = gcd(a, b);
                long down = a / g;
                long up = b / g;
                down = sol(MOD - 2, down);
                result += down * up;
            }
            result %= MOD;
        }
        System.out.println(result);
    }

    public static long gcd(long pa, long pb) {
        long a = pa;
        long b = pb;
        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }
        while (a > 0) {
            long c = b % a;
            b = a;
            a = c;
        }
        return b;
    }

    public static long sol(int n, long k) {
        long ret = 1L;
        if (n == 1) {
            return k;
        } else if (n % 2 == 1) {
            ret = k;
        }
        long v = sol(n / 2, k);
        v = (v * v) % MOD;
        return (ret * v) % MOD;
    }
}
