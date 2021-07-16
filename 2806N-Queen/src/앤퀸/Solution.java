package 앤퀸;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="5\r\n"
			+ "1\r\n"
			+ "2\r\n"
			+ "3\r\n"
			+ "4\r\n"
			+ "5";
	
	
	static int n;
	static int success_count;
	static int[] col;
	public static void dfs(int level) {
		if(level==n) { //n 층 도착하면 성공하고 리턴으로 빠져나옴
			success_count++;
			return;
		}else {
			for(int i=0;i<n;i++) { // 
				col[level]=i;
				if(isPossible(level)) {//��� �࿡ �ϳ��� �����ϱ⿡ �Ǹ� ���� ��
					dfs(level+1); //
				}else { //�ȵǸ� 
					col[level]=0;
				}
			}
		}
	}
	public static boolean isPossible(int level) {
		
		for(int i=0;i<level;i++) { //                                                    
			if(col[level]==col[i]||Math.abs(col[level]-col[i])==level-i){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		
 		for(int t=1;t<=testcase;t++) {
 			n=Integer.parseInt(input.readLine());
 			success_count=0;
 			col=new int[n];
 			dfs(0);
 			System.out.println("#"+t+" "+success_count);
 		}
	}
}