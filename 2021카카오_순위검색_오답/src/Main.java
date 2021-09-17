import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210",
                "python frontend senior chicken 150", "cpp backend senior pizza 260",
                "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250", "- and backend and senior and - 150",
                "- and - and - and chicken 100", "- and - and - and - 150"};

        System.out.println(Arrays.toString(solution(info, query)));

    }
    //info - 개발언어, 직군, 경력, 소울푸드, 점수
    // query - 조건 X = "개발언어 and 직군 and 경력 and 소울푸드 X(점수)" 형식
    // 조건 중 - 은 고려X
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int size = info.length;

        String[][] data = new String[size][5];
        for (int i = 0; i < size; i++) {
            data[i] = info[i].split(" ");
        }

        Arrays.sort(data, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o2[4]) - Integer.parseInt(o1[4]);
            }
        });

        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(data[i]));
        }
        System.out.println("-----------------------------------");

        for (int i = 0; i < query.length; i++) {
            String temp = query[i].replace(" and", "");
            String[] condition = temp.split(" ");
            System.out.println(Arrays.toString(condition));

            int score = Integer.parseInt(condition[4]);
            for (int j = 0; j < data.length; j++) {
                if (Integer.parseInt(data[j][4]) < score) {
                    break;
                }
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    if (condition[k].equals("-")) {
                        continue;
                    }
                    if (!condition[k].equals(data[j][k])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer[i]++;
                }
            }

        }

        return answer;
    }
}
