import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "13 12\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 1 1 0 0 0\n" +
            "0 1 1 1 0 0 0 1 1 0 0 0\n" +
            "0 1 1 1 1 1 1 0 0 0 0 0\n" +
            "0 1 1 1 1 1 0 1 1 0 0 0\n" +
            "0 1 1 1 1 0 0 1 1 0 0 0\n" +
            "0 0 1 1 0 0 0 1 1 0 0 0\n" +
            "0 0 1 1 1 1 1 1 1 0 0 0\n" +
            "0 0 1 1 1 1 1 1 1 0 0 0\n" +
            "0 0 1 1 1 1 1 1 1 0 0 0\n" +
            "0 0 1 1 1 1 1 1 1 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0";

    static int N, M, map[][];

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        sol();
    }

    public static void sol() {
        // 공기에 접촉된 칸은 1시간 지나면 녹음
        // 치즈 내부의 공기 있을 경우 케이스 고려해야함

        // 0 은 공기 1은 치즈
        // -1은 외부 공기
        // 최초 init() 으로 외부 공기 내부공기 구분해주고
        // 시간의 흐름에 따라 치즈와 내부공기를 외부공기로 바꿔가면서 더이상 바꿀게 없으면 끝내는 것

        while(!isOver()){

        }
    }

    public static void init(){
        // 외부 공기 내부공기 구분

    }
    public static boolean isOver(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != -1) {
                    return false;
                }
            }
        }
        return true;
    }
}
