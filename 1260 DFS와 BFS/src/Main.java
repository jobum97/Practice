import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "4 5 1\r\n"
			+ "1 2\r\n"
			+ "1 3\r\n"
			+ "1 4\r\n"
			+ "2 4\r\n"
			+ "3 4";
	
	static ArrayList<ArrayList<Integer>> adj_list;
	static int vertex;
	static Queue<Integer> queue;
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		StringTokenizer str=new StringTokenizer(input.readLine());
		
		vertex=Integer.parseInt(str.nextToken());
		int edge=Integer.parseInt(str.nextToken());
		int start=Integer.parseInt(str.nextToken());

		adj_list=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=vertex;i++) {
			adj_list.add(new ArrayList<Integer>());
		}
				
		queue=new LinkedList<Integer>();
		
		for(int i=0;i<edge;i++) {
			str=new StringTokenizer(input.readLine());
			int s=Integer.parseInt(str.nextToken());
			int e=Integer.parseInt(str.nextToken());
			
			adj_list.get(s).add(e);
			adj_list.get(e).add(s);
		}
		
		//인접리스트 오름차순 정렬
		for(int i=0;i<=vertex;i++) {
			Collections.sort(adj_list.get(i));
		}
		
		
		//인접리스트 출력 
//		for(int i=0;i<=vertex;i++) {
//			System.out.print("#"+i+" ");
//			for(int j=0;j<adj_list.get(i).size();j++) {
//				System.out.print(adj_list.get(i).get(j)+" ");
//			}
//			System.out.println();
//		}
		////////////////////////////////////////////////////////////////
		
		
		boolean[] visited= new boolean[vertex+1]; //방문안했으면 false 햇으면 true
		visited[0]=true;
		
		DFS(start,visited,1);
		output.append("\n");
		
		visited= new boolean[vertex+1]; //방문안했으면 false 햇으면 true
		visited[0]=true;
		BFS(start,visited,1);
		
		System.out.println(output);
	}
	
	public static void DFS(int start, boolean[] visited,int index) {
		visited[start]=true;
		output.append(start+" ");
		
		for(int i=0;i<adj_list.get(start).size();i++) {
			int next=adj_list.get(start).get(i);
			
			if(!visited[next]) { //방문한적없으면
				DFS(next,visited,index+1);
			}
		}

		
	}
	
	public static void BFS(int start, boolean[] visited,int index) {
		
		queue.add(start);
		visited[start]=true;
		
		while(!queue.isEmpty()) {
			int cur=queue.poll();
			output.append(cur+" ");
			
			for(int i=0; i<adj_list.get(cur).size();i++){
				int next=adj_list.get(cur).get(i);			
				if(!visited[next]) { //방문한적없으면
					visited[next]=true;
					queue.add(next);
				}
			}
		}
		//output.append("\n");
	}
}