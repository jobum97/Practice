import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "10";

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        int N = Integer.parseInt(input.readLine());

        int fiveCnt[] = new int[501];
        for (int i = 1; i < fiveCnt.length; i++) {
            fiveCnt[i] = fiveCnt[i - 1] + getFiveCnt(i);
        }
        System.out.println(fiveCnt[N]);
    }

    public static int getFiveCnt(int n){
        int sum = 0;
        while (n > 0) {
            if (n / 5 > 0 && n % 5 == 0) {
                sum++;
                n /= 5;
            } else {
                break;
            }
        }
        return sum;
    }
}
