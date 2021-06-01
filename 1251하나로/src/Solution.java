import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="4\r\n"
			+ "2\r\n"
			+ "0 0\r\n"
			+ "0 100\r\n"
			+ "1.0\r\n"
			+ "4\r\n"
			+ "0 0 400 400\r\n"
			+ "0 100 0 100\r\n"
			+ "1.0\r\n"
			+ "6\r\n"
			+ "0 0 400 400 1000 2000\r\n"
			+ "0 100 0 100 600 2000\r\n"
			+ "0.3\r\n"
			+ "9\r\n"
			+ "567 5 45674 24 797 29 0 0 0\r\n"
			+ "345352 5464 145346 54764 5875 0 3453 4545 123\r\n"
			+ "0.0005";
	;
	static int INF=Integer.MAX_VALUE;
	static int n;
	static long result;
	static double weight;
	static int[] dp;
	static int[][] data;
	static long[][] distTable;
	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
		StringTokenizer str;
	
		for(int t=1;t<=testcase;t++) {
			n=Integer.parseInt(input.readLine());
			
			boolean[] visited=new boolean[n];
			data=new int[n][2];  //섬들 좌표값 담을 테이블
			distTable=new long[n][n]; //거리 테이블
			
			str=new StringTokenizer(input.readLine());
			for(int i=0;i<n;i++) {
				data[i][0]=Integer.parseInt(str.nextToken());
				
			}
			str=new StringTokenizer(input.readLine());
			for(int i=0;i<n;i++) {
				data[i][1]=Integer.parseInt(str.nextToken());
			}
			
			weight=Double.parseDouble(input.readLine());
			
			//거리 테이블 만듬 
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(i==j)
						continue;
					long distX=Math.abs(data[i][0]-data[j][0]);
					long distY=Math.abs(data[i][1]-data[j][1]);
					distTable[i][j]=distX*distX+distY*distY;
				}
			}
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%");
			for(int i=0;i<n;i++) {
				System.out.println(Arrays.toString(distTable[i]));
			}
			//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%");
			int nodeCnt=0;
			
			result=0;
			
			PriorityQueue<Node> q = new PriorityQueue<>(); //우선순위 큐
            q.add(new Node(0, 0)); // 시작  
        
            while(!q.isEmpty()) { //큐가 빌때까지
                Node now = q.poll(); 
                
                // 이미 확인한 노드는 pass
                if(visited[now.curP]) 
                	continue;
                
                result += now.dist; //온 거리 더하기 
                visited[now.curP] = true; //온 섬 왔다고 기록
                // 모든 노드 확인 완료
                nodeCnt++; //선 하나 그었다
                if(nodeCnt == n)  //n-1개 일 때 그만둘거기 때문에 n되면 탈출 
                	break;
                
               
                for (int i = 0; i < distTable[now.curP].length; i++) {
                    //다음 목적지
                	Node next = new Node(i,distTable[now.curP][i]);
                    //다음 목적지 가보지 않은 곳이라면 큐에 추가
                    if(!visited[next.curP]) {
                        q.add(next);
                    }
               }
			
		
            }
            System.out.println("--------------------------");
			output.append("#"+t+" "+Math.round(result*weight)+"\n");//반올림
		}
		System.out.print(output);  
	}
}

class Node implements Comparable<Node>{
	int curP;
	long dist;

	public Node(int tP,long dist) {
		this.curP=tP;
		this.dist=dist;
	}
	public int compareTo(Node o) { //거리더 짧은순으로 튀어나오게 함
		// TODO Auto-generated method stub
		return Long.compare(this.dist, o.dist); //this.dist < o.dist 이면 -1 역이면 1 
	}
}
		

