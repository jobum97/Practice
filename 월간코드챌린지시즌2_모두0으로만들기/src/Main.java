import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int[] a = {-5, 0, 2, 1, 2};
        int[][] edges = {{0, 1}, {3, 4}, {2, 3}, {0, 3}};

        System.out.println(solution(a, edges));
    }

    public static long solution(int[] a, int[][] edges) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        if (sum != 0) {
            return -1;
        }

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            adjList.add(list);
        }

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        long answer = -2;


        return answer;
    }
}
