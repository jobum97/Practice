import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] input = {"abce", "abcd", "cdx"};
        int n = 2;
        System.out.println(Arrays.toString(solution(input, 1)));

    }


    //n번자 문자 기준 오름차순
    public static String[] solution(String[] strings, int n) {
        PriorityQueue<Str> PQ = new PriorityQueue<>();
        for (int i = 0; i < strings.length; i++) {
            PQ.add(new Str(strings[i], strings[i].charAt(n)));
        }
        String[] answer = new String[strings.length];

        for (int i = 0; i < strings.length; i++) {
            answer[i] = PQ.poll().string;
        }

        return answer;
    }

    static class Str implements Comparable<Str> {
        public String string;
        public char flag;

        public Str(String string, char flag) {
            this.string = string;
            this.flag = flag;
        }

        @Override
        public int compareTo(Str o) {
            if (this.flag == o.flag) {
                return this.string.compareTo(o.string);
            } else {
                return this.flag - o.flag;
            }
        }
    }
}
