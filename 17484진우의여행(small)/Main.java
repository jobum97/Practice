import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
    static String src = "6 4\n" +
            "5 8 5 1\n" +
            "3 5 8 4\n" +
            "9 77 65 5\n" +
            "2 1 5 2\n" +
            "5 98 1 5\n" +
            "4 95 67 58";
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static boolean[] checked;

    public void solution() throws Exception{
        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        int board[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        int moveHistory[][][] = new int[N][M][3];
        int moveSet[][] = {{1, -1}, {1, 0}, {1, 1}};

        // 시작 지점 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i == 0) {
                        moveHistory[i][j][k] = board[i][j];
                    }else{
                        moveHistory[i][j][k] = 100000;
                    }
                }
            }
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                for (int beforeDir = 0; beforeDir < 3; beforeDir++) {
                    for (int curDir = 0; curDir < 3; curDir++) {
                        //이전의 방향 제외하고 경우의 수 계산
                        if(beforeDir == curDir){
                            continue;
                        }
                        int beforeRow = row - moveSet[beforeDir][0];
                        int beforeCol = col - moveSet[beforeDir][1];
                        if (beforeCol < 0 || beforeRow < 0 || beforeRow >= N || beforeCol >= M) {
                            continue;
                        }

                        moveHistory[row][col][curDir] = Math.min(moveHistory[row][col][curDir], moveHistory[beforeRow][beforeCol][beforeDir] + board[row][col]);
                    }
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(moveHistory[i][j][0]+" | ");
//            }
//            System.out.println();
//        }


        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                answer = Math.min(answer, moveHistory[N - 1][i][j]);
//                System.out.println(moveHistory[N - 1][i][j]);
            }
        }
        System.out.println(answer);
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
