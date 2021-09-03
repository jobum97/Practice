
public class Main {
    public static void main(String[] args) {

        String input = "xxxxxxxxxxyyy";

        System.out.println(solution(input));
    }

    public static int solution(String s) {
        int answer = s.length();
        //2개 이상 반복되야 압축 가능 => 전체길이/2 길이 단위 까지 고려해보자
        // 압축 전혀 안되면 문자열길이 그대로

        for (int length = 1; length <= s.length() / 2; length++) {
            int range = length + length;
            int temp = s.length();
            int multiple = 0;
            for (int index = 0; index <= s.length() - range; index += length) {
                String temp1 = s.substring(index, index + length);
                String temp2 = s.substring(index + length, index + range);

                //압축 가능
                if (temp1.equals(temp2)) {
                    multiple++;

                }//압축 안됨
                else {
                    //중복된 것들이 있으면
                    if (multiple > 0) {
                        // 만약 10번 중복되면 1이 아닌 2자리가 추가됨
                        String multiLen = String.valueOf(multiple + 1); //중복된 숫자 길이 구하기 위해
                        temp -= multiple * length - multiLen.length(); //중복된 횟수 * 단위 만큼 줄고 중복된 횟수의 숫자길이 만큼 늘어남
                        multiple = 0;
                    }

                }
            }
            //마지막에 남은 것 처리
            if (multiple > 0) {
                String multiLen = String.valueOf(multiple + 1);
                temp -= multiple * length - multiLen.length();
            }

            //최솟값 갱신
            answer = Math.min(temp, answer);
        }

        return answer;
    }

}
