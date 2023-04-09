import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "8\n" +
            "0 0 0 0 0 0 0 0\n" +
            "8\n" +
            "1 2\n" +
            "1 3\n" +
            "1 4\n" +
            "1 5\n" +
            "2 2\n" +
            "2 3\n" +
            "2 4\n" +
            "2 5\n";
    static final int FEMALE =2, MALE = 1;
    public static void main(String[] args) throws IOException {
        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        int switchNum = Integer.parseInt(input.readLine());
        boolean[] switchStatus = new boolean[switchNum + 1];

        StringTokenizer str = new StringTokenizer(input.readLine());
        for (int i = 1; i <= switchNum; i++) {
            if (Integer.parseInt(str.nextToken()) == 1) {
                switchStatus[i] = true;
            }
        }
        int studentNum = Integer.parseInt(input.readLine());
        for (int i = 0; i < studentNum; i++) {
            str = new StringTokenizer(input.readLine());
            int gender = Integer.parseInt(str.nextToken());
            int num = Integer.parseInt(str.nextToken());
            action(switchStatus, gender, num);
        }

        print(switchStatus);

    }
    public static void print(boolean[] switchStatus){
        output = new StringBuilder();
        int line = 0;
        for (int i = 1; i < switchStatus.length; i++) {
            if (switchStatus[i]) {
                output.append("1 ");
            }else{
                output.append("0 ");
            }
            line++;
            if (line == 20) {
                line = 0;
                output.append("\n");
            }
        }
        System.out.println(output);
    }

    public static void action(boolean[] switchStatus, int gender, int num) {
        // 남학생 - 스위치 번호가 받은 수의 배수면 상태 전환
        // 여학생 - 받은 번호 좌우 대칭이면서 가장 많은 스위치 구간 찾아 모두 상태 전환

        if (gender == MALE) {
            for (int i = num; i < switchStatus.length; i += num) {
                switchStatus[i] = !switchStatus[i];
            }
        } else if (gender == FEMALE) {
            int size = switchStatus.length - 1;
            int shortestDist = Math.min(size - num, num - 1);

            int changeRange = 0;
            for (int i = 0; i <= shortestDist; i++) {
                if (switchStatus[num + i] == switchStatus[num - i]) {
                    changeRange = i;
                }else{
                    break;
                }
            }
            if (changeRange > 0) {
                for (int i = 1; i <= changeRange; i++) {
                    switchStatus[num + i] = !switchStatus[num + i];
                    switchStatus[num - i] = !switchStatus[num - i];
                }
            }
            switchStatus[num] = !switchStatus[num];
        }

    }
}
