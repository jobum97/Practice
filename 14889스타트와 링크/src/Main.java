import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "6\r\n"
			+ "0 1 2 3 4 5\r\n"
			+ "1 0 2 3 4 5\r\n"
			+ "1 2 0 3 4 5\r\n"
			+ "1 2 3 0 4 5\r\n"
			+ "1 2 3 4 0 5\r\n"
			+ "1 2 3 4 5 0";
	
	static int[][] data;
	static int Min,tempSUM1,tempSUM2;
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		
		int N= Integer.parseInt(input.readLine());
		
		data= new int[N+1][N+1];
		Min=Integer.MAX_VALUE;
		
		StringTokenizer str;
		
		for(int i=1;i<N+1;i++) {
			str=new StringTokenizer(input.readLine());
			for(int j=1;j<N+1;j++) {
				data[i][j]=Integer.parseInt(str.nextToken());
			}
		}
		
		boolean[] visited=new boolean[N];
		int[] arr =new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=i+1;
		}
		
		firstcombination(arr, visited, 0, N, N/2);
		
		System.out.println(Min);
		
	}
	
	
	// 백트래킹 사용
	static void firstcombination(int[] arr, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	        
	        int[] subArr1=new int[n/2];
	        int[] subArr2=new int[n/2];
	        boolean[] subvisited=new boolean[n/2];
	        int j=0;
	        int k=0;
	        for(int i=0;i<n;i++) {
	        	if(visited[i]) {
	        		subArr1[j]=i+1;
	        		j++;
	        	}else {
	        		subArr2[k]=i+1;
		        	k++;	
	        	}
	        	
	        }
	        //System.out.println(Arrays.toString(subArr1)+" "+Arrays.toString(subArr2));
	        tempSUM1=0;
	        secondcombination(subArr1, subvisited, 0, n/2, 2);
	        tempSUM2=tempSUM1;
	        tempSUM1=0;
	        secondcombination(subArr2, subvisited, 0, n/2, 2);
	        //System.out.println(tempSUM1+" "+tempSUM2);
	        
	        Min=Math.min(Min, Math.abs(tempSUM1-tempSUM2));
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        firstcombination(arr, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
	
	static void secondcombination(int[] arr, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	     
	        
	        int temp[]=new int[2];
	        
	        int j=0;
	        for(int i=0;i<visited.length;i++) {
	        	if(visited[i]) {
	        		temp[j]=arr[i];
	        		j++;
	        	}
	        }
	        tempSUM1+=data[temp[0]][temp[1]];
	        tempSUM1+=data[temp[1]][temp[0]];
	        
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        secondcombination(arr, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
	
}
