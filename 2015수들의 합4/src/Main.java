import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4 0\n" +
            "2 -2 2 -2";

    static int N, K, data[], accumulateSum[][];
    static Map<Integer, Long> map = new HashMap<>();
    static boolean check[];

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        data = new int[N + 1];

        str = new StringTokenizer(input.readLine());

        long answer = 0;

        for (int i = 1; i <= N; i++) {
            data[i] = Integer.parseInt(str.nextToken()) + data[i - 1]; //누적합 배열
            // 누적합이 K면 카운트
            if (data[i] == K) {
                answer++;
            }
            //부분합 = 누적합 - 누적합
            //맵에 현재의 누적합이 K가 되기 위한 값이 있다면 재료의 개수 만큼 더하기
            if (map.containsKey(data[i] - K))
                answer += map.get(data[i] - K);

            //없다면 재료로 등록
            if (!map.containsKey(data[i]))
                map.put(data[i], 1L);
            else
                map.put(data[i], map.get(data[i]) + 1);
        }
        //System.out.println(Arrays.toString(data));

        System.out.println(answer);
    }

}
