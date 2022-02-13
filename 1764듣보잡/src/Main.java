import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.DoubleStream;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "3 4\n" +
            "ohhenrie\n" +
            "charlie\n" +
            "baesangwook\n" +
            "obama\n" +
            "baesangwook\n" +
            "ohhenrie\n" +
            "clinton";

    static int N, M, data[][], maxValue;

    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        HashSet<String> set = new HashSet<>();
        ArrayList<String> answers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            set.add(input.readLine());
        }
        for (int i = 0; i < M; i++) {
            String name = input.readLine();
            if (set.contains(name)) {
                answers.add(name);
            }
        }

        Collections.sort(answers);
        output.append(answers.size() + "\n");
        for (int i = 0; i < answers.size(); i++) {
            output.append(answers.get(i) + "\n");
        }
        System.out.print(output);

    }
}

