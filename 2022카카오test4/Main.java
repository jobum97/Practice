import java.util.*;
public class Main {
    public static void main(String[] args) {
        long[] numbers = {58};
        System.out.println(Arrays.toString(solution(numbers)));
    }
    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (isValid(plusDummy(Long.toBinaryString(numbers[i])))) {

                answer[i] = 1;
            }
        }
        return answer;
    }
    public static String plusDummy(String binary){
        int length = 1;
        while (length < binary.length()) {
            length *= 2;
        }
        length -= 1;

        return "0".repeat(length - binary.length()) + binary;
    }
    public static boolean isValid(String binary){

        int mid = binary.length() / 2;
        //System.out.println(binary + " mid:" + mid);
        String front = binary.substring(0, mid);
        String back = binary.substring(mid + 1);
        //System.out.println(front + " " + back);

        if (binary.length() < 3) {
            return true;
        }
        if (binary.charAt(mid) == '0') {
            System.out.println("false!");
            return false;
        }

        return isValid(front) & isValid(back);
    }

}
