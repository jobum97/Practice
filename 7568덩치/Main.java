import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "5\n" +
            "55 185\n" +
            "58 183\n" +
            "88 186\n" +
            "60 175\n" +
            "46 155";

    public static void main(String[] args) throws IOException {

        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        // 무게와 키 둘다 키면 덩치가 더 크다
        // 둘다 큰 경우 아니면 우열 못가림

        int N = Integer.parseInt(input.readLine());
        int data[][] = new int[N][3];

        StringTokenizer str;

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            int weight = Integer.parseInt(str.nextToken());
            int height = Integer.parseInt(str.nextToken());

            data[i][0] = weight;
            data[i][1] = height;
        }

        for (int i = 0; i < N; i++) {
            int curW = data[i][0];
            int curH = data[i][1];
            int bigCount = 1;
            for (int j = 0; j < N; j++) {
                if (curH < data[j][1] && curW < data[j][0]) {
                    bigCount++;
                }
            }
            data[i][2] = bigCount;
        }

        for (int i = 0; i < N; i++) {
            output.append(data[i][2] + " ");
        }
        System.out.println(output);
    }

}
