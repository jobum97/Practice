import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "2";
	
	public static boolean is666(String input) {
		return input.contains("666");
	}

	public static void main(String args[]) throws IOException {
		input= new BufferedReader(new InputStreamReader(System.in));
		//input = new BufferedReader(new StringReader(src));
		int index=Integer.parseInt(input.readLine());
		
		int num=666;
		
		for(int i=0;i<index;) {
			if(is666(Integer.toString(num))) {
				i++;
			}
			num++;
		}
		System.out.println(num-1);
		
		
	}
}
