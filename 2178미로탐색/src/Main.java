import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src ="4 6\n" +
			"110110\n" +
			"110110\n" +
			"111111\n" +
			"111101";

	static int[][] map;
	static int N,M,Min_Dist;
	static int[][] checked;
	static int[][] set= {{0,1},{1,0},{0,-1},{-1,0}}; //우,하,좌,상

	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		StringTokenizer str= new StringTokenizer(input.readLine());

		N= Integer.parseInt(str.nextToken());
		M= Integer.parseInt(str.nextToken());
		Min_Dist=Integer.MAX_VALUE;

		map=new int[N][M];
		checked =new int[N][M];

		//1이 이동할 수 있는 칸 0이 이동할 수 없는 칸
		for(int i=0;i<N;i++) {
			map[i]=Stream.of(input.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}

		Sol();
		/*for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(checked[i]));
		}*/
		System.out.println(Min_Dist);
	}

	public static void Sol(){
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0,0));
		checked[0][0]=1;

		while(!queue.isEmpty()){
			Point cur=queue.poll();
			int cur_row= cur.row;
			int cur_col = cur.col;

			//(N,M)에 도착시
			if(cur_row==N-1 && cur_col == M-1){
				Min_Dist=checked[cur_row][cur_col];
				break;
			}

			//우하좌상
			for(int i=0;i<4;i++){
				int next_row=cur_row+set[i][0];
				int next_col=cur_col+set[i][1];

				if(next_row>=0 && next_row<N && next_col>=0 &&next_col<M){ //맵 안에서 움직이는지
					//맵안에서 이동할수 있는 곳인지 + 이미 갔던 곳 아니여야
					if(map[next_row][next_col]==1 && checked[next_row][next_col]==0 ) {
						//걸리는 거리 +1 해서 기록
						checked[next_row][next_col] = checked[cur_row][cur_col]+1;
						queue.add(new Point(next_row, next_col));
					}
				}
			}
		}
	}
}

class Point{
	public int row;
	public int col;

	public Point(int row,int col) {
		this.row = row;
		this.col = col;
	}

}