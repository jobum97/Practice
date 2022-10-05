import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        char realBoard[][] = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                realBoard[i][j] = board[i].charAt(j);
            }
        }
        int temp;
        while ((temp = getBlockCnt(m, n, realBoard)) > 0) {
            answer += temp;
        }

        return answer;
    }

    public static int getBlockCnt(int m, int n, char[][] board) {
        boolean checked[][] = new boolean[m][n];

        int answer = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] == ' ') {
                    continue;
                }
                answer += isBlocked(i, j, board, checked);
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(checked[i]));
        }
        clearBlock(board, checked);

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println(answer);

        return answer;
    }
    public static void clearBlock(char[][] board, boolean[][] checked){
        for (int c = 0; c < checked[0].length; c++) {
            for (int r = 0; r < checked.length; r++) {
                if (checked[r][c]) {
                    board[r][c] = ' ';
                }
            }
        }

        for (int c = 0; c < checked[0].length; c++) {
            for (int r = checked.length - 2; r >= 0; r--) {
                if (board[r][c] != ' ') {
                    moveColumDown(board, r, c);
                }
            }
        }
    }

    public static void moveColumDown(char[][] board, int startRow, int col) {
        int cnt = 0;
        for (int i = startRow + 1; i < board.length; i++) {
            if (board[i][col] == ' ') {
                cnt++;
            }
        }

        if (cnt > 0) {
            board[startRow + cnt][col] = board[startRow][col];
            board[startRow][col] = ' ';
        }

    }

    public static int isBlocked(int m,int n, char[][] board, boolean[][] checked){
        int cnt = 0;
        char standard = board[m][n];
        for (int i = m; i < m + 2; i++) {
            for (int j = n; j < n + 2; j++) {
                if (board[i][j] != standard) {
                    return 0;
                }
            }
        }

        for (int i = m; i < m + 2; i++) {
            for (int j = n; j < n + 2; j++) {
                if (!checked[i][j]) {
                    checked[i][j] = true;
                    cnt++;
                }

            }
        }

        return cnt;
    }



}
