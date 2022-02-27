import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "1\n" +
            "100 0 0 0 0 0 0 0 0 0 0\n" +
            "0 80 70 70 60 0 0 0 0 0 0\n" +
            "0 40 90 90 40 0 0 0 0 0 0\n" +
            "0 40 85 85 33 0 0 0 0 0 0\n" +
            "0 70 60 60 85 0 0 0 0 0 0\n" +
            "0 0 0 0 0 95 70 60 60 0 0\n" +
            "0 45 0 0 0 80 90 50 70 0 0\n" +
            "0 0 0 0 0 40 90 90 40 70 0\n" +
            "0 0 0 0 0 0 50 70 85 50 0\n" +
            "0 0 0 0 0 0 66 60 0 80 80\n" +
            "0 0 0 0 0 0 50 50 0 90 88";

    static int TC, Max, Table[][];

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        TC = Integer.parseInt(input.readLine());

        Table = new int[11][11];

        for (int testcase = 1; testcase <= TC; testcase++) {
            Max = Integer.MIN_VALUE;
            for (int i = 0; i < 11; i++) {
                StringTokenizer str = new StringTokenizer(input.readLine());
                for (int j = 0; j < 11; j++) {
                    Table[i][j] = Integer.parseInt(str.nextToken());
                }
                //System.out.println(Arrays.toString(Table[i]));
            }

            boolean[] checked = new boolean[11];
            BT(0, 0, checked);
            output.append(Max + "\n");
        }
        System.out.print(output);
    }

    public static void BT(int index, int Sum, boolean[] checked) {

        if (index == 11) {
            Max = Math.max(Max, Sum);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (Table[i][index] > 0 && !checked[i]) {

                checked[i] = true;
                BT(index + 1, Sum + Table[i][index], checked);
                checked[i] = false;
            }
        }
    }
}

