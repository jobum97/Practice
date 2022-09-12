import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "10";

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        int N = Integer.parseInt(input.readLine());

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        while (deque.size() > 1) {
            deque.pollFirst();
            deque.add(deque.pollFirst());
        }
        System.out.println(deque.poll());
    }
}
