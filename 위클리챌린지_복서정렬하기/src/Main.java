import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] weights = {50, 82, 75, 120};
        String[] head2head = {"NLWL", "WNLL", "LWNW", "WWLN"};

        System.out.println(Arrays.toString(solution(weights, head2head)));

    }

    //승률 내림차순 , 붙어본적없으면 0%
    // 승률 동률시 몸무게 더 높은 상대 이긴수 내림차순
    // 이것도 동률일 경우 몸무게 내림차순
    // 이것도 동률 시 번호 오름차순

    public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];

        int overweightWinCnt = 0;
        int winCnt = 0;
        int loseCnt = 0;
        float winRate = 0;

        PriorityQueue<Boxer> PQ = new PriorityQueue<>();

        for (int i = 0; i < weights.length; i++) {
            overweightWinCnt = 0;
            winCnt = 0;
            loseCnt = 0;
            String vsRecord = head2head[i];
            for (int j = 0; j < vsRecord.length(); j++) {
                if (i == j) {
                    continue;
                }

                if (vsRecord.charAt(j) == 'W') {
                    winCnt++;
                    if (weights[i] < weights[j]) {
                        overweightWinCnt++;
                    }
                }
                if (vsRecord.charAt(j) == 'L') {
                    loseCnt++;
                }
            }

            if (winCnt + loseCnt == 0) {
                winRate = 0;
            } else {
                winRate = (float) winCnt / (winCnt + loseCnt);
            }

            //System.out.println((float) winCnt / (winCnt + loseCnt) + " " + overweightWinCnt + " " + weights[i] + " " + (i + 1));
            PQ.add(new Boxer(winRate, overweightWinCnt, weights[i], i + 1));

        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = PQ.poll().num;
        }

        return answer;
    }

    static class Boxer implements Comparable<Boxer> {
        public float winRate;
        public int overweightWinCnt;
        public int weight;
        public int num;

        public Boxer(float winRate, int overweightWinCnt, int weight, int num) {
            this.winRate = winRate;
            this.overweightWinCnt = overweightWinCnt;
            this.weight = weight;
            this.num = num;
        }

        @Override
        public int compareTo(Boxer o) {
            if (this.winRate == o.winRate) {
                if (this.overweightWinCnt == o.overweightWinCnt) {
                    if (this.weight == o.weight) {
                        return this.num - o.num;
                    } else {
                        return o.weight - this.weight;
                    }
                } else {
                    return o.overweightWinCnt - this.overweightWinCnt;
                }
            } else {
                return Float.compare(o.winRate, this.winRate);
            }
        }
    }
}
