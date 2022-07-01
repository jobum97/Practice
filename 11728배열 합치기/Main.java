import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "4 3\n" +
            "2 3 5 9\n" +
            "1 4 7";

    static int N, M;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        int[] arr1 = new int[N + 1];
        str = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(str.nextToken());
        }
        arr1[N] = Integer.MAX_VALUE;

        int[] arr2 = new int[M + 1];
        str = new StringTokenizer(input.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(str.nextToken());
        }
        arr2[M] = Integer.MAX_VALUE;

        int[] sumArr = new int[N + M];

        int aIndex = 0;
        int bIndex = 0;

        for (int i = 0; i < N + M; i++) {
            if (arr1[aIndex] >= arr2[bIndex]) {
                sumArr[i] = arr2[bIndex++];
            }else{
                sumArr[i] = arr1[aIndex++];
            }
        }

        for (int i = 0; i < sumArr.length; i++) {
            output.append(sumArr[i]).append(" ");
        }
        System.out.println(output);

    }
}
