import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;



public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="2\r\n"
			+ "5\r\n"
			+ "3 2\r\n"
			+ "1 4\r\n"
			+ "4 1\r\n"
			+ "2 3\r\n"
			+ "5 5\r\n"
			+ "8\r\n"
			+ "3 6\r\n"
			+ "5 3\r\n"
			+ "4 2\r\n"
			+ "1 4\r\n"
			+ "6 7\r\n"
			+ "2 5\r\n"
			+ "7 8\r\n"
			+ "8 1";
	
	static int[] data;
	static int selected;

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));
		int t=Integer.parseInt(input.readLine());
		int n,test,spec;
		int temp;
		//
		
		int[] result=new int[t+1];
		 
		for(int testcase=1;testcase<=t;testcase++) {
			n=Integer.parseInt(input.readLine());
			
			data=new int[n+1]; //배열의 index를 서류 등수
			selected=1;
			
			
			for(int i=0;i<n;i++) {
				StringTokenizer str;
				
				str=new StringTokenizer(input.readLine());
				spec=Integer.parseInt(str.nextToken());
				test=Integer.parseInt(str.nextToken()); 
				data[spec]=test;
		
			}
			
			temp=data[1];
			
			for(int i=2;i<n+1;i++) {
				if(temp>data[i]) {
					selected++;
					temp=data[i];
				}
			}
			output.append(selected+"\n");
		}
		
		System.out.print(output);
	}
	

}


