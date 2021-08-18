import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4\n" +
            "2 4\n" +
            "1 3\n" +
            "1 2\n" +
            "3 5";

    static int N;
    static boolean[] checked;

    public static void main(String arg[]) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str;
        N = Integer.parseInt(input.readLine());

        PriorityQueue<Lecture> priorityQueue = new PriorityQueue<>(); //수업 우선순위큐
        PriorityQueue<Integer> classQueue = new PriorityQueue<>(); //강의실 우선순위큐, 종료시간이 들어갈 예정
        checked = new boolean[N];

        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            priorityQueue.add(new Lecture(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken())));
        }


        while (!priorityQueue.isEmpty()) { //수업 전부 배정할 때까지
            Lecture lecture = priorityQueue.poll();
            //강의는 시작이 빠른 순으로 정렬된 상태
            //강의실 우선순위큐가 종료시간을 담고, 작은 순으로 정렬됨
            if (classQueue.isEmpty()) { //강의실을 하나도 배정하지 않았다면
                classQueue.add(lecture.endTime);
            }else{
                //강의실의 가장 빠른 종료시간이 강의 시작시간보다 더 앞인 경우
                if(lecture.startTime >= classQueue.peek()) {
                    //강의실의 가장 빠른 종료시간 꺼내고 강의의 종료시간으로 다시 넣음으로서 갱신함
                    classQueue.poll();
                    classQueue.add(lecture.endTime);
                }
                //기존의 강의실에 넣지 못하는 경우
                else {
                    //강의의 끝나는 시간을 강의실큐에 넣음으로서 새 강의실 배정
                    classQueue.add(lecture.endTime);
                }
            }
        }
        //고로 강의실 큐의 사이즈가 강의실 갯수
        System.out.println(classQueue.size());
    }

    static class Lecture implements Comparable<Lecture>{
        public int startTime;
        public int endTime;

        public Lecture(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        //시작시간 오름차순, 같은 경우 끝나는 시간이 빠른 순
        @Override
        public int compareTo(Lecture o) {
            if (this.startTime == o.startTime) {
                return this.endTime - o.endTime;
            } else {
                return this.startTime - o.startTime;
            }
        }
    }

}