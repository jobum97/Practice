import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "7\n" +
            "1 2 1 3 1 2 1\n" +
            "4\n" +
            "1 3\n" +
            "2 5\n" +
            "3 3\n" +
            "5 7";

    static int N, S, E, M, data[];
    static boolean palindromeTable[][];

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        //풀이
        N = Integer.parseInt(input.readLine());
        data = new int[N + 1];
        StringTokenizer str = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            data[i] = Integer.parseInt(str.nextToken());
        }
        M = Integer.parseInt(input.readLine());

        palindromeTable = new boolean[N + 1][N + 1];

        // 길이가 1혹은 2일 경우
        for (int i = 1; i <= N; i++) {
            palindromeTable[i][i] = true;
            if (data[i] == data[i - 1]) {
                palindromeTable[i - 1][i] = true;
            }
        }

        // i는 거리 s에서 e까지 길이
        for (int i = 2; i <= N - 1; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (data[j] == data[j + i] && palindromeTable[j + 1][j + i - 1]) {
                    palindromeTable[j][j + i] = true;
                }
            }
        }
        
        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(input.readLine());
            int S = Integer.parseInt(str.nextToken());
            int E = Integer.parseInt(str.nextToken());
            if (palindromeTable[S][E]) {
                output.append(1).append("\n");
            } else {
                output.append(0).append("\n");
            }
        }
        System.out.print(output);
    }

}
