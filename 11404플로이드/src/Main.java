import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "5\n" +
            "14\n" +
            "1 2 2\n" +
            "1 3 3\n" +
            "1 4 1\n" +
            "1 5 10\n" +
            "2 4 2\n" +
            "3 4 1\n" +
            "3 5 1\n" +
            "4 5 3\n" +
            "3 5 10\n" +
            "3 1 8\n" +
            "1 4 2\n" +
            "5 1 7\n" +
            "3 4 2\n" +
            "5 2 4";

    static int N, M, data[][];

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(input.readLine());
        M = Integer.parseInt(input.readLine());

        data = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                data[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer str = new StringTokenizer(input.readLine());
            int s = Integer.parseInt(str.nextToken());
            int e = Integer.parseInt(str.nextToken());
            int cost = Integer.parseInt(str.nextToken());


            data[s][e] = Math.min(data[s][e], cost);

        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) {
                        continue;
                    }
                    //
                    if (data[i][j] != Integer.MAX_VALUE && (data[k][j] != Integer.MAX_VALUE && data[i][k] != Integer.MAX_VALUE)) {
                        data[i][j] = Math.min(data[i][k] + data[k][j], data[i][j]);
                    } else {
                        if (data[i][j] == Integer.MAX_VALUE && data[k][j] != Integer.MAX_VALUE && data[i][k] != Integer.MAX_VALUE) {
                            data[i][j] = data[i][k] + data[k][j];
                        }
                    }

                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (data[i][j] == Integer.MAX_VALUE) {
                    output.append("0 ");
                } else {
                    output.append(data[i][j] + " ");
                }
            }
            output.append("\n");
        }
        System.out.print(output);

    }


}
