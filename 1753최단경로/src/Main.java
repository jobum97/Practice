import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int end, weight;
	Node(int end,int weight){
		this.end=end;
		this.weight=weight;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.weight-o.weight;
	}
	
}

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="5 6\r\n"
			+ "1\r\n"
			+ "5 1 1\r\n"
			+ "1 2 2\r\n"
			+ "1 3 3\r\n"
			+ "2 3 4\r\n"
			+ "2 4 5\r\n"
			+ "3 4 6";
	;
	static int INF=Integer.MAX_VALUE;
	
	static int V,E,S;
	static int[] dp;
	static List<Node>[] list;
	
	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));
		
		StringTokenizer str;
		str=new StringTokenizer(input.readLine());
		V=Integer.parseInt(str.nextToken()); //정점
		E=Integer.parseInt(str.nextToken()); //간선 개수
		S=Integer.parseInt(input.readLine()); //시작점
		
		list= new ArrayList[V+1];
		dp=new int[V+1];
		Arrays.fill(dp, INF);
		
		
		for(int i=1;i<=V;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			str=new StringTokenizer(input.readLine());
			int start=Integer.parseInt(str.nextToken());
			int end=Integer.parseInt(str.nextToken());
			int weight=Integer.parseInt(str.nextToken());
			list[start].add(new Node(end,weight));
		}
		
		dijkstra(S);
		for(int i=1;i<=V;i++) {
			if(dp[i]==INF) {
				output.append("INF\n");
			}else {
				output.append(dp[i]+"\n");
			}
		}
		System.out.print(output);
	}
	
	public static void dijkstra(int start){
	       PriorityQueue<Node> queue = new PriorityQueue<>();
	       boolean[] check = new boolean[V + 1];
	       queue.add(new Node(start, 0));
	       dp[start] = 0;

	       while(!queue.isEmpty()){
	           Node curNode = queue.poll();
	           int cur = curNode.end;

	           if(check[cur] == true) continue;
	           check[cur] = true;

	           for(Node node : list[cur]){
	               if(dp[node.end] > dp[cur] + node.weight){
	                   dp[node.end] = dp[cur] + node.weight;
	                   queue.add(new Node(node.end, dp[node.end]));
	               }
	           }
	       }
	    }
}
		