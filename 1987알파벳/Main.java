import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output;
    static String src = "5 5\n" +
            "IEFCJ\n" +
            "FHFKC\n" +
            "FFALF\n" +
            "HFGCF\n" +
            "HMCHH";

    static int Row, Col, result;
    static int[][] moveSet = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        Row = Integer.parseInt(str.nextToken());
        Col = Integer.parseInt(str.nextToken());

        boolean checked[] = new boolean[28];
        char map[][] = new char[Row][Col];
        for (int i = 0; i < Row; i++) {
            String rowStr = input.readLine();
            for (int j = 0; j < Col; j++) {
                map[i][j] = rowStr.charAt(j);
            }
        }
        result = 0;
        checked[map[0][0] - 'A'] = true;
        sol(map, checked, 0, 0, 1);
        System.out.println(result);
    }

    public static void sol(char map[][], boolean checked[], int row, int col, int count) {
        result = Math.max(count, result);
        for (int i = 0; i < 4; i++) {
            int nextRow = row + moveSet[i][0];
            int nextCol = col + moveSet[i][1];

            if (nextRow >= Row || nextRow < 0 || nextCol >= Col || nextCol < 0) {
                continue;
            }

            if(checked[map[nextRow][nextCol]-'A']){
                continue;
            }else{
                checked[map[nextRow][nextCol] - 'A'] = true;
                //System.out.println(nextRow + " " + nextCol);
                sol(map, checked, nextRow, nextCol, count + 1);
                checked[map[nextRow][nextCol] - 'A'] = false;
            }
        }

    }


}
