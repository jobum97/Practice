public class Main {
    public static void main(String[] args) {

        System.out.println(minNum(3, 5, 5));
    }

    /*
     * Complete the 'minNum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER samDaily
     *  2. INTEGER kellyDaily
     *  3. INTEGER difference
     */

    // 캘리가 샘보다 더 많이 푸는 최소 날짜, 못넘으면 -1

    public static int minNum(int samDaily, int kellyDaily, int difference) {
        // Write your code here
        // 샘이 하루에 푸는 문제, 캘리가 하루에 푸는 문제, 최초 샘이 앞서고 있던 문제 수

        if (kellyDaily <= samDaily) {
            return -1;
        }

        int step = kellyDaily - samDaily;
        return (difference / step) + 1;
    }
}
