import java.util.Arrays;
import java.util.Comparator;

public class Main {
    class Solution {
        public boolean solution(int[][] key, int[][] lock) {
            boolean answer = true;

            // 2차원 배열 회전 이동 하여 큰 2차원배열의 빈곳에 채울수 있는지?
            for(int i=0;i<4;i++){
                if(isValid(key,lock)){
                    return true;
                }
                key = rotate(key);
            }
            return false;
        }

        public boolean isValid(int[][] key, int[][] lock){
            int N = lock.length;
            int M = key.length;
            int cnt = 0;
            // 채워야하는 칸 수 세우두기
            for(int startRow=0;startRow<N;startRow++){
                for(int startCol=0;startCol<N;startCol++){
                    if(lock[startRow][startCol]==0){
                        cnt++;
                    }
                }
            }
            int tempCnt;
            // lock 전부 채우기만 하면됨
            // 좌상단에서 일부분만 겹치게 할 수있는 케이스 고려
            for(int startRow=-M+1;startRow<N;startRow++){
                for(int startCol=-M+1;startCol<N;startCol++){
                    tempCnt = cnt;

                    loop:
                    for(int findRow=0;findRow<M;findRow++){
                        for(int findCol=0;findCol<M;findCol++){

                            int row = startRow + findRow;
                            int col = startCol + findCol;

                            // 범위 벗어나는 부분 무시
                            if(row>=N || col>=N || row<0 || col <0){
                                continue;
                            }
                            // 돌기 겹치는 부분 발생시 거르기
                            if(key[findRow][findCol] == 1 && lock[row][col] == 1 ){
                                break loop;
                            }

                            // 맞는 경우
                            if(key[findRow][findCol] == 1 && lock[row][col] == 0 ){
                                tempCnt--;
                            }

                        }
                    }
                    if(tempCnt == 0){
                        return true;
                    }
                }
            }
            return false;
        }

        public int[][] rotate(int[][] key){
            int M = key.length;
            int[][] rotateKey = new int[M][M];
            for(int row=0;row<M;row++){
                for(int col=0;col<M;col++){
                    rotateKey[col][M-row-1] = key[row][col];
                }
            }

            return rotateKey;
        }
    }
}
