import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "1 3 4 6 5 8 2 5 0 5 8 8\n"
    		+ "right";

    static int N;
    static boolean[] checked;

    public static void main(String arg[]) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());

        int size = str.countTokens();
        int[] data = new int[size];

        for (int i = 0; i < size; i++) {
            data[i] = Integer.parseInt(str.nextToken());
        }
        String hand = input.readLine();

        System.out.println(Arrays.toString(data));

        Solution(data, hand);

    }

    public static void Solution(int[] numbers, String hand) {

        String result = "";
        int leftX = 0, leftY = 0, rightX = 0, rightY = 0; //왼손 *, 오른손 #

        for (int i = 0; i < numbers.length; i++) {
            // 1,4,7 은 왼손
            if (numbers[i] % 3 == 1) {
                result += "L";
                leftY = 3 - numbers[i] / 3;
                leftX = 0;
            }
            // 3,6,9 은 오른손
            else if (numbers[i] > 0 && numbers[i] % 3 == 0) {
                result += "R";
                rightY = 4 - numbers[i] / 3;
                rightX = 2;
            } //2,5,8,0 은 왼손 오른손 경쟁
            else {
                int curY = 0;
                if (numbers[i] != 0) {
                    curY = 3 - numbers[i] / 3;
                }

                //왼손 오른손 거리 비교
                int leftW = Math.abs(1 - leftX); //왼쪽손 x 거리
                int rightW = Math.abs(1 - rightX); //오른손 x 거리
                int leftH = Math.abs(leftY - curY);
                int rightH = Math.abs(rightY - curY);

                int leftL = leftW + leftH;
                int rightL = rightW + rightH;

                //System.out.println(numbers[i]+" leftL = " + leftL + " rightL =" + rightL);
                //같은 경우
                if (leftL == rightL) {
                    if (hand.equals("right")) {
                        result += "R";
                        rightX = 1;
                        rightY = curY;
                    } else if (hand.equals("left")) {
                        result += "L";
                        leftX = 1;
                        leftY = curY;
                    }
                } //오른쪽이 더 가까운 경우
                else if (leftL > rightL) {
                    result += "R";
                    rightX = 1;
                    rightY = curY;
                } //왼쪽이 더 가까운 경우
                else {
                    result += "L";
                    leftX = 1;
                    leftY = curY;
                }
            }
        }

        System.out.println(result);

    }
}