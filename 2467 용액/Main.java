import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "4\n" +
            "-100 -2 -1 103";

    static int min, minA, minB;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        //풀이
        int N = Integer.parseInt(input.readLine());
        StringTokenizer str = new StringTokenizer(input.readLine());

        min = Integer.MAX_VALUE;
        minA = 0;
        minB = 0;

        // 가장 0에 가깝게 만드는 2개의 조합 찾기
        // 오름차순 출력

        // 음수들, 양수들 따로 저장해서 조합?
        ArrayList<Integer> minusNums = new ArrayList<>();
        ArrayList<Integer> plusNums = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(str.nextToken());
            if (num >= 0) {
                plusNums.add(num);
            }else{
                minusNums.add(num);
            }
        }
        Collections.sort(plusNums);
        Collections.sort(minusNums, Collections.reverseOrder());

//        System.out.println(Arrays.toString(plusNums.toArray()));
//        System.out.println(Arrays.toString(minusNums.toArray()));

        sol(plusNums, minusNums);
    }

    public static void sol(ArrayList<Integer> plusNums, ArrayList<Integer> minusNums) {
        // 모두 음수이거나
        if (plusNums.size() == 0) {
            System.out.println(minusNums.get(1) + " " + minusNums.get(0));
            return;
        }
        // 모두 양수인 경우
        if (minusNums.size() == 0) {
            System.out.println(plusNums.get(0) + " " + plusNums.get(1));
            return;
        }

        // 음수랑 양수 중간값에서 좌우로 탐색
        for (int i = 0; i < plusNums.size(); i++) {
            find(plusNums.get(i), minusNums);
        }
        System.out.println(minA + " " + minB);
    }

    public static void find(int num, ArrayList<Integer> list) {
        // 이진 탐색으로 탐색 횟수 줄여야함
        int pivot = list.size() / 2;
        int i = 0;
        int j = list.size() - 1;
        int minDiff = Integer.MAX_VALUE;
        while (pivot >= i && pivot <= j) {
            int diff = Math.abs(list.get(pivot) + num);
            if (minDiff > diff) {

            }
        }
            if (min > Math.abs(num + list.get(i))) {
                minA = list.get(i);
                minB = num;
                min = Math.abs(num + list.get(i));
            }
    }

}
