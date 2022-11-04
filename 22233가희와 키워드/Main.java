import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "5 2\n" +
            "map\n" +
            "set\n" +
            "dijkstra\n" +
            "floyd\n" +
            "os\n" +
            "map,dijkstra\n" +
            "map,floyd";
    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        StringTokenizer str = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        // 키워드 모두 다름, N 개
        // 글 작성시 최대 10개 키워드
        // 쓰면 지워짐
        // 글 쓰고나서 남은 키워드 갯수?

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(input.readLine());
        }

        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(input.readLine(), ",");
            while (str.hasMoreTokens()) {
                set.remove(str.nextToken());
            }
            output.append(set.size()).append("\n");
        }
        System.out.print(output);
    }
}
