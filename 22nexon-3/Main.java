import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        list1.add(3);
        list2.add(2);
        list2.add(2);
        list2.add(4);
        System.out.println(getMinimumHealth(list1, list2, 2));
    }


    // 찰리는 알렉스 이기려함
    // m 개의 플레이어 잇음 n 개의 레벨
    //각 레벨은 이전플레이어 포함하여 새로운 플레이어 소개함
    //
    public static long getMinimumHealth(List<Integer> initial_players, List<Integer> new_players, int rank) {
        // Write your code here

        int answer = 0;
        Collections.sort(initial_players);
        answer += initial_players.get(initial_players.size() - rank);

        for (int i = 0; i < new_players.size(); i++) {
            insert(initial_players, new_players.get(i));
            answer += initial_players.get(initial_players.size() - rank);
            System.out.println(Arrays.toString(new List[]{initial_players}));
        }
        return answer;
    }

    public static void insert(List<Integer> initial_players, int strength) {
        int low = 0;
        int high = initial_players.size() - 1;

        int mid=0;

        while(low <= high) {
            mid = (low + high) / 2;
            if (initial_players.get(mid) >= strength) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (strength > initial_players.get(mid)) {
            initial_players.add(mid+1, strength);
        }else{
            initial_players.add(mid, strength);
        }

        //System.out.println(Arrays.toString(new List[]{initial_players}));
    }
}
