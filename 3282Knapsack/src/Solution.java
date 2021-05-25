import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static String src="1\r\n"
			+ "4 5\r\n"
			+ "1 2\r\n"
			+ "3 2\r\n"
			+ "4 4\r\n"
			+ "2 3";
	
	static int quantity,volume_limit;
	static int[] Volume=new int[101];
	static int[] Value=new int[101];		
	public static void main(String args[])throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));		
		int testcase=Integer.parseInt(input.readLine()); 
		StringTokenizer str;
		
		
		for(int t=1;t<=testcase;t++) {
			str=new StringTokenizer(input.readLine());
			quantity=Integer.parseInt(str.nextToken());
			volume_limit=Integer.parseInt(str.nextToken());
			
			
			//물건 정보(부피, 가치) 테이블 생성
			for(int q=1;q<quantity+1;q++) {
				str=new StringTokenizer(input.readLine());
				Volume[q]=Integer.parseInt(str.nextToken());
				Value[q]=Integer.parseInt(str.nextToken());
			}
			
			//최대가치계산
			
			output.append("#"+t+" "+calculation()+"\n");
		}
		System.out.println(output);
	}
	
	public static int calculation(){
		
		int table[][]=new int[quantity+1][volume_limit+1];
		
		for(int i=1;i<table.length;i++) {
			for(int j=1;j<table[i].length;j++) {
				if(Volume[i]>j) { //부피제한 보다 새로 들어갈 요소의 부피가 큰경우 
					table[i][j]=table[i-1][j]; //변화 X
				}else {
					table[i][j]=Math.max(Value[i]+table[i-1][j-Volume[i]], table[i-1][j]);
				}
			}
		}
		
		for(int i=1;i<table.length;i++) {
			System.out.println(Arrays.toString(table[i]));
		}
		
		
		return table[quantity][volume_limit];
	}
}