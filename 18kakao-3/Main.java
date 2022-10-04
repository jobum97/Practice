import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
    }
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        ArrayList<String> queue = new ArrayList<>();

        for (int i = 0; i < cities.length; i++) {
            String curStr = cities[i].toLowerCase();
            // 캐시에 잇으면 +1 하고 기존 제거 없으면 +5
            if (queue.contains(curStr)) {
                answer += 1;
                queue.remove(curStr);
            }else{
                answer += 5;
            }
            queue.add(curStr);

            // 넘치면 제거
            if (queue.size() > cacheSize && queue.size() > 0) {
                queue.remove(0);
            }

        }


        return answer;
    }
}
