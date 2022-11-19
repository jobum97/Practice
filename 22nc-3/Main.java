import javax.sound.midi.Soundbank;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[][]{{0, 2, 3, 1}, {5, 3, 3, 1}, {10, 2, 4, 1}})));

    }
}

class Solution {
    public int[] solution(int[][] jobs) {
        ArrayList<Integer> answerArr = new ArrayList<>();

        // 한번 작업 시작하면 해당 분류 작업들 마무리까지함 요청은 받을 수 잇음
        // 중요도 합이 높은 부류 처리, 같다면 분류 번호 오름차순으로 처리

        // 분류 같다면 사실상 같은 작업으로 봐도 되는 부분

        // 작업 : 분류번호, 중요도 합, 시간 합
        int finish =0;


        int[][] taskStatus = new int[101][3];
        boolean[] checked = new boolean[jobs.length];
        int cursor = jobs[0][2];
        answerArr.add(cursor);
        int timeLimit = jobs[0][0]+jobs[0][1];
        checked[0] = true;
        finish++;
        int idx =1;

        int Do =0;
        // 작업: 요청시각, 소요시간, 분류번호, 중요도
        while(Do<5){
            // 현재 작업 기준으로 되는대로 분류 번호 쭉쭉 처리
            for(int i=idx;i<jobs.length;i++){

                System.out.println(Arrays.toString(jobs[i])+" "+timeLimit+" "+finish);
                // 현재 작업과 같은 분류이고 시간 제한안에 들어온 요청이면 이어서 동작
                if(!checked[i] && cursor == jobs[i][2]  && jobs[i][0] <= timeLimit){
                    checked[i] = true;
                    timeLimit += jobs[i][1];
                    finish++;
                }

                // 다르다면 쌓아두자
                if(!checked[i] && cursor != jobs[i][2]  && jobs[i][0] <= timeLimit){
                    taskStatus[jobs[i][2]][0] += jobs[i][1];
                    taskStatus[jobs[i][2]][1] += jobs[i][3];
                    taskStatus[jobs[i][2]][2]++;
                    checked[i] = true;
                }

                // 시간 초과시 해당 분류 작업 끝
                if(timeLimit < jobs[i][0]){
                    idx =i;
                    break;
                }
            }
            System.out.println(timeLimit+" "+idx+" "+cursor);
            // 끝난 시간 기점으로 판단
            for(int i=1;i<5;i++){
                System.out.println(Arrays.toString(taskStatus[i]));
            }
            cursor = getNextWork(taskStatus);
            // 새로운 작업 착수
            timeLimit+= taskStatus[cursor][0];
            finish += taskStatus[cursor][2];
            taskStatus[cursor][0] =0;
            taskStatus[cursor][1] =0;
            taskStatus[cursor][2] =0;
            System.out.println(cursor+" "+finish);
            answerArr.add(cursor);
            Do++;
        }

        int[] answer = new int[answerArr.size()];
        for(int i=0;i<answerArr.size();i++){
            answer[i] = answerArr.get(i);
        }
        return answer;
    }

    public int getNextWork(int[][] taskStatus){
        // 중요도 합이 높은 부류 처리, 같다면 분류 번호 오름차순으로 처리
        int value =0;
        int idx =0;
        for(int i=0;i<taskStatus.length;i++){
            if(value < taskStatus[i][1]){
                value = taskStatus[i][1];
                idx =i;
            }
        }

        return idx;
    }

    // public class Task implements Comparable<Task>{
    //     int number;
    //     int cost;
    //     int value;
    //     public Task(int number, int cost, int value){
    //         this.number = number;
    //         this.cost = cost;
    //         this.value = value;
    //     }
    //     public void add(Task o){
    //         this.cost +=o.cost;
    //         this.value +=
    //     }

    // }
}


