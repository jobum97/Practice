import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // DB 쿼리 문제



        int[][] data = new int[10][10];
        Arrays.sort(data, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
    }


}
