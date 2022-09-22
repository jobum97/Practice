import java.util.*;
public class Main {

    class Solution {
        public int solution(String s) {
            int answer = s.length();
            // 자르는 길이 전체 길이의 절반 이하 일것
            int cutLength = s.length()/2;

            // 자르는 길이 0 보다 크면 츄라이
            while(cutLength > 0){
                // 잘라보면서 최소 갱신
                answer = Math.min(answer, getShortest(s, cutLength));
                cutLength--;
            }

            return answer;
        }

        // 잘랐을 때 결과 반환하는 메서드
        public int getShortest(String s, int cutLength){
            String beforeStr=s.substring(0,cutLength);
            String curStr;
            int idx =cutLength;
            int answer = s.length();
            int seq =0;
            while(idx+cutLength <= s.length()){
                curStr = s.substring(idx, idx+cutLength);
                // 이전 문자열과 동일하면 중복도+1
                if(curStr.equals(beforeStr)){
                    seq++;
                }else{
                    // 이전 문자열과 다른데 중복도가 1이상이면 압축하는 결과 반영
                    if(seq>0){
                        answer= answer - seq*cutLength + Integer.toString(seq+1).length();
                        seq =0;
                    }
                    beforeStr = s.substring(idx, idx+cutLength);
                }
                idx+= cutLength;
            }
            // 잔여물 처리
            if(seq > 0){
                answer -= seq*cutLength;
                answer+= Integer.toString(seq+1).length();
                seq =0;
            }

            return answer;
        }
    }
}
