import java.util.*;


public class Main {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));

    }
    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        // 9시부터 n회 t분 간격으로 역에 도착 최대 m명 탑승할 수 잇음
        // 대기 순서대로 태우고 출발
        // 모두 23:59분에 귀가 => 다음날 타는 일 없음


        int crewTable[][] = new int[timetable.length][2];

        for (int i = 0; i < timetable.length; i++) {
            crewTable[i][0] = Integer.parseInt(timetable[i].substring(0, 2));
            crewTable[i][1] = Integer.parseInt(timetable[i].substring(3, 5));
        }

        Arrays.sort(crewTable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < crewTable.length; i++) {
            System.out.println(Arrays.toString(crewTable[i]));
        }

        int curHour = 9;
        int curMin = 0;
        int crewCursor = 0;
        // 언제 타야하냐...

        // 마지막 차 꽉 차지 않는 경우 => 마지막 차 시간
        // 마지막 차 꽉 차는 경우 => 마지막 차의 마지막 사람보다 -1
        int carNum;
        for (carNum = 0; carNum < n; carNum++) {
            int cnt = 0;

            // 최대한 차에 태운다
            for (int j = 0; j < m; j++) {

                if (crewCursor >= crewTable.length) {
                    break;
                }

                // 탈사람이 잇으면
                if (crewTable[crewCursor][0] < curHour || (crewTable[crewCursor][0] == curHour && crewTable[crewCursor][1] <= curMin)) {
                    crewCursor++;
                    cnt++;
                }
            }
            // 마지막차가 만차라면 => 마지막 차의 마지막 사람보다 빨라야한
            if (carNum == n - 1 && cnt == m) {
                if (crewCursor > 0) {
                    answer = transformation(crewTable[crewCursor - 1][0], crewTable[crewCursor - 1][1] - 1);
                }else{
                    answer = transformation(crewTable[crewCursor][0], crewTable[crewCursor][1] - 1);
                }
            }else{
                //아니라면 막차시간
                answer = transformation(curHour, curMin);
            }

            curHour += t / 60;
            curMin += t % 60;
        }

        return answer;
    }

    public static String transformation(int hour, int min) {
        if (min < 0) {
            hour--;
            min += 60;
        }

        String Hour;
        if (hour < 10) {
            Hour = "0" + hour;
        }else {
            Hour = String.valueOf(hour);
        }

        String Min;
        if (min == 0) {
            Min = "00";
        } else if (min < 10) {
            Min = "0" + min;
        }else{
            Min = String.valueOf(min);
        }


        return Hour + ":" + Min;
    }

}
