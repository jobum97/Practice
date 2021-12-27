import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "6 2\n" +
            "1\n" +
            "3\n" +
            "5\n" +
            "4\n" +
            "0\n" +
            "2";

    static int line[];
    static boolean isChecked[];

    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(str.nextToken()); // 게임에 참가하는 사람
        int K = Integer.parseInt(str.nextToken()); // 보성이의 번호
        isChecked = new boolean[N];

        line = new int[N];

        for (int i = 0; i < N; i++) {
            line[i] = Integer.parseInt(input.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        isChecked[0] = true;
        int cur;
        int answer = -1;
        int move = 0;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            move++;
            if (cur == K) {
                answer += move;
                break;
            }
            isChecked[cur] = true;
        //    System.out.println(cur);

            if (!isChecked[line[cur]]) {
                stack.push(line[cur]);
            }
        }



        System.out.println(answer);

    }
}
