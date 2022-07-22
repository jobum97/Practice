import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static String src = "7 8 1\n" +
            "0 0 0 0 0 0 0 9\n" +
            "0 0 0 0 3 0 0 8\n" +
            "-1 0 5 0 0 0 22 0\n" +
            "-1 8 0 0 0 0 0 0\n" +
            "0 0 0 0 0 10 43 0\n" +
            "0 0 5 0 15 0 0 0\n" +
            "0 0 40 0 0 0 20 0";

    static int R, C, T, map[][];


    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));/
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        R = Integer.parseInt(str.nextToken());
        C = Integer.parseInt(str.nextToken());
        T = Integer.parseInt(str.nextToken());

        map = new int[R + 1][C + 1];

        for (int i = 0; i < R; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        //미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
        //(r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
        //인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
        //확산되는 양은 Ar,c/5이고 소수점은 버린다.
        //(r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 이다.

        //공기청정기가 작동한다.
        //공기청정기에서는 바람이 나온다.
        //위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
        //바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
        //공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.

    }

    public static void dustDiffusion(){

    }
}
