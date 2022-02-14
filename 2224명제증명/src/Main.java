import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "6\n" +
            "a => z\n" +
            "z => C\n" +
            "C => E\n" +
            "D => z\n" +
            "z => a\n" +
            "z => D";

    static int N;
    static boolean Table[][];
    static ArrayList<ArrayList<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(input.readLine());
        StringTokenizer str;
        adjList = new ArrayList<>();
        Table = new boolean[52][52];
        for (int i = 0; i < 52; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            int s = indexing(str.nextToken().charAt(0));
            str.nextToken();
            int e = indexing(str.nextToken().charAt(0));

            adjList.get(s).add(e);
        }

        for (int i = 0; i < 52; i++) {
            Search(i);
        }

        int count = 0;

        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {

                if (i == j) {
                    continue;
                }
                if (Table[i][j]) {
                    count++;
                    output.append(charing(i) + " => " + charing(j)+"\n");
                }
            }
        }

        System.out.print(count + "\n" + output);

    }

    public static void Search(int s) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(s);
        Table[s][s] = true;

        while (!pq.isEmpty()) {
            int cur = pq.poll();

            for (int i = 0; i < adjList.get(cur).size(); i++) {
                //이미 체크한곳 제외
                if (!Table[s][adjList.get(cur).get(i)]) {
                    System.out.println(charing(cur) + " " + charing(adjList.get(cur).get(i)));
                    Table[s][adjList.get(cur).get(i)] = true;
                    pq.add(adjList.get(cur).get(i));
                }
            }
        }
    }

    public static int indexing(char input) {
        if (input - 'a' < 0) {
            return input - 'A';
        } else {
            return input - 'a' + 26;
        }
    }

    public static char charing(int input) {
        if (input < 26) {
            return (char) (input + 65);
        } else {
            return (char) (input + 71);
        }
    }
}
