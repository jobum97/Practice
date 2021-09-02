import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    static int N;
    static boolean[] checked;

    public static void main(String arg[]) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        //input = new BufferedReader(new StringReader(src));

        int N = 5; //전체 스테이지 개수
        int stages[] = {2, 1, 2, 6, 2, 4, 3, 3}; //사용자들 현재 멈춰 있는 스테이지 번호들 = 현재 도전중인 스테이지 번호
        //N+1 == 모두 클리어한 사람
        //스테이지에 도달한 사람 없으면 실패율 = 0

        System.out.println(Arrays.toString(solution(N, stages)));

    }

    //실패율 = 스테이지 도달 but 클리어 X / 스테이지 도달

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] failedPeople = new int[N + 2];
        int[] stagePeople = new int[N + 2];
        PriorityQueue<stage> PQ = new PriorityQueue<>();

        for (int i = 0; i < stages.length; i++) {
            // 스테이지별로 도달한 사용자수 카운팅
            for (int j = 1; j <= stages[i]; j++) {
                stagePeople[j]++;
            }
            failedPeople[stages[i]]++; //실패한 스테이지 카운트
        }

        /*System.out.println(Arrays.toString(failedPeople));
        System.out.println(Arrays.toString(stagePeople));*/

        //실패율 순으로 정렬
        for (int i = 1; i < N + 1; i++) {

            double temp;
            //도달한 유저 없으면 실패율 =0
            if (stagePeople[i] == 0) {
                temp = 0;
            } else {
                temp = (double) failedPeople[i] / stagePeople[i];
            }

            System.out.println(i+" "+temp);
            PQ.add(new stage(temp, i));
        }

        int j = 0;
        while (!PQ.isEmpty()) {
            stage stage = PQ.poll();
            answer[j] = stage.stageNum;
            j++;
        }
        return answer;
    }

    public static class stage implements Comparable<stage> {
        public double failRate;
        public int stageNum;

        public stage(double failRate, int stageNum) {
            this.failRate = failRate;
            this.stageNum = stageNum;
        }

        @Override
        public int compareTo(stage o) {
            int temp = Double.compare(o.failRate, this.failRate);
            if (temp == 0) {
                return this.stageNum - o.stageNum;
            } else {
                return temp;
            }
        }
    }




}