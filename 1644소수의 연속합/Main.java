import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static BufferedReader input;
    static String src = "20";
    static int N;
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(input.readLine());

        ArrayList<Integer> prime = new ArrayList<>();
        int Max = 4000000;
        boolean isntPrime[] = new boolean[Max + 1];
        isntPrime[0] = true;
        isntPrime[1] = true;
        for (int i = 2; i < (int) Math.floor(Max); i++) {
            for (int j = i + i; j <= Max; j += i) {
                isntPrime[j] = true;
            }
        }

        for (int i = 2; i <= Max; i++) {
            if (!isntPrime[i]) {
                prime.add(i);
            }
        }

        int start = 0, end = 0, sum = 0, count = 0;
        while (true) {
            if (sum >= N) {
                //합이 N보다 크면 앞에꺼 계속빼보면서 찾아본다
                sum -= prime.get(start++);
            } else if (end == prime.size()) {
                //끝에 도달한 경우
                break;
            }else{
                //합이 N보다 작아지면 전진하며 하나 더하기
                sum += prime.get(end++);
            }
            if (sum == N) {
                count++;
            }
        }
        System.out.println(count);
    }
}
