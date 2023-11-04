import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    static String src = "20 1\n" +
            "HHPHPPHHPPHPPPHPHPHP";
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static boolean[] checked;

    public void solution() throws Exception{
//        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());
        String[] line = input.readLine().split("");
        checked = new boolean[10000000];

         // 햄버거를 먹을 수 있는 사람의 최대수
        int result = 0;
        //그리디하게 탐색해보자
        for (int i = 0; i < N; i++) {
            if (line[i].equals("P")) {
                int beforePos = i - K >= 0 ? i - K : 0;
                int afterPos = i + K < N ? i + K : N - 1;
                for (int j = beforePos; j <= afterPos; j++) {
                    if (line[j].equals("H") && !checked[j]) {
                        checked[j] = true;
                        result += 1;
                        break;
                    }
                }
            }

        }
        System.out.println(result);

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }


}
