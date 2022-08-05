import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "20\n" +
            "#.....!.!...........\n" +
            "******.*.***********\n" +
            "*!....!*.***********\n" +
            "*.****.*.***********\n" +
            "*.**!.!*.***********\n" +
            "*.**.***.***********\n" +
            "*.**!.!*.***********\n" +
            "*.****.*.***********\n" +
            "*.**!.!*.***********\n" +
            "*.**.***.***********\n" +
            "*!..!.......#*******\n" +
            "********.***.*******\n" +
            "********.***.*******\n" +
            "********.***.*******\n" +
            "********.***.*******\n" +
            "********.*!.!*******\n" +
            "********.*.*********\n" +
            "********.*!.!*******\n" +
            "********.***.*******\n" +
            "********!...!*******";
    static int N;
    static int checked[][][];
    static char map[][];

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 남 북 서 동
    static int startRow, startCol, endRow, endCol;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이

        N = Integer.parseInt(input.readLine());
        map = new char[N + 1][N + 1];
        checked = new int[N + 1][N + 1][4];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k < 4; k++) {
                    checked[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        boolean isSecond = false;
        for (int i = 1; i <= N; i++) {
            String line = input.readLine();
            for (int j = 1; j <= N; j++) {
                char c = line.charAt(j - 1);
                map[i][j] = c;
                if (c == '#') {
                    if(!isSecond){
                        startRow = i;
                        startCol = j;
                        isSecond = true;
                    }else{
                        endRow = i;
                        endCol = j;
                    }
                }
            }
        }

        sol();

    }

    public static void sol(){
        Queue<Coord> queue = new LinkedList<>();
        queue.add(new Coord(0, startRow, startCol));
        queue.add(new Coord(1, startRow, startCol));
        queue.add(new Coord(2, startRow, startCol));
        queue.add(new Coord(3, startRow, startCol));
        checked[startRow][startCol][0] = 0;
        checked[startRow][startCol][1] = 0;
        checked[startRow][startCol][2] = 0;
        checked[startRow][startCol][3] = 0;


        while (!queue.isEmpty()) {
            Coord cur = queue.poll();
            System.out.println(cur.row+" "+ cur.col);

            // 방향대로 직진하다가 거울 놓을 수 있는 위치 도달시
            // 이전의 방향 고려해서 갈 수 있는 방향으로 queue에 삽입+ checked에 이전의 지나온 거울 개수+1기록
            int nextRow = cur.row + dir[cur.dir][0];
            int nextCol = cur.col + dir[cur.dir][1];
            while (0 < nextRow && nextRow <= N && 0 < nextCol && nextCol <= N) {

                // 벽을 만나면 멈춰!
                if(map[nextRow][nextCol]== '*'){
                    break;
                }//거울 설치 가능한 곳이면
                else if (map[nextRow][nextCol] == '!') {
                    // 들어온 방향이 남쪽 혹은 북쪽이면
                    if (cur.dir == 0 || cur.dir == 1) {
                        for (int i = 2; i < 4; i++) {
                            if (checked[nextRow][nextCol][i] >= checked[cur.row][cur.col][cur.dir]) {
                                checked[nextRow][nextCol][i] = checked[cur.row][cur.col][cur.dir] + 1;
                                queue.add(new Coord(i, nextRow, nextCol));
                            }
                        }

                    }else if(cur.dir == 2 || cur.dir == 3){
                        for (int i = 0; i < 2; i++) {
                            if (checked[nextRow][nextCol][i] >= checked[cur.row][cur.col][cur.dir]) {
                                checked[nextRow][nextCol][i] = checked[cur.row][cur.col][cur.dir] + 1;
                                queue.add(new Coord(i, nextRow, nextCol));
                            }
                        }

                    }
                } else if (nextRow == endRow && nextCol == endCol) {
                    //System.out.println("도착 from " + checked[cur.row][cur.col][cur.dir]);
                    if (checked[nextRow][nextCol][cur.dir] > checked[cur.row][cur.col][cur.dir]) {
                        checked[nextRow][nextCol][cur.dir] = checked[cur.row][cur.col][cur.dir];
                    }
                }

                nextRow += dir[cur.dir][0];
                nextCol += dir[cur.dir][1];

            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if (checked[endRow][endCol][i] != Integer.MAX_VALUE) {
                answer = Math.min(answer, checked[endRow][endCol][i]);
            }
        }
        System.out.println(answer);
    }



    public static class Coord{
        int dir;
        int row;
        int col;

        public Coord(int dir, int row, int col) {
            this.dir = dir;
            this.row = row;
            this.col = col;
        }
    }
}
