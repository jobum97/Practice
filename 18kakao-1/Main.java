import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("1S*2T*3S"));
    }
    public static int solution(String dartResult) {
        int answer = 0;

        //3번의 기회, 각 0~10

        // S, D, T : 1제곱, 2제곱, 3제곱
        //* 이전 점수, 현재 점수 둘다 *2 , # 이전점수-현재점수
        // *# 은 중첩 가능=> -2

        int result[] = new int[3];
        int sIdx = 1;
        int eIdx = 0;
        int orderIdx = 0;
        String order[] = new String[3];
        for (int i = 2; i < dartResult.length(); i++) {
            int temp = dartResult.charAt(i) - '0';
            if (temp >= 0 && temp <= 9) {
                eIdx = i;
                i++;
                order[orderIdx] = dartResult.substring(sIdx-1, eIdx);
                sIdx = i;
                orderIdx++;
            }
        }
        order[orderIdx] = dartResult.substring((eIdx));

        doOrder(order, result);
        System.out.println(Arrays.toString(result));
        for (int i = 0; i < result.length; i++) {
            answer += result[i];
        }
        return answer;
    }

    public static void doOrder(String[] order, int[] result) {
        for (int i = 0; i < order.length; i++) {
            String orderStr = order[i];
            int idx = 0;
            for (int j = 0; j < orderStr.length(); j++) {
                if(orderStr.charAt(j) =='S' ||orderStr.charAt(j) =='D'|| orderStr.charAt(j) =='T'){
                    idx = j;
                    break;
                }
            }
            int num = Integer.parseInt(orderStr.substring(0, idx));
            char command = orderStr.charAt(idx);
            char special = ' ';
            if (orderStr.length() > idx + 1) {
                special = orderStr.charAt(idx + 1);
            }

            System.out.println(num + "|" + command + "|" + special);


            if (command == 'S') {
                result[i] += num;
            } else if (command == 'D') {
                result[i] += num * num;
            } else if (command == 'T') {
                result[i] += num * num * num;
            }


            if (special == '*') {
                result[i] *= 2;
                if (i > 0) {
                    result[i - 1] *= 2;
                }
            } else if (special == '#') {
                result[i] *= -1;
            }

        }
    }
}
