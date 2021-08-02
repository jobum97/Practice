package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="5\r\n"
			+ "5\r\n"
			+ "2\r\n"
			+ "3\r\n"
			+ "4\r\n"
			+ "1";
			
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));		
		int n=Integer.parseInt(input.readLine());
		Integer[] number=new Integer[n];
		for(int i=0;i<n;i++) {
			number[i]=Integer.parseInt(input.readLine());
		}
		Arrays.sort(number,new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1-o2; //���� �״��, ��� �ٲ�
			}
			
		});
		for(int i=0;i<n;i++) {
			output.append(number[i]+"\n");
		}
	
		System.out.println(output);
	}
}
