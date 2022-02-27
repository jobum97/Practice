import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4 2\n" +
            "9 7 9 1";

    static int N, M, answer[][];
    static ArrayList<Integer> inputNum;

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(input.readLine());

        inputNum = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(str.nextToken());
            if (!set.contains(temp)) {
                inputNum.add(temp);
                set.add(temp);
            }
        }

        ArrayList<Integer> answers = new ArrayList<>();
        //순열 만들 재료 숫자 오름차순
        Collections.sort(inputNum);
        //System.out.println(inputNum.toString());

        BT(0,answers);
        System.out.print(output);
    }

    public static void BT(int index, ArrayList<Integer> answers) {
        if (index == M) {
            for (int i = 0; i < answers.size(); i++) {
                output.append(answers.get(i) + " ");
            }
            output.append("\n");
            return;
        }
        for (int i = 0; i < inputNum.size(); i++) {
            answers.add(inputNum.get(i));
            BT(index + 1, answers);
            answers.remove(answers.size() - 1);
        }

    }
}
