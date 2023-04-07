import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;


public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();

    static String src="9 2\n" +
            "3 2 5 5 6 4 4 5 7";
    static int N, K;

    public static void main(String args[]) throws IOException {
        //input=new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));


        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        int arr[] = new int[N + 1];
        int accArr[] = new int[11];
        int max = 0;
        // 같은 정수를 K개 이하로 포함하는 최장 연속 부분 수열
        str = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        int sPtr = 0, ePtr = 0, count = 0;
        while (ePtr < N) {
            if (++accArr[arr[ePtr]] > K) {
                accArr[arr[ePtr]]--;
                accArr[arr[sPtr++]]--;
                count--;
            }else{
                ePtr++;
                count++;
            }
            max = Math.max(count, max);
//            System.out.println(sPtr+" "+ePtr);
//            System.out.println(Arrays.toString(accArr));
        }

        System.out.println(max);
    }
}

