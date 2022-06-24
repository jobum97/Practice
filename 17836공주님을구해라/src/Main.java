import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 static StringBuilder output = new StringBuilder();
	 static String src = "3 4 100\n" +
             "0 0 0 0\n" +
             "1 1 1 1\n" +
             "0 0 2 0";

    static int[][] moveSet = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String arg[]) throws IOException {

		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        int row = Integer.parseInt(str.nextToken());
        int col = Integer.parseInt(str.nextToken());
        int timeLimit = Integer.parseInt(str.nextToken());
        boolean find = false;
        int searchTime = 0;

        int[][] map = new int[row + 1][col + 1];
        boolean[][][] visited = new boolean[row + 1][col + 1][2];

        for (int i = 1; i <= row; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 1; j <= col; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

//        for (int i = 0; i < row + 1; i++) {
//            System.out.println(Arrays.toString(map[i]))
//        }

        Queue<footPrint> queue = new LinkedList<>();
        if (map[1][1] == 1) {
            queue.add(new footPrint(1, 1, 0, 1));
            visited[1][1][1] = true;
        } else {
            queue.add(new footPrint(1, 1, 0, 0));
            visited[1][1][0] = true;
        }


        while (!queue.isEmpty()) {

            footPrint curStatus = queue.poll();

            //System.out.println(curStatus.row+" "+ curStatus.col);

            if (curStatus.row == row && curStatus.col == col) {
                searchTime = curStatus.time;
                find = true;
                break;
            }


            for (int i = 0; i < 4; i++) {

                int nextRow = curStatus.row + moveSet[i][0];
                int nextCol = curStatus.col + moveSet[i][1];
                int haveSword = curStatus.haveSword;
                //맵 범위 벗어나면 컷
                if (nextCol > col || nextRow > row || nextCol < 1 || nextRow < 1) {
                    continue;
                }

                //칼 없으면 벽 못 뚫음
                if (haveSword == 0 && map[nextRow][nextCol] == 1) {
                    continue;
                }

                //칼 찾으면 상태 반영
                if (map[nextRow][nextCol] == 2) {
                    haveSword = 1;
                }

                if (!visited[nextRow][nextCol][haveSword]) {
                    queue.add(new footPrint(nextRow, nextCol, curStatus.time + 1, haveSword));
                    visited[nextRow][nextCol][haveSword] = true;
                }

            }
        }
        if (!find) {
            System.out.println("Fail");
        } else {
            if (searchTime <= timeLimit) {
                System.out.println(searchTime);
            } else {
                System.out.println("Fail");
            }
        }
	}

	public static class footPrint{
        public int row;
        public int col;
        public int time;
        public int haveSword;

        public footPrint(int row, int col, int time, int haveSword) {
            this.row = row;
            this.col = col;
            this.time = time;
            this.haveSword = haveSword;
        }

    }
}
