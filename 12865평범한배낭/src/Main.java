import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4 7\n" +
            "6 13\n" +
            "4 8\n" +
            "3 6\n" +
            "5 12";

    static int N, K, data[][], maxValue;

    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        data = new int[N][2];
        maxValue = 0;
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            data[i][0] = Integer.parseInt(str.nextToken()); //무게
            data[i][1] = Integer.parseInt(str.nextToken()); //가치
        }
        dfs(0, 0, 0);
        System.out.println(maxValue);
    }

    public static void dfs(int curWeight, int curValue, int index) {
       //버틸 수 있는 무게 초과, 물품 목록 번호 초과시 끝
        if (index >= N || curWeight > K) {
            return;
        }
        maxValue = Math.max(curValue, maxValue);
        System.out.println(index+" "+curValue);
        dfs(curWeight + data[index][0], curValue + data[index][1], index + 1);
        dfs(curWeight, curValue, index + 1);
    }
}
