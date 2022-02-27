import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4 4\n" +
            "1 1 2 2";

    static int N, M, data[], answer[][];

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        data = new int[N];
        str = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(str.nextToken());
        }

        int nCm = 1;
        for (int i = N; i > N - M; i--) {
            nCm *= i;
        }
        for (int i = 2; i <= M; i++) {
            nCm /= i;
        }

        answer = new int[nCm][M];

        //비트 마스킹 조합
        int a = 0;
        for (int i = 0; i < (1 << N); i++) {

            if (Integer.bitCount(i) == M) {
                //System.out.println(Integer.toBinaryString(i));
                int b = 0;
                for (int j = 0; j < N; j++) {
                    if ((i & (1 << j)) != 0) {
                        answer[a][b] = data[j];
                        //System.out.print(data[j] + " ");
                        b++;
                    }
                }
                //하나의 출력 완성할때마다 오름차순 정렬
                Arrays.sort(answer[a]);
                a++;
            }
        }

        //  각 순열 내부에선 정렬되어있음 => 각 순열들 끼리의 정렬
        Arrays.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for (int i = 0; i < o1.length; i++) {
                    if (o1[i] != o2[i]) {
                        return o1[i] - o2[i];
                    }
                }
                return 0;
            }
        });

        // 중복 제거하며 출력
        String sb = "";
        for (int i = 0; i < nCm; i++) {
            boolean isValid = false;
            for (int j = 0; j < M; j++) {
                if (i > 0 && answer[i][j] != answer[i - 1][j]) {
                    isValid = true;
                }
                sb += (answer[i][j] + " ");
            }
            if (i == 0 || isValid) {
                output.append(sb + "\n");

            }
            sb = "";
        }

        System.out.print(output);
    }
}
