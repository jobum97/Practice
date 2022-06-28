import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "4 42";
    static boolean isPossible = false;

    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        int A = Integer.parseInt(str.nextToken());
        int B = Integer.parseInt(str.nextToken());

        DFS(A, B, 1);
        if(!isPossible){
            System.out.println(-1);
        }

    }

    public static void DFS(long A, long B, int count) {

        if (A > B) {
            return;
        } else if (A == B) {
            isPossible = true;
            System.out.println(count);
        }


        DFS(A * 10 + 1, B, count + 1);
        DFS(A * 2, B, count + 1);
    }
}
