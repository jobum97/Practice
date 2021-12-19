import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "5 76\n" +
            "5 4 \n" +
            "36 25 1 36 36\n" +
            "4 4\n" +
            "30 24 25 20\n" +
            "6 4\n" +
            "36 36 36 36 36 36\n" +
            "2 4\n" +
            "3 7\n" +
            "5 4\n" +
            "27 15 26 8 14";

    public static void main(String[] args) throws IOException {
        input= new BufferedReader(new InputStreamReader(System.in));
        //input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(str.nextToken()); //과목수
        int M = Integer.parseInt(str.nextToken()); //마일리지

        ArrayList<Integer> needList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());

            int P = Integer.parseInt(str.nextToken()); //신청한 수
            int L = Integer.parseInt(str.nextToken()); //수강정원

            str = new StringTokenizer(input.readLine());

            if (P < L) {
                needList.add(1);
            } else {
                int[] data = new int[P];
                for (int j = 0; j < P; j++) {
                    data[j] = Integer.parseInt(str.nextToken());
                }
                Arrays.sort(data);
                needList.add(data[data.length - L]);
            }
        }

        Collections.sort(needList);
        int cur = 0;
        int answer = 0;
        for (int i = 0; i < needList.size(); i++) {
            if (cur + needList.get(i) > M) {
                break;
            }
            cur += needList.get(i);
            answer++;
        }
        System.out.println(answer);
    }
}