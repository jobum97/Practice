import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println(getMaximumRemovals(new ArrayList<>({7, 1, 2, 5, 4, 3, 6},"abbabaa","bb"));
    }

    /*
     * Complete the 'getMaximumRemovals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY order
     *  2. STRING source
     *  3. STRING target
     */

    // order 배열은 n의 순열 1~n까지의 숫자
    // 순서를 지키는 부분 문자열 가능

    // 순열 order[] 대로 제거된 문자들의 최대 갯수

    public static int getMaximumRemovals(List<Integer> order, String source, String target) {
        // Write your code here

        boolean checked[] = new boolean[source.length() + 1];
        int cnt = 0;
        for (int i = 0; i < order.size(); i++) {
            checked[order.get(i)-1
                    ] = true;
            if (!isValid(checked, source, target)) {
                break;
            }
            cnt++;
        }
        return cnt;
    }

    public static boolean isValid(boolean[] checked, String source, String target) {

        int targetIdx = 0;
        for (int i = 0; i < source.length(); i++) {
            if (!checked[i] && target.charAt(targetIdx) == source.charAt(i)) {
                targetIdx++;
                if (targetIdx == target.length()) {
                    return true;
                }
            }
        }

        return false;
    }


}
