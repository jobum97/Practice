import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="6 150\r\n"
			+ "0 100 30\r\n"
			+ "40 50 10\r\n"
			+ "0 75 1\r\n"
			+ "75 150 2\r\n"
			+ "100 151 10\r\n"
			+ "0 150 10";
	
	static int n,d;
	static int[] history;
	static road[] roads;
	
	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));
		
		StringTokenizer str;
		str=new StringTokenizer(input.readLine());
		n=Integer.parseInt(str.nextToken());
		d=Integer.parseInt(str.nextToken());
		
		history=new int[d+1];
		roads=new road[n];
		
		Arrays.fill(history, Integer.MAX_VALUE);
		
		for(int i=0;i<n;i++) {
			str=new StringTokenizer(input.readLine());
			int start=Integer.parseInt(str.nextToken());
			int end=Integer.parseInt(str.nextToken());
			int distance=Integer.parseInt(str.nextToken());
			
			roads[i]=new road(start,end,distance);
		}
		
		Arrays.sort(roads); //시작점 오름차순

//		for(int i=0;i<n;i++) {
//			System.out.println(roads[i].start+" "+roads[i].end+" "+roads[i].distance);
//		}

		int curDist=0;
		int curIndex=0;
		history[0]=0;
		
		while(curDist<d) {
			while(curIndex<n) {
				if(roads[curIndex].start!=curDist) { //도로의 시작점이 현재의 위치 아니면 거름
					break;
				}
				//지름길 진입하는 경우	
				if(roads[curIndex].end<=d) { //지름길의 끝이 도착점보다 작거나 같아야함
					int goShortcut = history[curDist] + roads[curIndex].distance; //지름길가면 이전까지의 거리+지름길 거리 
					if(goShortcut < history[roads[curIndex].end]) { //이 지름길로 간 거리가 이전까지의 기록보다 빠르다면 갱신
						history[roads[curIndex].end] = goShortcut;
					}
				}
				curIndex++;
			}
			
			if(history[curDist]+1<history[curDist+1]) { //현재까지의 기록+1<현재+1 의 기록이면 잘못된 지름길타서 오히려 늘어난상황
				history[curDist+1]=history[curDist]+1; //바로 잡아준다
			}
			curDist++; 
		}
		
		
		//System.out.println(Arrays.toString(history));
		System.out.println(history[d]);
	}
}

class road implements Comparable<road>{
	int start;
	int end;
	int distance;
	
	road(int start, int end, int distance){
		this.start=start;
		this.end=end;
		this.distance=distance;
	}

	@Override
	public int compareTo(road o) { //o의 시작점이 크면 -1 (그대로) 작으면 자리바꿔야
		if(this.start<o.start) {
			return -1;
		}
		return 1;
	}
	
	
}
