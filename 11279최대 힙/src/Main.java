import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "13\n" +
            "0\n" +
            "1\n" +
            "2\n" +
            "0\n" +
            "0\n" +
            "3\n" +
            "2\n" +
            "1\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0";

    static int N, accumulateSums[];
    static boolean nonPrimeNums[];


    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        int testcase = Integer.parseInt(input.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < testcase; i++) {
            N = Integer.parseInt(input.readLine());

            if (N == 0) {
                if (pq.isEmpty()) {
                    output.append("0\n");
                } else {
                    output.append(pq.poll() + "\n");
                }
            } else {
                pq.add(N);
            }
        }
        System.out.print(output);
    }
}
