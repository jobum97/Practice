import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "436659 2";

    static int N, K, answer = -1, length;
    static boolean visit[][] = new boolean[1000001][11];

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());
        length = String.valueOf(N).length();
        bfs();
        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Pair> queue = new LinkedList<>();
        visit[N][0] = true;
        queue.add(new Pair(N, 0));

        while (!queue.isEmpty()) {
            Pair now = queue.poll();

            if (now.cnt == K) {
                answer = Math.max(answer, now.num);
                continue;
            }

            for (int i = 0; i < length - 1; i++) {
                for (int j = i + 1; j < length; j++) {
                    char[] swapped = swap(now.num, i, j);
                    int num = Integer.parseInt(String.valueOf(swapped));

                    if (swapped[0] == '0' || visit[num][now.cnt + 1])
                        continue;

                    visit[num][now.cnt + 1] = true;
                    queue.add(new Pair(num, now.cnt + 1));
                }
            }
        }
    }

    public static class Pair {
        int num, cnt;

        public Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static char[] swap(int num, int i, int j) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));

        char tmp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, tmp);

        return sb.toString().toCharArray();
    }
}
