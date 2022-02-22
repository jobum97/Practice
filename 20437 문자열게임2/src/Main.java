import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "3\n" +
            "aaabaaa\n" +
            "5\n" +
            "superaquatornado\n" +
            "2\n" +
            "abcdefghijklmnopqrstuvwxyz\n" +
            "5";

    static ArrayList<ArrayList<Integer>> indexList;

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());

        for (int i = 0; i < N; i++) {

            String W = input.readLine();
            int K = Integer.parseInt(input.readLine());
            //System.out.println("----------" + W + "---------");

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            boolean isValid = false;
            init(W);

            for (int j = 0; j < 26; j++) {
                // 원하는 개수 이상 있는 문자만 검사
                if (indexList.get(j).size() >= K) {
                    //System.out.println((char) (j + 'a'));
                    for (int k = 0; k <= indexList.get(j).size() - K; k++) {
                        int length = indexList.get(j).get(k + K - 1) - indexList.get(j).get(k) + 1;
                        min = Math.min(min, length);
                        max = Math.max(max, length);
                        isValid = true;
                    }

                }
            }
            if (isValid) {
                output.append(min + " " + max + "\n");
            } else {
                output.append("-1\n");
            }
        }
        System.out.print(output);
    }

    public static void init(String W) {
        //알파벳별로 인덱스 리스트 작성
        indexList = new ArrayList<>();
        for (int j = 0; j < 26; j++) {
            indexList.add(new ArrayList<>());
        }
        for (int j = 0; j < W.length(); j++) {
            indexList.get(W.charAt(j) - 'a').add(j);
        }
    }
}


