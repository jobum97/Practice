import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "2 3 0 1\n" +
            "1 2 2 1\n" +
            "1 2 2 1\n";
    static boolean isPossible = false;
    static int H, W, X, Y;

    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        H = Integer.parseInt(str.nextToken());
        W = Integer.parseInt(str.nextToken());
        X = Integer.parseInt(str.nextToken());
        Y = Integer.parseInt(str.nextToken());

        int[][] A = new int[H][W];
        int[][] B = new int[H + X][W + Y];

        for (int i = 0; i < H + X; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < W + Y; j++) {
                B[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        // 배열 A + (i,j) 이동시킨 A = B

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = B[i][j];
            }
        }

        for (int i = 0; i < H-X; i++) {
            for (int j = 0; j < W-Y; j++) {
                A[X + i][Y + j] = B[X + i][Y + j] - A[i][j];
            }
        }


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                output.append(A[i][j]).append(" ");
            }
            output.append("\n");
        }

        System.out.print(output);
    }
}
