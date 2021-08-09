import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "pipikachup";
	
	static int index;
	static char[] data;
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		
		data = input.readLine().toCharArray();
		index =0;
		
		while(wordToken()) {
			//System.out.println(index);
			if(index>=data.length) {
				System.out.println("YES");
				break;
			}
		}
		if(index<data.length) {
			System.out.println("NO");
		}
	
	}
	
	public static boolean wordToken() {
		
		if((index+1<data.length) && data[index]=='p' && data[index+1]=='i') {
			index+=2;
			return true;
		}
		if((index+1<data.length) && data[index]=='k' && data[index+1]=='a') {
			index+=2;
			return true;
		}
		if((index+2<data.length) && data[index]=='c' && data[index+1]=='h' && data[index+2]=='u') {
			index+=3;	
			return true;
		}
		return false;
	}
	
}
