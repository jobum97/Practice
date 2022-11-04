import javax.sound.midi.Soundbank;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 1, 0, 0}, {0, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 1, 0, 0, 1, 0, 0}, {0, 0, 0, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 1}}, new int[]{0, 0}, new int[]{6, 3}));
    }
}


class Solution {

    public int solution(int[][] M, int[] S, int[] D) {
        int answer = -1;
        int n = M.length;
        int m = M[0].length;
        int moveSet[][] = {{-1,0},{1,0},{0,1},{0,-1}};
        boolean[][] checked = new boolean[n][m];

        System.out.println(n+" "+m);

        PriorityQueue<Coord> pq = new PriorityQueue<>();
        pq.add(new Coord(S[0],S[1],0));
        checked[S[0]][S[1]] = true;

        while(!pq.isEmpty()){
            Coord cur = pq.poll();
            System.out.println(cur.row + " " + cur.col);
            if(cur.row == D[1] && cur.col == D[0]){
                answer = cur.dist;
                break;
            }

            for(int dir=0; dir<moveSet.length;dir++){
                int nextRow = cur.row +moveSet[dir][0];
                int nextCol = cur.col +moveSet[dir][1];

                if(nextCol<0 || nextRow < 0 || nextCol>=m || nextRow >=n){
                    continue;
                }
                System.out.println("-" + nextRow + " " + nextCol);
                if(!checked[nextRow][nextCol] && M[nextRow][nextCol] ==0){
                    checked[nextRow][nextCol] = true;
                    pq.add(new Coord(nextRow,nextCol,cur.dist+1));
                }
            }

        }

        return answer;
    }

    public class Coord implements Comparable<Coord>{
        int row;
        int col;
        int dist;
        Coord(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

        public int compareTo(Coord o){
            return this.dist - o.dist;
        }
    }
}


