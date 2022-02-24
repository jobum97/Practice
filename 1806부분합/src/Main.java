import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "10 30\n" +
            "5 1 3 5 10 7 4 9 2 8";

    static int N, S, data[], accumulateSum[];

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        S = Integer.parseInt(str.nextToken());

        data = new int[N + 1];
        accumulateSum = new int[N + 1];
        boolean findIndex = false;
        boolean findAnswer = false;
        int checkIndex = 0;
        int answer = 0;

        str = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            data[i] = Integer.parseInt(str.nextToken());
            accumulateSum[i] = accumulateSum[i - 1] + data[i];
            if (!findIndex && accumulateSum[i] >= S) {
                findIndex = true;
                checkIndex = i;
            }
            if (data[i] >= S) {
                findAnswer = true;
                break;
            }
        }

        if (findAnswer) {
            System.out.println(1);
        } else {
            // 누적합이 S를 못넘음 => 부분합이 S를 넘을 수가 없음
            if (!findIndex) {
                System.out.println(0);
            } else {
                //checkIndex 부터 탐색 적어도 조건 S 를 넘기는 누적합부터 검사
                // 이 시점에서 최소 length = checkIndex
                int minLength = checkIndex;

                for (int right = checkIndex; right <= N; right++) {
                    for (int length = minLength; length > 1; length--) {
                        int sum = accumulateSum[right] - accumulateSum[right - length];
                        //System.out.println(sum + " " + length);
                        if (sum >= S) {
                            minLength = length;
                        } else {
                            break;
                        }
                    }
                }
                System.out.println(minLength);
            }

        }

    }

}
