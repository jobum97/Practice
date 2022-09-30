import java.util.*;
public class Main {
    public static void main(String[] args) {

    }
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];

            // 1~45 에서 숫자 6개 찍어서 맞추기
            // 알아볼 수 없는 숫자 0

            // 알아볼 수 없는 숫자 => 전부 맞으면 최고, 전부 틀리면 최저
            int realWins = getRealWins(lottos, win_nums);
            answer[0] = getRanking(realWins + getUnknownCnt(lottos));
            answer[1] = getRanking(realWins);

            return answer;
        }

        public int getRanking(int winCnt){
            if (winCnt > 6 || winCnt < 0) {
                return -1;
            }
            if (winCnt == 0) {
                return 6;
            }

            return 7 - winCnt;
        }

        public int getUnknownCnt(int[] lottos) {
            int unknownCnt = 0;
            for (int i = 0; i < lottos.length; i++) {
                if (lottos[i] == 0) {
                    unknownCnt++;
                }
            }
            return unknownCnt;
        }

        public int getRealWins(int[] lottos, int[] win_nums) {
            int winCnt = 0;
            for (int i = 0; i < lottos.length; i++) {
                if(lottos[i] == 0){
                    continue;
                }
                for (int j = 0; j < win_nums.length; j++) {
                    if (lottos[i] == win_nums[j]) {
                        winCnt++;
                        break;
                    }
                }
            }
            return winCnt;
        }

    }
}
