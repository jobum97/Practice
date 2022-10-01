import java.util.*;
public class Main {
    public static void main(String[] args) {

    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        // 판매익 10프로 추천인
        // 자신의 부모노드로 계속올라가면서 10% 떼줌
        HashMap<String, Integer> enrollMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            enrollMap.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            sell(seller[i], amount[i] * 100, enrollMap, enroll, referral, answer);
        }

        return answer;
    }

    public void sell(String seller, int revenue, HashMap<String, Integer> enrollMap, String[] enroll, String[] referral, int[] answer) {
        int sellerIdx = enrollMap.get(seller);
        String parent = referral[sellerIdx];

        answer[sellerIdx] += (revenue - revenue / 10);
        // referral "-" 일때까지 or 분배할 돈이 없는 경우
        if (parent.equals("-") || revenue == 0) {
            return;
        }

        sell(parent, revenue / 10, enrollMap, enroll, referral, answer);
    }
}
