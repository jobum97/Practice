import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "7 10\n" +
            "0 1 3\n" +
            "1 1 7\n" +
            "0 7 6\n" +
            "1 7 1\n" +
            "0 3 7\n" +
            "0 4 2\n" +
            "0 1 1\n" +
            "1 1 6\n" +
            "1 1 7\n" +
            "1 1 1";

    static int N, M;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(input.readLine());
            int order = Integer.parseInt(str.nextToken());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            if (order == 0) {
                union(a, b);
            } else if (order == 1) {

                if (isSameParent(a, b)) {
                    output.append("YES\n");
                } else {
                    output.append("NO\n");
                }
            }
        }
        System.out.print(output);
    }

    public static int find(int x) {
        if(x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        // 같은 부모를 가지고 있지 않을 때
        if(x != y) {
            // 더 작은 값으로 넣어 줄 때 다음과 같이도 표현 가능
            if(x < y){
                parent[y] = x;
            } else{
                parent[x] = y;
            }
        }
    }
    //같은 부모 노드를 가지는지 확인
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y)
            return true;
        else
            return false;
    }
}

