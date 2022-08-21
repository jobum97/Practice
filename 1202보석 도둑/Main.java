import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "3 2\n" +
            "1 65\n" +
            "5 23\n" +
            "2 99\n" +
            "10\n" +
            "2";

    static int N, K, jewelleryData[][],bag[];

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken()); // 보석갯수
        K = Integer.parseInt(str.nextToken()); // 가방 개수

        bag = new int[K];

        jewelleryData = new int[N][2];
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            jewelleryData[i][0] = Integer.parseInt(str.nextToken());
            jewelleryData[i][1] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(jewelleryData, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(input.readLine());
        }
        Arrays.sort(bag);

        // 가방에 1개의 보석을 넣을 수 있고 가방의 무게가 정해져있으니 가방의 무게에 맞게 그리디한 탐색을 하면 될거같은 느낌?
        System.out.println(sol());
    }

    public static long sol() {
        long answer = 0;
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < bag.length; i++) {
            //범위 내이고, 보석보다 가방의 무게가 더 크면
            while (idx < N && bag[i] >= jewelleryData[idx][0]) {
                pq.add(jewelleryData[idx++][1]); //
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        return answer;
    }
}
