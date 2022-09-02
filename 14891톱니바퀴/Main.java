import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "10010011\n" +
            "01010011\n" +
            "11100011\n" +
            "01010101\n" +
            "8\n" +
            "1 1\n" +
            "2 1\n" +
            "3 1\n" +
            "4 1\n" +
            "1 -1\n" +
            "2 -1\n" +
            "3 -1\n" +
            "4 -1";

    static ArrayList<LinkedList<Boolean>> gearStatus;
    static int K;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        //풀이
        gearStatus = new ArrayList<>();
        gearStatus.add(new LinkedList<>());
        for (int i = 1; i <= 4; i++) {
            gearStatus.add(new LinkedList<>());
            String line = input.readLine();
            for (int j = 0; j < 8; j++) {
                if (line.charAt(j) == '1') {
                    gearStatus.get(i).add(true);
                }else{
                    gearStatus.get(i).add(false);
                }
            }
        }

        //printGears();
        K = Integer.parseInt(input.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer str = new StringTokenizer(input.readLine());
            int gearNum = Integer.parseInt(str.nextToken());
            int dir = Integer.parseInt(str.nextToken());
            rotate(gearNum, dir);
            //printGears();
        }
        System.out.println(score());
    }
    public static void printGears(){
        for (int j = 1; j <= 4; j++) {
            for (int k = 0; k < 8; k++) {
                if(gearStatus.get(j).get(k)){
                    System.out.print(1+" ");
                }else{
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }

    public static int score() {
        int sum = 0;
        int v = 1;
        for (int i = 1; i <= 4; i++) {
            if(gearStatus.get(i).get(0)) {
                sum += v;
            }
            v *= 2;
        }
        return sum;
    }

    public static void rotate(int gearNum, int dir) {
        // dir == 1 시계 -1 반시계

        LinkedList<Order> list = new LinkedList<>();

        int tempDir = dir;
        for (int i = 0; i < 4; i++) {
            if (magnetism(gearNum - 1 - i, gearNum - i)) {
                list.add(new Order(gearNum - 1 - i, tempDir *= -1));
            }else{
                break;
            }
        }

        tempDir = dir;
        for (int i = 0; i < 4; i++) {
            if (magnetism(gearNum + i, gearNum + 1 + i)) {
                list.add(new Order(gearNum + 1 + i, tempDir *= -1));
            } else {
                break;
            }
        }

        while (!list.isEmpty()){
            Order cur = list.pollLast();
            rotateGear(cur.num, cur.dir);
        }
        rotateGear(gearNum, dir);
    }

    public static void rotateGear(int gearNum, int dir) {

        if (dir == -1) {
           // System.out.println(gearNum+ "  반시계 회전");
            gearStatus.get(gearNum).add(gearStatus.get(gearNum).pollFirst());// 반시계
        }else{
            //System.out.println(gearNum+ "  시계 회전");
            gearStatus.get(gearNum).addFirst(gearStatus.get(gearNum).pollLast());// 시계
        }
    }

    // 톱니바퀴가 서로를 미냐?
    public static boolean magnetism(int g1, int g2) {
        //범위 벗어나면
        if (g1 <= 0 || g2 > 4) {
            return false;
        }
        // XOR 연산 => true == 다르다는 것 인접한 것 땡김
        if (gearStatus.get(g1).get(2) ^ gearStatus.get(g2).get(6)) {
            return true;
        }
        // 같으면 아무것도 하지 않음
        return false;
    }

    public static class Order{
        int num;
        int dir;

        public Order(int num, int dir) {
            this.num = num;
            this.dir = dir;
        }
    }
}
