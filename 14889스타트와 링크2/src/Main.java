import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int answer = Integer.MAX_VALUE;
	static int[][] status;
	static String src = "4\r\n"
			+ "0 1 2 3\r\n"
			+ "4 0 5 6\r\n"
			+ "7 1 0 2\r\n"
			+ "3 4 5 0";
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(br.readLine());
		status = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				status[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		score(0, N, 0, 0, 0, 0);
		System.out.println(answer/2);
	}
static void score(int length, int N, int start, int link, int length_start, int length_link) {
		if(length == N) {
			answer = Math.min(Math.abs(start-link), answer);
			System.out.println(length+" "+start+" "+link+" "+length_start+" "+length_link);
		} else {
			// length 번째 선수가 
			int add = 0;
			for(int i = 0; i < N; i++) {
				add += (status[i][length]+status[length][i]);
				System.out.println(i+" "+length+" "+status[i][length]+" "+status[length][i]);
			}
			System.out.println(length+" "+start+" "+link+" "+length_start+" "+length_link+" "+add);
			// 1. start 팀에 들어가는 경우
			if(length_start < N/2) {
				score(length+1, N, start+add, link, length_start+1, length_link);
			}
			// 2. link 팀에 들어가는 경우 
			if(length_link < N/2) {
				score(length+1, N, start, link+add, length_start, length_link+1);
			}
		}
	}
}