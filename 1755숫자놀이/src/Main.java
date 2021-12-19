import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "8 28";
    static HashMap<Integer, String> map;

    public static void main(String[] args) throws IOException {
        input= new BufferedReader(new InputStreamReader(System.in));
        //input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");

        ArrayList<data> arrayList = new ArrayList<>();
        for (int i = N; i <= M; i++) {
            arrayList.add(new data(change(i), i));
        }

        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (i != 0 && i % 10 == 0) {
                output.append("\n");
            }
            output.append(arrayList.get(i).value+" ");
        }
        System.out.println(output);
    }

    public static String change(int input) {
        String result = "";
        while (input / 10 != 0) {
            result = map.get(input % 10) + result;
            input /= 10;
        }
        result = map.get(input) + result;
        return result;
    }

    static class data implements Comparable<data> {
        String str;
        int value;

        public data(String str, int value) {
            this.str = str;
            this.value = value;
        }

        @Override
        public int compareTo(data o) {
            return this.str.compareTo(o.str);
        }

    }
}
