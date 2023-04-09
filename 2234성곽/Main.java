import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "7 4\n" +
            "11 6 11 6 3 10 6\n" +
            "7 9 6 13 5 15 5\n" +
            "1 10 12 7 13 7 5\n" +
            "13 11 10 8 10 12 13";
    static int N, M, map[][][], roomCnt, roomMaxSize, specialRoomMaxSize, startRow, startCol;

    static final int moveSet[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 남 동 북 서
    static boolean isVisited[][];
    static ArrayList<Integer> adjRoomList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        map = new int[M][N][5];
        isVisited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                // 서, 북, 동, 남 == 1,2,4,8
                convertWallInfo(Integer.parseInt(str.nextToken()), i, j);
            }
        }
        roomCnt = 0;
        roomMaxSize = 0;
        specialRoomMaxSize = 0;

        // 1.방의 갯수 구하기
        // 2. 가장 넓은 방의 넓이
        // 3. 하나의 벽을 제거하면 얻을 수 잇는 가장 큰 방의 크기 == 인근 방하고 크기 합치기
        startRow = 0;
        startCol = 0;
        while (true) {
            FootStep step = getNextStartPoint(startRow, startCol);
            if (step.row == -1 && step.col == -1) {
                break;
            }
            scanRoom(step);
        }
        removeWall();

        output.append(roomCnt).append("\n");
        output.append(roomMaxSize).append("\n");
        output.append(specialRoomMaxSize).append("\n");
        System.out.print(output);
    }

    private static void removeWall() {

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 2; k++) {
                    int nextRow = i + moveSet[k][0];
                    int nextCol = j + moveSet[k][1];

                    // 벽이 있는 경우 || 맵 밖으로 나가는 경우 || 이미 방문
                    if (!isInMap(nextRow, nextCol)) {
                        continue;
                    }
                    // 인접한데 방번호 다른 방과 크기 합쳐본다
                    if (map[i][j][4] != map[nextRow][nextCol][4]) {
                        specialRoomMaxSize = Math.max(specialRoomMaxSize, adjRoomList.get(map[i][j][4]) + adjRoomList.get(map[nextRow][nextCol][4]));
                    }
                }
            }
        }

    }

    public static FootStep getNextStartPoint(int row, int col){

        for (int i = row; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    startRow = i;
                    startCol = j;
                    return new FootStep(i, j);
                }
            }
        }
        return new FootStep(-1, -1);
    }

    public static void scanRoom(FootStep start) {

        Queue<FootStep> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start.row][start.col] = true;
        int roomSize = 1;
        while (!queue.isEmpty()) {
            FootStep cur = queue.poll();
            map[cur.row][cur.col][4] = roomCnt;
            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + moveSet[i][0];
                int nextCol = cur.col + moveSet[i][1];

                // 벽이 있는 경우 || 맵 밖으로 나가는 경우 || 이미 방문
                if (map[cur.row][cur.col][i] == 1 || !isInMap(nextRow, nextCol) || isVisited[nextRow][nextCol]) {
                    continue;
                }
                isVisited[nextRow][nextCol] = true;
                queue.add(new FootStep(nextRow, nextCol));
                roomSize += 1;
            }
        }
        adjRoomList.add(roomSize);
        roomMaxSize = Math.max(roomMaxSize, roomSize);
        roomCnt += 1;
    }

    public static class FootStep{
        int row;
        int col;

        public FootStep(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static boolean isInMap(int row, int col) {
        if (row < 0 || col < 0 || row >= M || col >= N) {
            return false;
        }
        return true;
    }

    public static void convertWallInfo(int num, int row, int col) {
        int info = 8;
        for (int i = 0; i < 4; i++) {
            int move = num / info;
            num = num % info;
            info /= 2;
            map[row][col][i] = move;
        }
        //남동북서
//        System.out.println(row + " " + col + " " + Arrays.toString(map[row][col]));
    }


}
