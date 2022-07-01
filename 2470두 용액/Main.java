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

        int sanStart = -1;
        int alStart = 0;
        for (int i = 0; i < N; i++) {
            if (data[i] > 0) {
                sanStart = i;
                break;
            }
        }

        if (sanStart == 0 || sanStart == -1) {
            //산성만 잇거나 알칼리만 있는 경우
            if (data[0] < 0) {
                System.out.println(data[N - 2] + " " + data[N - 1]);
            }else{
                System.out.println(data[0] + " " + data[1]);
            }
        }else{
            int minSum = Integer.MAX_VALUE;
            int minAl = 0, minSan = 0;
            alStart = sanStart - 1;
            while (alStart >= 0 && sanStart < N) {
                int sum = data[alStart] + data[sanStart];
                //System.out.println(data[alStart] + " " + data[sanStart]);
                //최소 갱신
                if (minSum > Math.abs(sum)) {
                    minAl = data[alStart];
                    minSan = data[sanStart];
                    minSum = Math.abs(sum);
                }

                //산이 더 강한경우
                if (sum > 0) {
                    alStart--;
                } else if (sum == 0) {
                    System.out.println(data[alStart] + " " + data[sanStart]);
                    return;
                }else{
                    sanStart++;
                }
            }
            System.out.println(minAl + " " + minSan);

        }

    }
}
