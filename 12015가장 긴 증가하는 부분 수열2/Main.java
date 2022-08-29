import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "6\n" +
            "30 20 10 15 2 50";

    static int N, data[], LIS[];


    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        N = Integer.parseInt(input.readLine());

        data = new int[N];
        LIS = new int[N];

        StringTokenizer str = new StringTokenizer(input.readLine());

        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(str.nextToken());
        }

        // LIS 초기 값으로 첫 번째 수열의 값을 갖는다.
        LIS[0] = data[0];
        int lengthOfLIS = 1;

        for (int i = 1; i < N; i++) {

            int key = data[i];

            // 만약 key가 LIS의 마지막 값보다 클 경우 추가해준다.
            if (LIS[lengthOfLIS - 1] < key) {
                lengthOfLIS++;
                LIS[lengthOfLIS - 1] = key;
            }
            else {
                // Lower Bound 이분탐색을 진행한다.
                int lo = 0;
                int hi = lengthOfLIS;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;

                    if(LIS[mid] < key) {
                        lo = mid + 1;
                    }
                    else {
                        hi = mid;
                    }

                }
                /*
                 *  lo가 LIS에서 대치 될 원소의 위치가 될 것이고
                 *  해당 위치에 key값으로 원소를 바꿔준다.
                 */
                LIS[lo] = key;
            }

        }

        System.out.println(lengthOfLIS);
    }
}
