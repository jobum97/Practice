import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader input;
    static StringBuilder output;
    static String src = "4\n" +
            "20\n" +
            "30\n" +
            "30\n" +
            "40";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        output = new StringBuilder(src);

        int n = Integer.parseInt(input.readLine());
        PriorityQueue<Long> data = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            data.add(Long.parseLong(input.readLine()));
        }

        long total = 0;
        while (data.size() > 1) {
            long sum = data.poll() + data.poll();
            total += sum;
            data.add(sum);
        }
        System.out.println(total);

    }
}

