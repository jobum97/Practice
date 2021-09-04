import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

//        for (int i = 0; i < board.length; i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }
//        System.out.println("--------------------------------------");

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            ArrayList<Integer> verticalLine = new ArrayList<>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != 0) {
                    verticalLine.add(board[j][i]);
                }
            }
            adjList.add(verticalLine);
        }

//        for (int i = 0; i < adjList.size(); i++) {
//            for (int j = 0; j < adjList.get(i).size(); j++) {
//                System.out.print(i + " " + j + " : " + adjList.get(i).get(j) + " ||");
//            }
//            System.out.println();
//        }


        //같은 종류 연속으로 집으면 사라짐 , 사라진 인형 개수= answer

        Stack<Integer> stack = new Stack<>();

        //인형뽑기
        for (int i = 0; i < moves.length; i++) {
            //move 으로 주어진 라인의 첫번째 인형 뽑기

            //해당 라인 인형이 더이상 존재하지 않는 경우
            if (adjList.get(moves[i] - 1).size() == 0) {
                continue;
            }

            int curTarget = adjList.get(moves[i] - 1).get(0);

            //만약 이미 바구니 같은 인형이 있었다면? 둘다 터지고 answer 카운트
            if (!stack.isEmpty() && stack.peek() == curTarget) {
                stack.pop();
                answer += 2;
            } else {
                stack.push(curTarget);
            }
            adjList.get(moves[i] - 1).remove(0);

        }
        return answer;
    }
}
