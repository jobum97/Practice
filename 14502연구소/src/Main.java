import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "7 7\n" +
            "2 0 0 0 1 1 0\n" +
            "0 0 1 0 1 2 0\n" +
            "0 1 1 0 1 0 0\n" +
            "0 1 0 0 0 0 0\n" +
            "0 0 0 0 0 1 1\n" +
            "0 1 0 0 0 0 0\n" +
            "0 1 0 0 0 0 0";

    static int N, M, map[][];
    static ArrayList<Coord> virus, proposedWall, walls;
    static Stack<Coord> tempWalls;

    static int[][] moveSet = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String arg[]) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        virus = new ArrayList<>();
        proposedWall = new ArrayList<>();
        walls = new ArrayList<>();
        tempWalls = new Stack<>();
        int temp;
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                temp = Integer.parseInt(str.nextToken());
                map[i][j] = temp;
                if (temp == 2) {
                    virus.add(new Coord(i, j));
                } else if (temp == 0) {
                    proposedWall.add(new Coord(i, j));
                } else if (temp == 1) {
                    walls.add(new Coord(i, j));
                }
            }
        }

        System.out.println(sol());

    }

    public static int sol() {
        int answer = 0;

        for (int i = 0; i < proposedWall.size(); i++) {
            for (int j = i + 1; j < proposedWall.size(); j++) {
                for (int k = j + 1; k < proposedWall.size(); k++) {

                    tempWalls.push(proposedWall.get(i));
                    tempWalls.push(proposedWall.get(j));
                    tempWalls.push(proposedWall.get(k));
                    map[proposedWall.get(i).row][proposedWall.get(i).col] = 1;
                    map[proposedWall.get(j).row][proposedWall.get(j).col] = 1;
                    map[proposedWall.get(k).row][proposedWall.get(k).col] = 1;

                    answer = Math.max(answer, virusAttack());

                    map[proposedWall.get(i).row][proposedWall.get(i).col] = 0;
                    map[proposedWall.get(j).row][proposedWall.get(j).col] = 0;
                    map[proposedWall.get(k).row][proposedWall.get(k).col] = 0;
                }
            }
        }

        return answer;
    }



    public static int virusAttack() {

        boolean[][] checked = new boolean[N][M];

        for (int i = 0; i < virus.size(); i++) {
            BFS(virus.get(i).row, virus.get(i).col, checked);
        }

        for (int i = 0; i <walls.size() ; i++) {
            checked[walls.get(i).row][walls.get(i).col] = true;
        }
        while (!tempWalls.isEmpty()) {
            Coord cur = tempWalls.pop();
            checked[cur.row][cur.col] = true;
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!checked[i][j]) {
                    answer++;
                }
            }
        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(checked[i]));
//        }
//        System.out.println("--------------" + answer + "-------------------");
        return answer;
    }

    public static void BFS(int row, int col, boolean[][] checked) {

        LinkedList<Coord> queue = new LinkedList<>();
        queue.add(new Coord(row, col));
        checked[row][col] = true;

        while (!queue.isEmpty()) {

            Coord cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + moveSet[i][0];
                int nextCol = cur.col + moveSet[i][1];

                if (nextRow < 0 | nextCol < 0 | nextRow >= N | nextCol >= M) {
                    continue;
                }

                if (checked[nextRow][nextCol]) {
                    continue;
                }

                if (map[nextRow][nextCol] == 0) {
                    queue.add(new Coord(nextRow, nextCol));
                    checked[nextRow][nextCol] = true;
                }
            }

        }

    }

    static class Coord {
        int row;
        int col;

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
