import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "9\n" +
            "0\n" +
            "12345678\n" +
            "1\n" +
            "2\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "32";

    static int N;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        N = Integer.parseInt(input.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int order = Integer.parseInt(input.readLine());

            if (order == 0) {
                if (pq.isEmpty()) {
                    output.append("0").append("\n");
                }else{
                    output.append(pq.poll()).append("\n");
                }
            }else{
                pq.add(order);
            }
        }
        System.out.print(output);

    }
}
