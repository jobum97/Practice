import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "3\n" +
            "1 2 3\n" +
            "1 3 2";

    static int N, inorder[], postorder[], preorder[], index;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(input.readLine());

        inorder = new int[N];
        postorder = new int[N];
        index = 0;

        StringTokenizer str = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(str.nextToken());
        }
        str = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            postorder[i] = Integer.parseInt(str.nextToken());
        }

        preorder = new int[N];
        getPreorder(0, N - 1, 0, N - 1);
        for (int i = 0; i < N; i++) {
            output.append(preorder[i] + " ");
        }
        System.out.println(output);

    }

    public static void getPreorder(int iStart, int iEnd, int pStart, int pEnd) {

        if (iStart <= iEnd && pStart <= pEnd) {
            preorder[index++] = postorder[pEnd]; //postorder의 마지막은 루트노드

            // 인오더에서 루트노드 위치 찾음
            int pos = iStart;
            for (int i = iStart; i <= iEnd; i++) {
                if (inorder[i] == postorder[pEnd]) {
                    pos = i;
                    break;
                }
            }
            //왼쪽 자식 트리
            getPreorder(iStart, pos - 1, pStart, pStart + pos - iStart - 1);
            //오른쪽 자식 트리
            getPreorder(pos + 1, iEnd, pStart + pos - iStart, pEnd - 1);
        }

    }

}
