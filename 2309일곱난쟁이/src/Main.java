import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;


public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "20\r\n"
			+ "7\r\n"
			+ "23\r\n"
			+ "19\r\n"
			+ "10\r\n"
			+ "15\r\n"
			+ "25\r\n"
			+ "8\r\n"
			+ "13";

	static int[] data;
	static int N;

	public static void main(String args[]) throws IOException {
		// input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		data = new int[9];
		N=9;
		int total=0;
		int temp=0;
		int[] answer=new int[2];
		int index=0;
		
		for (int i = 0; i < 9; i++) {
			data[i]=Integer.parseInt(input.readLine());
			total+=data[i];
		}
		total-=100;
		
		Arrays.sort(data);
		
		int M=7;
		//비트마스킹 이진수에서 1이 선택한것 0이 선택하지 않은 것
		for (int i = 0; i < 1 << N; i++) { // 1을 arr의 크기 N만큼 왼쪽 쉬프트 : 2^N-1, 십진법으로 0부터 2^N-1 까지 모든 경우의수 
			if (Integer.bitCount(i) == 2) { //그중에서 N개 중 2개를 선택 경우 ( 이진법으로 1이 2개인 경우)
			      
				for (int j = 0; j < N; j++) {			    	
			          if ((i & (1 << j)) > 0) { //1을 j만큼 밀면서 j번째 원소를 선택했는지 확인			        	 			        	
			        	  temp+=data[j];
			        	  answer[index++]=j;
			          }			              
				}
				index=0;	
			    if(temp==total) {
			    	for(int k=0;k<9;k++) {
			    		if(k==answer[0]||k==answer[1]) {
			    		 
			    		}else{
			    			output.append(data[k]+"\n");
			    		}
			    	}
			    	  
			    	break;
			    }
			    temp=0;			   		      
			}
		}
		
		System.out.println(output);
		
	}
}
