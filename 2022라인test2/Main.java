import java.util.*;

public class Main {
    static boolean flag;
    public String solution(int k, String[] dic, String chat) {
        StringBuilder answer = new StringBuilder();

        // 입력은 알파벳 + .
        // 비속어랑 일치하면 단어 #으로 대체
        // .을 제외한 글자들이 비속어랑 일치하면 # 대체
        // . 이 1~k 길이 만큼 대체 가능
        StringTokenizer str = new StringTokenizer(chat);

        answer.append(isSlang(k, dic, str.nextToken()));
        while (str.hasMoreTokens()) {
            answer.append(" ").append(isSlang(k, dic, str.nextToken()));
        }

        return answer.toString();
    }

    // 비속어 검열
    public String isSlang(int k, String[] dic, String word) {

        System.out.println(word);

        flag = false;
        for (int i = 0; i < dic.length; i++) {
            dfs(1, k, 0, 0, dic[i], word);
        }

        if(flag){
            return "#".repeat(word.length());
        }
        return word;
    }

    public void dfs(int cnt, int k, int dicIdx, int wordIdx, String dic, String word) {

        //끝까지 동시에 도달하면
        if (wordIdx == word.length() && dicIdx == dic.length()) {
            flag = true;
            return;
        }
        // 범위 벗어나면
        if (flag || wordIdx >= word.length() || dicIdx >= dic.length()) {
            return;
        }
        System.out.println(dicIdx + " " + wordIdx);

        // word . 이면 넘기거나 대치
        if (word.charAt(wordIdx) == '.') {
            if (cnt < k) {
                dfs(cnt + 1, k, dicIdx + 1, wordIdx, dic, word); // 넘기기
            }
            dfs(1, k, dicIdx + 1, wordIdx + 1, dic, word); // 대치
        } else if (word.charAt(wordIdx) == dic.charAt(dicIdx)) {
            // 같으면 대치
            dfs(1, k, dicIdx + 1, wordIdx + 1, dic, word); // 대치
        }
        return;
    }


}
