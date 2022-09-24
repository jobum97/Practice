import java.util.Arrays;

public class Main {
    class Solution {
        public int solution(int n, int[] weak, int[] dist) {
            int answer = 0;

            // n은 전체 둘레 n/2가 반대편
            // weak 은 취약점 위치 배열
            // dist 는 각 친구들의 시간당 이동거리
            // 점검시간 1시간 제한
            // 점검 위한 시간 구해야함

            int[] weakDist = new int[weak.length];
            boolean checked[] = new boolean[weak.length];
            for (int i = 0; i < weak.length - 1; i++) {
                weakDist[i] = getDist(weak[i], weak[i + 1], n);
            }
            weakDist[weak.length - 1] = getDist(weak[weak.length - 1], weak[0], n);

            System.out.println(Arrays.toString(weakDist));

            return answer;
        }

        public void dfs(int cnt, int[] dist, int[] weak, int n) {

        }

        public void check(int start, int dist, boolean[] checked) {

        }

        public int getDist(int pos1, int pos2, int n){
            if (pos2 < pos1) {
                return pos2 + n - pos1;
            }
            return pos2 - pos1;
        }
    }
}
