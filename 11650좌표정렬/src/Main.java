import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

//1초 256MB

public class Main {
	static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static String src="5\r\n"
			+ "3 4\r\n"
			+ "1 1\r\n"
			+ "1 -1\r\n"
			+ "2 2\r\n"
			+ "3 3";
	public static void main(String args[])throws IOException {
		input= new BufferedReader(new InputStreamReader(System.in));
		//input=new BufferedReader(new StringReader(src));		
		int n=Integer.parseInt(input.readLine());
		StringTokenizer str;
		List<Point> list=new ArrayList<Point>();
		for(int i=0;i<n;i++) {
			str=new StringTokenizer(input.readLine());
			list.add(new Point(Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken())));
		}
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			output.append(list.get(i).x+" "+list.get(i).y+"\n");
		}
		
		
		System.out.println(output);
	}
}
class Point implements Comparable<Point>{
	Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	int x,y;

	@Override
	public int compareTo(Point p) {
		if(this.x>p.x) {
			return 1;
		}else if(this.x==p.x) {
			if(this.y>p.y) {
				return 1;
			}
		}
		return -1;
	}
	
}
