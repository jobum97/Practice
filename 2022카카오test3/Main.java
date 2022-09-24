import java.util.*;
public class Main {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};

        // 가입자를 최대한 늘리고 판매액 늘리는 것

        // 사용자는 각자의 기준(할인율)에 따라 구매  or 서비스 가입
        // 일정 구매금액 이상되면 서비스 가입

        // 특정 할인율 되었을 때 베스트 서비스 가입 수와 이모티콘 매출액 구하기

        // 할인율별 서비스 가입자수, 매출액 => 정렬
        ArrayList<Result> results = new ArrayList<>();
        for (int i = 0; i < users.length; i++) {

            int userRate = users[i][0];
            int price = users[i][1];
            // 이모티콘 산다/안산다 로 구분 어차피 유저가 살 때 할인율을 정해져있음
            // 최대한 가입하게 해야하기 때문에 최대한 구매하게해야함
            int totalBuy = 0;
            for (int j = 0; j < emoticons.length; j++) {

            }
        }




        return answer;
    }
    public class Result{
        int user;
        int revenue;

        public Result(int user, int revenue) {
            this.user = user;
            this.revenue = revenue;
        }
    }
}
