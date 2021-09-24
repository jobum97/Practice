import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "7 3";

    static int N, K;


    public static void main(String arg[]) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        ArrayList<Integer> table = new ArrayList<>();
        boolean[] checked = new boolean[N];
        ArrayList<Integer> answer = new ArrayList<>();

        int flag = 0;
        int temp = 0;
        int index = 0;
        for (int i = 0; i < N; i++) {
            table.add(i + 1);
        }

        while (flag != N) {
            index = (index + K - 1) % table.size();
            //System.out.println(index + " " + table.get(index));
            answer.add(table.get(index));
            table.remove(index);
            flag++;

        }

        output.append("<");
        for (int i = 0; i < answer.size() - 1; i++) {
            output.append(answer.get(i) + ", ");
        }
        output.append(answer.get(answer.size() - 1) + ">");

        System.out.println(output);
    }



}
