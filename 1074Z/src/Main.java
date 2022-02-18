import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "3 7 7";

    static int N, r, c, answer;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        input= new BufferedReader(new InputStreamReader(System.in));
        //input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        r = Integer.parseInt(str.nextToken());
        c = Integer.parseInt(str.nextToken());

        int line = (int) Math.pow(2, N);

        answer = 0;


        div4(line, 0, 0, r, c);
        System.out.println(answer);
    }

    public static void div4(int line, int row, int col, int targetRow, int targetCol) {

        int half = line / 2;

        if (half == 1) {
            if (row == targetRow && col == targetCol) {
                answer += 0;
            }else if (row == targetRow && col == targetCol + 1) {
                answer += 1;
            } else if (row == targetRow + 1 && col == targetCol) {
                answer += 2;
            } else if (row == targetRow && col == targetCol + 1) {
                answer += 3;
            }
        }

        //1사분면
        if (targetRow < row + half && targetCol < col + half && targetRow >= row && targetCol >= col) {
            div4(half, row, col, targetRow, targetCol);
        } // 3사분면
        else if (targetRow < row + line && targetCol < col + half && targetRow >= row + half && targetCol >= col) {
            answer += half * half * 2;
            div4(half, row + half, col, targetRow, targetCol);
        } //2사분면
        else if (targetRow < row + half && targetCol < col + line && targetRow >= row && targetCol >= col + half) {
            answer += half * half;
            div4(half, row, col + half, targetRow, targetCol);
        } //4사분면
        else if (targetRow < row + line && targetCol < col + line && targetRow >= row + half && targetCol >= col + half) {
            answer += half * half * 3;
            div4(half, row + half, col + half, targetRow, targetCol);
        }

    }
}
