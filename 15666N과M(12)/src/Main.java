import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4 2\n" +
            "9 7 9 1";

    static int N, M, data[], result[];
    static boolean[] checked;
    static Set<String> set;


    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(input.readLine());

        set = new HashSet<>();
        data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(data);
        result = new int[M];


        permutation(0, 0);
        System.out.print(output);
    }

    public static void permutation(int start,int cnt) {

        // M개 선택완료시
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                output.append(result[i] + " ");
            }
            output.append("\n");

            return;
        }else{
            int num = 0;
            //이전에 뽑은 것부터 선택 => 더 큰 값 뽑기 위함 (사전순)
            for (int i = start; i < N; i++) {
                //같은 자리에 똑같은 숫자 오는것 방지 => 중복방지
                if (num == data[i]) {
                    continue;
                }
                result[cnt] = data[i];
                permutation(i, cnt + 1);
                num = data[i];
            }
        }
    }

}
