import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input;
    static StringBuilder output;
    static String src = "4\n" +
            "RDD\n" +
            "4\n" +
            "[1,2,3,4]\n" +
            "DD\n" +
            "1\n" +
            "[42]\n" +
            "RDDRD\n" +
            "6\n" +
            "[1,1,2,3,5,8]\n" +
            "R\n" +
            "0\n" +
            "[]";

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        output = new StringBuilder();

        int tc = Integer.parseInt(input.readLine());

        for (int testcase = 0; testcase < tc; testcase++) {
            String orders = input.readLine();
            boolean isValid = true;
            int n = Integer.parseInt(input.readLine());
            Deque<Integer> data = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();
            String temp = input.readLine();
            temp = temp.substring(1, temp.length() - 1);
            String[] temps = temp.split(",");
            for (int i = 0; i < n; i++) {
                data.add(Integer.parseInt(temps[i]));
            }
            int rCnt = 0;
            for (int i = 0; i < orders.length(); i++) {
                //System.out.println("==========" + data.toString() + "============");
                if (orders.charAt(i) == 'R') {
                    rCnt++;

                } else if (orders.charAt(i) == 'D') {
                    if (data.isEmpty()) {
                        isValid = false;
                        break;
                    } else {
                        //짝수
                        if (rCnt % 2 == 0) {
                            data.pollFirst();
                        } //홀수
                        else {
                            data.pollLast();
                        }
                    }
                }
            }


            if (isValid) {
                int s = data.size();
                // R의 개수가 홀수이면 뒤집기
                if (rCnt % 2 == 1) {
                    for (int i = 0; i < s; i++) {
                        stack.push(data.poll());
                    }
                    for (int i = 0; i < s; i++) {
                        data.add(stack.pop());
                    }
                }
                output.append("[");
                for (int i = 0; i < s - 1; i++) {
                    output.append(data.poll() + ",");
                }
                if (s > 0) {
                    output.append(data.poll() + "]\n");
                } else {
                    output.append("]\n");
                }


            } else {
                output.append("error\n");
            }

        }
        System.out.print(output);
    }




}
