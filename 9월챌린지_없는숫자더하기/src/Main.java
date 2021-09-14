
public class Main {
    public static void main(String[] args) {

    }

    public static int solution(int[] numbers) {
        int answer = 0;

        boolean[] checked = new boolean[10];

        for (int i = 0; i < numbers.length; i++) {
            checked[numbers[i]] = true;
        }
        for (int i = 1; i < checked.length; i++) {
            if (!checked[i]) {
                answer += i;
            }
        }
        return answer;
    }

}
