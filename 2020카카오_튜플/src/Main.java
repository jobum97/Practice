import java.util.*;

public class Main {

    public static void main(String[] args) {
        String input = "{{20,111},{111}}";

        System.out.println(Arrays.toString(solution(input)));

    }

    //튜플
    //중복된 원소가 있을 수 있음
    //원소의 순서 다르면 다른 튜플
    // 튜플의 원소 개수는 유한

    public static int[] solution(String s) {

        //주어진 입력 쓰기 좋게 손질
        String input = s.substring(1, s.length() - 1);

        ArrayList<String> data = new ArrayList<>();

        String temp = "";
        for (int i = 1; i < input.length(); ++i) {
            if (input.charAt(i) == '}') {
                data.add(temp);
                temp = "";
                i+=2;
            } else {
                temp += input.charAt(i);
            }
        }

        // 문자열 길이 오름차순으로 정렬
        data.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        // 1개인것 무조건 첫번째 2개짜리는 1개인 요소 제외한 요소가 2번째,,, 반복하면 순서 알수 있음

        Set<Integer> set = new HashSet<>();
        int[] answer = new int[data.get(data.size() - 1).split(",").length];
        int index = 0;
        for (int i = 0; i < data.size(); i++) {

            //크기 작은 input 부터 배열만듬
            int[] intArray = Arrays.stream(data.get(i).split(",")).mapToInt(Integer::parseInt).toArray();
            //배열 요소 검사하면서 set에 없으면 정답에 추가함
            for (int j = 0; j < intArray.length; j++) {
                if (!set.contains(intArray[j])) {
                    set.add(intArray[j]);
                    answer[index] = intArray[j];
                    index++;
                }
            }
        }

        return answer;
    }
}
