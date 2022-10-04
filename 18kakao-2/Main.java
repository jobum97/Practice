public class Main {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}));
    }
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < arr1.length; i++) {
            String line1 = Integer.toBinaryString(arr1[i]);
            String line2 = Integer.toBinaryString(arr2[i]);
            answer[i] = getLine(n, arr1[i], arr2[i]);
        }

        return answer;
    }

    public static String getLine(int n, int a, int b) {
        String result = "";
        for (int i = 0; i < n; i++) {
            if (((a % 2) | (b % 2)) == 1) {
                result = "#" + result;
            }else{
                result = " " + result;
            }
            a /= 2;
            b /= 2;
        }
        return result;
    }
}
