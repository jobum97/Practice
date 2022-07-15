import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "50\n" +
            "30\n" +
            "24\n" +
            "5\n" +
            "28\n" +
            "45\n" +
            "98\n" +
            "52\n" +
            "60";
    static int[] postFixArr;
    static ArrayList<Integer> preFix;
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        preFix = new ArrayList<>();
        String line;
        while ((line = input.readLine()) != null) {
            preFix.add(Integer.parseInt(line));
        }

        postFixArr = new int[preFix.size()];


        getPostFix(0, postFixArr.length - 1);
        System.out.print(output);
    }

    public static void getPostFix(int l, int r) {

        if (l <= r) {
            int rightL = l + 1;
            while (rightL <= r && preFix.get(rightL) < preFix.get(l)) {
                rightL++;
            }
            getPostFix(l + 1, rightL - 1);
            getPostFix(rightL, r);
            output.append(preFix.get(l) + "\n");
        }
    }
}
