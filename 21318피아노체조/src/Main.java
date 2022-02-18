import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "9\n" +
            "1 2 3 3 4 1 10 8 1\n" +
            "5\n" +
            "1 3\n" +
            "2 5\n" +
            "4 7\n" +
            "9 9\n" +
            "5 9";

    static int N, Q, data[], accumulateSum[];
    static boolean miss[];


    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(input.readLine());
        data = new int[N + 1];
        miss = new boolean[N + 1];
        accumulateSum = new int[N + 1];

        StringTokenizer str = new StringTokenizer(input.readLine());

        for (int i = 1; i <= N; i++) {
            data[i] = Integer.parseInt(str.nextToken());
            if (data[i - 1] > data[i]) {
                miss[i] = true;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (miss[i]) {
                accumulateSum[i] = accumulateSum[i - 1] + 1;
            } else {
                accumulateSum[i] = accumulateSum[i - 1];
            }
        }

//        System.out.println(Arrays.toString(miss));
//        System.out.println(Arrays.toString(accumulateSum));

        Q = Integer.parseInt(input.readLine());

        for (int i = 1; i <= Q; i++) {
            str = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());
            output.append(accumulateSum[y] - accumulateSum[x] + "\n");
        }
        System.out.print(output);
    }
}
