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
	static String src="10\r\n"
			+ "5\r\n"
			+ "6\r\n"
			+ "7\r\n"
			+ "8\r\n"
			+ "9\r\n"
			+ "10\r\n"
			+ "11\r\n"
			+ "12\r\n"
			+ "13\r\n"
			+ "15";
	
	static int N;
	static int Max=0; 
	
	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));
		N=Integer.parseInt(input.readLine());
		
		Integer[] data=new Integer[N];
		
		for(int i=0;i<N;i++) {
			data[i]=Integer.parseInt(input.readLine());
		}
		Arrays.sort(data,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		
		sol(data,0);
		System.out.println(Max);
	}
	
	public static void sol(Integer[] data,int index) {
		if(index>=N) {
			return;
		}
		if(Max<data[index]*(index+1)) {
			Max=data[index]*(index+1);
		}
		
		sol(data,index+1);
	}
}
