import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "7 5\n" +
            "1 1 1 1 1 5 1";

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        StringTokenizer str = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(input.readLine());
        int cnt[] = new int[N];
        int accumulateSum[] = new int[N + 1];
        for (int i = 0; i < N; i++) {
            cnt[i] = Integer.parseInt(str.nextToken());

            accumulateSum[i+1] = accumulateSum[i] + cnt[i];
        }

        //System.out.println(Arrays.toString(accumulateSum));
        int max = 0;
        int maxCnt = 0;
        for (int i = M; i <= N; i++) {
            int temp = accumulateSum[i] - accumulateSum[i-M];
            if (temp > max) {
                max = temp;
                maxCnt = 1;
            } else if (temp == max) {
                maxCnt++;
            }
        }

        if (max > 0) {
            System.out.println(max + "\n" + maxCnt);
        }else{
            System.out.println("SAD");
        }




    }

}
