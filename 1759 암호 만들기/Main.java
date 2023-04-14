import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "4 6\n" +
            "a t c i s w";

    static int L, C;
    static ArrayList<String> passwords = new ArrayList<>();
    static ArrayList<Character> charList = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        StringTokenizer str = new StringTokenizer(input.readLine());
        L = Integer.parseInt(str.nextToken());
        C = Integer.parseInt(str.nextToken());

        ArrayList<Character> momList = new ArrayList<>();
        ArrayList<Character> sonList = new ArrayList<>();
        // 암호 최소 1개의 모음, 2개의 자음
        // 알파벳 오름차순
        str = new StringTokenizer(input.readLine());
        for (int i = 0; i < C; i++) {
            char c = str.nextToken().charAt(0);
            charList.add(c);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                momList.add(c);
            }else{
                sonList.add(c);
            }

        }
        visited = new boolean[C];
        dfs(0, 0,  "");
        Collections.sort(passwords);
        for (String password : passwords) {
            output.append(password).append("\n");
        }
        System.out.print(output);
    }

    public static void dfs(int monCnt, int sonCnt, String word) {
        if (word.length() == L) {
            if (monCnt >= 1 && sonCnt >= 2) {
                passwords.add(word);
            }
            return;
        }


        for (int i = 0; i < C; i++) {
            char c = charList.get(i);

            if (visited[i]) {
                continue;
            }
            if (word.length() > 0 && word.charAt(word.length() - 1) > c) {
                continue;
            }

            visited[i] = true;
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                dfs(monCnt+1, sonCnt, word + c);
            }else{
                dfs(monCnt, sonCnt+1, word + c);
            }
            visited[i] = false;
        }

    }


}
