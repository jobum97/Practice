import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"}));
    }
    public static int solution(String[] lines) {
        int answer = 0;

        // 초당 최대 처리량은 1초, 1000 밀리초 간 처리한 요청의 최대 개수

        // 시간, 분, 초, 밀리초, 처리 초, 처리 밀리초
        int[][] logs = new int[lines.length][6];
        for (int i = 0; i < lines.length; i++) {
            String temp[] = lines[i].substring(11, lines[i].length() - 1).split(" ");
            String runTime[] = temp[1].split("\\.");
            String complete[] = temp[0].split(":");
            String completeSecond[] = complete[2].split("\\.");
            logs[i][4] = Integer.parseInt(runTime[0]);
            logs[i][5] = Integer.parseInt(runTime[1]);
            logs[i][0] = Integer.parseInt(complete[0]);
            logs[i][1] = Integer.parseInt(complete[1]);
            logs[i][2] = Integer.parseInt(completeSecond[0]);
            logs[i][3] = Integer.parseInt(completeSecond[1]);
        }

        // 끝나는 시간 기준으로 잡는거 아닌가?

        for (int i = 0; i < logs.length; i++) {
            System.out.println(Arrays.toString(logs[i]));
        }

        int cnt=0;
        for (int i = 0; i < logs.length; i++) {
            cnt = 1;
            // 시작점으로 잡은 곳 작업의 끝부터 1초간 선택할 수 있는 작업 세보는것
            for (int j = i + 1; j < logs.length; j++) {
                // 기준작업끝 +1초 보다 완료시간이 빠르면 or 시작시간이 빠르면
                if (isEnded(i, j, logs) || isStarted(i, j, logs)) {
                    cnt++;
                } else {
                    answer = Math.max(cnt, answer);
                    break;
                }
            }
        }
        answer = Math.max(cnt, answer);
        return answer;
    }

    public static boolean isEnded(int startIdx, int curIdx, int[][] logs) {
        //기준점의 완료시간 +1 보다 현재 검사하는 완료시간이 빨라야함 == 작으면 true

        // 완료시간의 시간이 크면 true 반대로 작으면x
        if (logs[startIdx][0] > logs[curIdx][0]) {
            return true;
        } else if (logs[startIdx][0] < logs[curIdx][0]) {
            return false;
        }

        // 분
        if (logs[startIdx][1] > logs[curIdx][1]) {
            return true;
        } else if (logs[startIdx][1] < logs[curIdx][1]) {
            return false;
        }

        // 초
        if (logs[startIdx][2] + 1 > logs[curIdx][2]) {
            return true;
        } else if (logs[startIdx][2] + 1 < logs[curIdx][2]) {
            return false;
        }

        if (logs[startIdx][3] >= logs[curIdx][3]) {
            return true;
        }
        return false;
    }
    public static boolean isStarted(int startIdx, int curIdx, int[][] logs) {

        int curStartHour = logs[curIdx][0];
        int curStartMin = logs[curIdx][1];
        int curStartSecond = logs[curIdx][2] - logs[curIdx][4];
        int curStartMSecond = logs[curIdx][3] - logs[curIdx][5];

        if (curStartMSecond < 0) {
            curStartSecond--;
            curStartMSecond += 1000;
        }

        if (curStartSecond < 0) {
            curStartMin--;
            curStartSecond += 60;
        }
        if (curStartMin < 0) {
            curStartHour--;
            curStartMin += 60;
        }

        //기준점의 완료시간+1 보다 현재 검사하는 작업의 시작 빨라야함 == 작으면 true

        if (logs[startIdx][0] > curStartHour) {
            return true;
        }

        if (logs[startIdx][0] == curStartHour){
            if(logs[startIdx][1] > curStartMin) {
                return true;
            }

            if(logs[startIdx][1] == curStartMin) {
                if (logs[startIdx][2] + 1 > curStartSecond) {
                    return true;
                }

                if (logs[startIdx][2] + 1 == curStartSecond) {
                    if (logs[startIdx][3] >= curStartMSecond) {
                        return true;
                    }
                }
            }
        }

        return true;
    }
}
