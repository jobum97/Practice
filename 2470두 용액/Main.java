import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static String src = "3\n" +
            "1000000000 1000000000 1000000000";

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());

        int[] data = new int[N];
        StringTokenizer str = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(data);
       // System.out.println(Arrays.toString(data));

        int i = 0;
        int j = data.length - 1;

        int gap = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;

        int temp;
        int sum;
        while (i < j) {
            sum = data[i] + data[j];
            temp = Math.abs(sum);
            if (temp < gap) {
                gap = temp;
                ans1 = data[i];
                ans2 = data[j];
            }
            if (sum > 0)
                j--;
            else
                i++;
        }

        System.out.println(ans1 + " " + ans2);

    }
}
