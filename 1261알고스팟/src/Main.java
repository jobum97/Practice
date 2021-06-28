import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

class Point implements Comparable<Point> {
	int row; // 행
	int col; // 열
	int cnt; // 벽부신수

	Point(int row, int col, int cnt) {
		this.row = row;
		this.col = col;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return cnt - o.cnt; // 벽 부신 수 적은 순으로 정렬
	}

}

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "3 3\r\n"
			+ "010\r\n"
			+ "111\r\n"
			+ "110";

	//static int INF = Integer.MAX_VALUE;
	static int N, M; // 가로,세로
	static int[][] map; // 지도 data
	//static int[][] costmap; // 가는데 뚫는 비용
	static int[] dirRow = { -1, 0, 1, 0 }; // 위 오른쪽 아래 왼
	static int[] dirCol = { 0, 1, 0, -1 }; // 

	public static void main(String arg[]) throws IOException {
		// input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		StringTokenizer str = new StringTokenizer(input.readLine());

		M = Integer.parseInt(str.nextToken()); //가로 
		N = Integer.parseInt(str.nextToken()); //세로

		map = new int[N+1][M+1];
		
		// 지도 data 입력
		for (int i = 1; i <= N; i++) {
            String line = input.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j - 1));
            }
        }

		System.out.println(BFS());
	}

	public static int BFS() {
		// boolean visited[][]=new boolean[N][M];
		// LinkedList<Point> queue=new LinkedList<>();
		PriorityQueue<Point> queue = new PriorityQueue<>();
		
		//System.out.println(queue.isEmpty());
		queue.offer(new Point(1, 1, 0)); // (0,0) 시작점 큐에 추가
		
		boolean[][] checked = new boolean[N+1][M+1]; // 방문했는지 확인할 배열
		checked[1][1]=true;
	
		
		// 큐가 소진될 때까지 계속한다.
		while (!queue.isEmpty()) {
			Point cur = queue.poll();

//			System.out.println("pop "+ cur.row + " " + cur.col+" "+cur.cnt );
//			for(int i=0;i<N+1;i++) {
//				System.out.println(Arrays.toString(checked[i]));
//			}
			
			if(cur.row==N&&cur.col==M) { //목적지 도착시 벽부신 숫자 리턴
				return cur.cnt;
			}
			
			for (int i = 0; i < 4; i++) { //방향 바꿔가며 반복 아래 오른쪽 위 왼쪽
				
				int row = cur.row + dirRow[i]; 
				int col = cur.col + dirCol[i];
				
				//System.out.println("? " + row + " " + col);
				
				if (0 < row && row <= N && 0 < col && col <= M && !checked[row][col]) { // 맵 안에서의 이동 + 가본적없어야...

					//System.out.println("add " + row + " " + col);
					
					if (map[row][col] == 1) { // 벽이 있는경우
						checked[row][col] = true;	
						queue.offer(new Point(row,col,cur.cnt+1));		
					}
					else if (map[row][col] == 0) { // 벽이 없는 경우
						checked[row][col] = true;	
						queue.offer(new Point(row,col,cur.cnt));
							
					}
					
				}
				
			}
		
		}
		return 0;
	}

}
