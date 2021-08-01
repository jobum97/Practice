import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="55-50+40+10+5-10-20+10";
	
	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));
		String S=input.readLine();
		String regExp="(-|\\+)";
		
		String[] data=S.split(regExp);
		
		String[] str=S.split("");
		
		long min=0;
		
		int index=find_firstminus(str);
		for(int i=0;i<data.length;i++) {
			if(i<=index) {
				min+=Integer.parseInt(data[i]);
			}else {
				min-=Integer.parseInt(data[i]);
			}
		}
		
		System.out.print(min);
		
	}
	
	public static int find_firstminus(String[] str) {
		int index=0;
		for(int i=0;i<str.length;i++) {
			if(str[i].equals("+")) {
				index++;
			}else if(str[i].equals("-")) {
				break;
			}else {
				
			}
		}
		return index;
	}
}
