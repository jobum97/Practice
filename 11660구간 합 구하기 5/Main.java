import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "2 4\n" +
            "1 2\n" +
            "3 4\n" +
            "1 1 1 1\n" +
            "1 2 1 2\n" +
            "2 1 2 1\n" +
            "2 2 2 2";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        int data[][] = new int[N + 1][N + 1];
        int sumData[][] = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 1; j <= N; j++) {
                data[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        sumData[1][1] = data[1][1];

        for (int i = 2; i <= N; i++) {
            sumData[1][i] = sumData[1][i - 1] + data[1][i];
            sumData[i][1] = sumData[i - 1][1] + data[i][1];
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                sumData[i][j] = sumData[i - 1][j] + sumData[i][j - 1] - sumData[i - 1][j - 1] + data[i][j];
            }
        }



        // (x1,y1) ~ (x2,y2) =
        // (x2,y2) - (x1,y2) - (x2,y1) + (x1,y1)
        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(input.readLine());
            int x1 = Integer.parseInt(str.nextToken());
            int y1 = Integer.parseInt(str.nextToken());
            int x2 = Integer.parseInt(str.nextToken());
            int y2 = Integer.parseInt(str.nextToken());

            output.append(sumData[x2][y2] - sumData[x1 - 1][y2] - sumData[x2][y1 - 1] + sumData[x1 - 1][y1 - 1] + "\n");
        }

        System.out.print(output);
    }
}
