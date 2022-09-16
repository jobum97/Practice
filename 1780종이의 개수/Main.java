import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "27\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";

    static int N, map[][], curRow, curCol, ans[];
    static boolean checked[][];

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        N = Integer.parseInt(input.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        // 모두 같은 수로 되어 잇을 때까지
        // 같은 수로 이뤄진 정사각형 갯수 각각 구하기
        checked = new boolean[N][N];
        ans = new int[3];

        sol();
    }

    public static void sol() {
        curRow = 0;
        curCol = 0;
        while(hasNext()){
            makeBlock();
        }
        for (int i = 0; i < ans.length; i++) {
            output.append(ans[i]).append("\n");
        }
        System.out.print(output);
    }

    public static void makeBlock(){
        // 작은 사이즈 부터 만들어본다
        int num = map[curRow][curCol];
        Queue<Coord> queue = new LinkedList<>();

        // 사각형 길이 3의 배수
        loop:
        for (int dist = 1; dist <= N; dist *= 3) {
            // 맵 밖으로 벗어나면 그만두기
            if (curRow + dist > N || curCol + dist > N) {
                break;
            }

            // 자유 배치가 아니라 사각형에서 9등분하는 시나리오 준수 ( 정해진 위치 위반하는 경우)
            if (curRow % dist != 0 || curCol % dist != 0) {
                break;
            }

            // 사각형 만들어지는지 검사
            for (int i = curRow; i < curRow + dist; i++) {
                for (int j = curCol; j < curCol + dist; j++) {
                    // 가본적 없고 같다면
                    if (map[i][j] == num) {
                        if(!checked[i][j]){
                            queue.add(new Coord(i, j));
                        }
                    } else {
                        break loop;
                    }
                }
            }

            // 사각형 완성처리
            while (!queue.isEmpty()) {
                Coord cur = queue.poll();
                checked[cur.row][cur.col] = true;
            }
        }
        // 결과 반영
        ans[++num]++;
    }

    public static class Coord{
        int row;
        int col;

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    // 더 확인할게 있는지 확인
    public static boolean hasNext(){
        while (curRow < N && curCol < N) {
            // 사용하지 않은 종이면
            if(!checked[curRow][curCol]){
                return true;
            }
            curCol++;
            if (curCol == N) {
                curRow++;
                curCol = 0;
            }
        }
        return false;
    }
}
