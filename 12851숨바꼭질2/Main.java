import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "5 17";

    static int N, K, timeTable[];

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        timeTable = new int[200001];
        Arrays.fill(timeTable, Integer.MAX_VALUE);
        timeTable[N] = 0;
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(N, 0));

        int count = 0;
        int minTime = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Pos curPos = queue.poll();
            int cur = curPos.pos;
            int time = curPos.time;

            //System.out.println(cur+" "+ time);
            if (cur == K || time > minTime) {

                if (minTime > time) {
                    minTime = time;
                    count = 1;
                } else if (minTime == time) {
                    count++;
                }

                continue;
            }

            for (int i = 0; i < 3; i++) {
                int next = move(cur, i);
                // 범위 벗어나거나, 이미 간곳이면 컷, 시작점이거나
                if (next < 0 || next > 200000) {
                    continue;
                }

                if (timeTable[next] >= time + 1) {
                    timeTable[next] = time + 1;
                    queue.add(new Pos(next, time + 1));
                }
            }
        }

        System.out.println(timeTable[K]);
        System.out.println(count);
    }

    public static int move(int pos, int i) {
        if (i == 0) {
            return pos - 1;
        } else if (i == 1) {
            return pos + 1;
        } else if (i == 2) {
            return pos * 2;
        } else {
            return -1;
        }
    }

    static class Pos{
        int pos;
        int time;

        public Pos(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

}
