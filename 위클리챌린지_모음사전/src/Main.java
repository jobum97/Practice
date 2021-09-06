import java.util.*;

public class Main {

    public static void main(String[] args) {
        String input = "EIO";

        System.out.println(solution(input));

    }

    //A,E,I,O,U 로 이루어진 1~5자리 단어 word의 사전 순서를 맞춰라
    //첫번째부터 알파벳 바꾸는데 781,156,31,6
    //그냥 list 정렬로 쭉 만들어놓고 읽어보면서 규칙 파악하였음

    public static int solution(String word) {
        int answer = 0;

        HashMap<Character, Integer> set = new HashMap<>();
        set.put('E', 1);
        set.put('I', 2);
        set.put('O', 3);
        set.put('U', 4);

        int moveSet[] = {781, 156, 31, 6, 1};

        //앞자리부터 붙여나간다고 생각
        for (int i = 0; i < word.length(); i++) {
            answer++; //자리수가 늘어날때 A를 우선 붙인다고 생각(index+1)

            //이어지는 자리가 A라면 이미 A이기에 그대로 아닌 경우는 계산필요
            if (word.charAt(i) != 'A') {
                //System.out.println(set.get(word.charAt(i))+" "+moveSet[i]);
                answer += set.get(word.charAt(i)) * moveSet[i];
            }
        }
        return answer;
    }

}
