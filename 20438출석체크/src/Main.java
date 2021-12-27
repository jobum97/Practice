import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "10 1 3 1\n" +
            "7\n" +
            "3 5 7\n" +
            "3 12";

    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(str.nextToken()); //학생수
        int K = Integer.parseInt(str.nextToken()); //조는 학생수
        int Q = Integer.parseInt(str.nextToken()); //출석 코드 보낼 수
        int M = Integer.parseInt(str.nextToken()); //구간의 수

        boolean sleepStudents[] = new boolean[5005];
        boolean checked[] = new boolean[5005];
        int dp[] = new int[N + 3];
        for (int i = 3; i < N + 3; i++) {
            dp[i] = i;
        }
        
        str = new StringTokenizer(input.readLine());
        for (int i = 0; i < K; i++) {
            if (!str.hasMoreTokens()) {
                break;
            }
            sleepStudents[Integer.parseInt(str.nextToken())] = true;
        }

        str = new StringTokenizer(input.readLine());
        for (int i = 0; i < Q; i++) {
            if (!str.hasMoreTokens()) {
                break;
            }
            int mul = Integer.parseInt(str.nextToken());
            if (sleepStudents[mul]) {
                continue;
            }
            for (int j = mul; j < N + 3; j += mul) {
                if (sleepStudents[j]) {
                    continue;
                }
                checked[j] = true;
            }
        }

        for (int i = 3; i < N + 3; i++) {
            if (!checked[i]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        System.out.println(Arrays.toString(checked));
        System.out.println(Arrays.toString(dp));

        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());
            output.append(dp[end] - dp[start-1] + "\n");
        }
        System.out.println(output);
    }

}
