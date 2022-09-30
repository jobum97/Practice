import java.util.*;
public class Main {
    public static void main(String[] args) {

    }
    class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];
            int[][] map = getMap(rows, columns);
            for (int i = 0; i < queries.length; i++) {
                answer[i] = rotate(map, queries[i]);
                for (int j = 0; j < rows; j++) {
                    System.out.println(Arrays.toString(map[i]));;
                }
            }



            return answer;
        }

        public int rotate(int[][] map, int[] query) {


            int r1 = query[0] - 1;
            int c1 = query[1] - 1;
            int r2 = query[2] - 1;
            int c2 = query[3] - 1;
            int min = map[r1][c1];
            int temp = map[r1][c1];

            for (int i = c1 + 1; i <= c2; i++) {
                min = Integer.min(min, map[r1][i]);
                int tmp = map[r1][i];
                map[r1][i] = temp;
                temp = tmp;
            }

            for (int i = r1 + 1; i <= r2; i++) {
                min = Integer.min(min, map[i][c2]);
                int tmp = map[i][c2];
                map[i][c2] = temp;
                temp = tmp;
            }

            for (int i = c2; i > c1; i--) {
                min = Integer.min(min, map[r2][i]);
                int tmp = map[r2][i];
                map[r2][i] = temp;
                temp = tmp;
            }

            for (int i = r2; i > r1; i--) {
                min = Integer.min(min, map[i][c1]);
                int tmp = map[i][c1];
                map[i][c1] = temp;
                temp = tmp;
            }

            return min;

        }


        public int[][] getMap(int row, int column) {
            int map[][] = new int[row][column];
            int num = 1;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    map[i][j] = num++;
                }
            }
            return map;
        }
    }
}
