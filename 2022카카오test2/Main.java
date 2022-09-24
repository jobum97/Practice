import java.util.*;
public class Main {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;

        // n개의 집 i 번째 집은 거리 i , j번째 집은 j-i 만큼 거리
        // cap은 최대 실을 수 있는 갯수
        // 트럭 1대로 일 끝낼때 최소 이동거리

        int deliveryGoal = 0;
        int pickupGoal = 0;
        for (int i = 0; i < n; i++) {
            deliveryGoal += deliveries[i];
            pickupGoal += pickups[i];
        }

        // 배달과 픽업 모두 할때까지
        while (deliveryGoal > 0 || pickupGoal > 0) {

            for (int delivery = n - 1; delivery >= 0; delivery--) {

            }
        }


        return answer;
    }



}
