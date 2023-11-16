import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static String src = "2\n" +
            "15\n" +
            "1 2 3 3 1 3 2 4 1 1 3 1 3 3 1\n" +
            "18\n" +
            "1 2 3 1 2 3 1 2 3 3 3 3 2 2 2 1 1 1";
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static boolean[] checked;
    static int[][] moveSet = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

    public void solution() throws Exception{
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        int testCase = Integer.parseInt(input.readLine());
        StringBuilder result = new StringBuilder();
        // 한 팀에 6명, 팀 점수는 상위 4명의 점수 합
        // 자격을 갖춘 팀만 점수 부여
        // 가장 낮은 점수를 얻는 팀이 우승
        // 동률 시 5번째 주자가 가장 빠른 팀이 우승
        // 모든 선수들의 등수 주어질때 우승팀 찾기
        for (int i = 0; i < testCase; i++) {
            int totalMan = Integer.parseInt(input.readLine());
            int[] teamNumbers = new int[totalMan];
            int[] teamTotalCount = new int[201];
            int[] teamCurrentCount = new int[201];

            StringTokenizer str = new StringTokenizer(input.readLine());
            int maxTeamNumber = 0;
            for (int manNumber = 0; manNumber < totalMan; manNumber++) {
                int teamNumber = Integer.parseInt(str.nextToken());
                // 팀별 인원 카운팅 => 유효한 팀 걸러내기
                teamTotalCount[teamNumber]++;
                teamNumbers[manNumber] = teamNumber;
                maxTeamNumber = Math.max(maxTeamNumber, teamNumber);
            }
            maxTeamNumber++;

            int[][] teamScore = new int[maxTeamNumber][6];
            for (int j = 0; j < maxTeamNumber; j++) {
                teamScore[j][0] = j;
            }

            // 유효한 팀원들 기준으로 점수 부여하면서 점수 카운팅
            int score = 1;
            for (int manNumber = 0; manNumber < totalMan; manNumber++) {
                int teamNumber = teamNumbers[manNumber];
                if (teamTotalCount[teamNumber] >= 6) {
                    if (teamCurrentCount[teamNumber] < 5) {
                        teamCurrentCount[teamNumber]++;
                        teamScore[teamNumber][teamCurrentCount[teamNumber]] += score;
                    }
                    score += 1;
                }
            }

            Arrays.sort(teamScore, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int o1Score = 0, o2Score = 0;
                    for (int j = 1; j <= 4; j++) {
                        o1Score += o1[j];
                        o2Score += o2[j];
                    }
                    if (o1Score == o2Score) {
                        return o1[5] - o2[5];
                    }else{
                        return o1Score - o2Score;
                    }
                }
            });

            for (int j = 0; j < maxTeamNumber; j++) {
                if (teamScore[j][1] != 0) {
                    result.append(teamScore[j][0]).append("\n");
                    break;
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
