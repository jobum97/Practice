import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "8\n" +
            "1 1 0 0 0 0 1 1\n" +
            "1 1 0 0 0 0 1 1\n" +
            "0 0 0 0 1 1 0 0\n" +
            "0 0 0 0 1 1 0 0\n" +
            "1 0 0 0 1 1 1 1\n" +
            "0 1 0 0 1 1 1 1\n" +
            "0 0 1 1 1 1 1 1\n" +
            "0 0 1 1 1 1 1 1";


    static int N, M, data[][], maxValue, answers[];
    static boolean checked[][];


    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(input.readLine());

        data = new int[N][N];
        checked = new boolean[N][N];
        answers = new int[2];

        StringTokenizer str;
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        ArrayList<Point> temp = new ArrayList<>();
        if (checkBox(0, 0, N)) {
            makeBlock(0, 0, N);
        } else {
            temp.add(new Point(0, 0));
            temp.add(new Point(0, N / 2));
            temp.add(new Point(N / 2, 0));
            temp.add(new Point(N / 2, N / 2));
            sol(temp, N / 2);
        }

        output.append(answers[0] + "\n");
        output.append(answers[1] + "\n");
        System.out.print(output);

    }

    public static void sol(ArrayList<Point> possiblePoints, int size) {

        for (int i = 0; i < possiblePoints.size(); i++) {
            Point cur = possiblePoints.get(i);

            if (checkBox(cur.row, cur.col, size)) {
                makeBlock(cur.row, cur.col, size);
            } else {
                ArrayList<Point> temp = new ArrayList<>();
                temp.add(new Point(cur.row, cur.col));
                temp.add(new Point(cur.row, cur.col + size / 2));
                temp.add(new Point(cur.row + size / 2, cur.col));
                temp.add(new Point(cur.row + size / 2, cur.col + size / 2));
                sol(temp, size / 2);
            }
        }

    }

    public static boolean checkBox(int row, int col, int size) {
        int cur = data[row][col];

        if (row + size > N || col + size > N) {
            return false;
        }
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (data[i][j] != cur) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void makeBlock(int row, int col, int size) {
        //블록 카운트 올리고
        answers[data[row][col]]++;
        //블록 만든 부분 다시 안가게 체크
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                checked[i][j] = true;
            }
        }
    }
    static class Point{
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}

