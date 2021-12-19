import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4 3\n" +
            "2 5 11 7\n" +
            "9 7 4";

    public static void main(String[] args) throws IOException {
        input= new BufferedReader(new InputStreamReader(System.in));
        //input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        HashSet<Integer> set = new HashSet<>();

        str = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(str.nextToken()));
        }
        str = new StringTokenizer(input.readLine());
        for (int i = 0; i < M; i++) {
            set.remove(Integer.parseInt(str.nextToken()));
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        output.append(list.size() + "\n");
        for (int i = 0; i < list.size(); i++) {
            output.append(list.get(i) + " ");
        }

        System.out.println(output);
    }
}
