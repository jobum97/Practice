import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "4";
		
	static int N,result;
	static int[] col;
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		
		N= Integer.parseInt(input.readLine());
		result=0;
		col=new int[N];
		
		sol(0);
		System.out.println(result);
	}
	
	public static void sol(int depth) {
		if(depth==N) {
			result++;
			return;
		}else {
			
			for(int i=0;i<N;i++) { 
				//System.out.println(Arrays.toString(col));
				col[depth]=i; //일단 배치해봄
				if(isPossible(depth)) {// 배치가 유효한지 검사
					sol(depth+1); //다음 행 진행
				}else { // 아닌 경우 초기화
					col[depth]=0;
				}
			}
		}
				
	}
	
	public static boolean isPossible(int depth) {
		
		for(int i=0;i<depth;i++) { //더 위에 있는 퀸에 잡히는지 검사                                     
			//세로 줄에 걸리는경우 || 대각선
			if(col[depth]==col[i]||Math.abs(col[depth]-col[i])==depth-i){ 
				return false;
			}
		}
		return true;
	}
	
	
}