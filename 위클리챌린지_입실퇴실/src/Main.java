import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] enter = {1,4,2,3};
        int[] leave = {2,1,3,4};

        System.out.println(Arrays.toString(solution(enter, leave)));
    }

    public static int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];

        ArrayList<Integer> roomPeople = new ArrayList<>();
        ArrayList<ArrayList<Integer>> meetLog = new ArrayList<>();
        for (int i = 0; i <= enter.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            meetLog.add(temp);
        }

        int e = 0;
        int l = 0;
        while (l != leave.length) {
            System.out.println(e + " " + l+" "+ roomPeople.size());
            //퇴실예정인 사람이 방에 있으면 우선적으로 내보냄
            if (l < leave.length && roomPeople.size() > 0) {
                if (roomPeople.contains(leave[l])) {
                    roomPeople.remove(roomPeople.indexOf(leave[l]));
                    l++;
                    continue;
                }
            }

            //입실 예정인 사람있으면 입실 ,
            if (e < enter.length) {
                roomPeople.add(enter[e]);
                for (int i = 0; i < roomPeople.size(); i++) {
                    System.out.println("log " + enter[e] + " " + roomPeople.get(i));
                    //자기 자신은 만난사람으로 카운트 안함
                    if (enter[e] == roomPeople.get(i)) {
                        continue;
                    }
                    meetLog.get(enter[e]).add(roomPeople.get(i));
                    meetLog.get(roomPeople.get(i)).add(enter[e]);
                }
                e++;
            }

        }

        for (int i = 0; i < meetLog.size(); i++) {
            System.out.print("#"+i+" ");
            for (int j = 0; j < meetLog.get(i).size(); j++) {
                System.out.print(meetLog.get(i).get(j) + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = meetLog.get(i + 1).size();
        }

        return answer;
    }

}
