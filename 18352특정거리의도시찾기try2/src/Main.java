import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="4 4 2 1\r\n"
			+ "1 2\r\n"
			+ "1 3\r\n"
			+ "2 3\r\n"
			+ "2 4";
	
	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));
		
		StringTokenizer str;
		str=new StringTokenizer(input.readLine());
		
		int city=Integer.parseInt(str.nextToken());  //도시의 개수
		int road=Integer.parseInt(str.nextToken()); //도로의 개수
		int length=Integer.parseInt(str.nextToken()); //거리 정보
		int start=Integer.parseInt(str.nextToken()); //출발도시 
		
		int[] distance = new int[3000001];
		
		//2차원 리스트 생성 &초기 정보 입력
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>(); 
		for(int i=0;i<=city;i++) {
			list.add(new ArrayList<Integer>());
			distance[i] = -1;
		}
		
		distance[start]=0;
		
		//도로정보 입력
		for(int i=0;i<road;i++) {
			str=new StringTokenizer(input.readLine());
			list.get(Integer.parseInt(str.nextToken())).add(Integer.parseInt(str.nextToken()));
		}
		
		Queue<Integer> queue =new LinkedList<Integer>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int tmp =queue.poll();
			
			for(int i=0;i<list.get(tmp).size();i++) {
				int next=list.get(tmp).get(i);
				
				//방문한적 없으면
				if(distance[next]==-1) {
					distance[next]=distance[tmp]+1; //출발도시에서 next까지의 거리
					queue.add(next);
				}
			}
		}
		
		boolean check=false;
		for(int i=0;i<=city;i++) {
			if(distance[i]==length) {
				output.append(i+"\n");
				check=true;
			}
		}
		if(!check)
			System.out.println("-1");
		else
			System.out.print(output);
		
		
	}
	
	
}
