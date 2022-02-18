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
    static String src = "0 3 5 4 6 9 2 7 8\n" +
            "7 8 2 1 0 5 6 0 9\n" +
            "0 6 0 2 7 8 1 3 5\n" +
            "3 2 1 0 4 6 8 9 7\n" +
            "8 0 4 9 1 3 5 0 6\n" +
            "5 9 6 8 2 0 4 1 3\n" +
            "9 1 7 6 5 2 0 8 0\n" +
            "6 0 3 7 0 1 9 5 2\n" +
            "2 5 8 3 9 4 7 6 0";

    static int N, Q, data[][];

    static boolean check[];

    static ArrayList<Coord> problems;

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        data = new int[9][9];
        check = new boolean[10];
        problems = new ArrayList<>();

        StringTokenizer str;

        for (int i = 0; i < 9; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < 9; j++) {
                data[i][j] = Integer.parseInt(str.nextToken());
                if (data[i][j] == 0) {
                    problems.add(new Coord(i, j));
                }
            }
        }

        backTracking(0);
        System.out.print(output);
    }

    // 스도쿠 빈칸 data의 0 다 채워나가는 것
    // DFS
    public static boolean backTracking(int index){

        if (index == problems.size()) {

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    output.append(data[i][j] + " ");
                }
                output.append("\n");
            }
            return true;
        } else {
            Coord cur = problems.get(index);

            for (int i = 1; i <= 9; i++) {
                if (isValid(cur.row, cur.col, i)) {
                    data[cur.row][cur.col] = i;

                    if (backTracking(index + 1)) {
                        return true;
                    } else {
                        data[cur.row][cur.col] = 0;
                    }
                }
            }
        }
        return false;

    }

    public static boolean isValid(int row, int col, int num) {
        int checkRow = (row / 3) * 3;
        int checkCol = (col / 3) * 3;

        for (int i = 0; i < 9; i++) {
            //가로 세로
            if (data[i][col] == num || data[row][i] == num) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                int nextRow = checkRow + i;
                int nextCol = checkCol + j;

                if (data[nextRow][nextCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    //세로 검사
    public static void verticalCheck(int row, int col) {

        for (int i = 0; i < 9; i++) {
            //아직 배정x
            if (data[i][col] == 0) {
                continue;
            }

            if (!check[data[i][col]]) {
                check[data[i][col]] = true;
            }

        }
    }

    //가로 검사
    public static void horizonCheck(int row, int col) {

        for (int i = 0; i < 9; i++) {
            //아직 배정x
            if (data[row][i] == 0) {
                continue;
            }
            if (!check[data[row][i]]) {
                check[data[row][i]] = true;
            }
        }
    }

    //박스 검사
    public static void boxCheck(int row, int col) {

        int checkRow = (row / 3) * 3;
        int checkCol = (col / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //아직 배정x
                if (data[i][j] == 0) {
                    continue;
                }
                int nextRow = checkRow + i;
                int nextCol = checkCol + j;

                if (!check[data[nextRow][nextCol]]) {
                    check[data[nextRow][nextCol]] = true;
                }
            }
        }
    }

    static class Coord {
        int row;
        int col;

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
