
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src ="5\r\n"
			+ "-1 -2 -3 -4 -5";
	
	
	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));	
		int n=Integer.parseInt(input.readLine());
		
		int[] data=new int[n+1];
		
		StringTokenizer str=new StringTokenizer(input.readLine());
		
		for(int i=1;i<n+1;i++) {
			data[i]=Integer.parseInt(str.nextToken());
		}
		
		int max=data[1];
		
		for(int i=2;i<=n;i++) {

		    if (data[i-1] > 0 && data[i] + data[i-1] > 0) {
		        data[i] += data[i-1];
		    } 

		    if (max < data[i]) {
		        max = data[i];
		    }

		}


		/*
		for(int i=1;i<n+1;i++) {
			System.out.println(Arrays.toString(table[i]));
		}*/
		
		
		System.out.println(Arrays.toString(data));
		System.out.println(max);
		
		
	}
}