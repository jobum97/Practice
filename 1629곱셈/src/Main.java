    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.io.StringReader;
    import java.util.StringTokenizer;

    class Main {
        static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        static StringBuilder output = new StringBuilder();
        static String src = "10 11 12";
        static long A, B, C;

        public static void main(String[] args) throws IOException {
            //input = new BufferedReader(new InputStreamReader(System.in));
            input = new BufferedReader(new StringReader(src));

            StringTokenizer str = new StringTokenizer(input.readLine());
            A = Long.parseLong(str.nextToken());
            B = Long.parseLong(str.nextToken());
            C = Long.parseLong(str.nextToken());

            System.out.println(div(A, B));
        }

        public static long div(long x, long n) {

            if (n == 1) {
                return x % C;
            }

            long temp = div(x, n / 2);
            //짝수면
            if (n % 2 == 0) {
                return temp * temp % C;
            } else {
                return (temp * temp % C) * x % C;
            }

        }
    }
