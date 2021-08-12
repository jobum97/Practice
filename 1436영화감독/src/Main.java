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
	

	public static void main(String args[]) throws IOException {
		input= new BufferedReader(new InputStreamReader(System.in));
		//input = new BufferedReader(new StringReader(src));
		
		String basic="666";
		String temp="0";
		String Rtemp="0";
		int i=0;
		int j=0;
		int index=0;
		int[] dp=new int[1000];
		
		
		
		while(index<=30) {
			Rtemp=Integer.toString(j);
			temp=Integer.toString(i);
			int left=Integer.parseInt(temp+basic);
			int right=Integer.parseInt(basic+Rtemp);
			
			if(right<left) { //오른쪽이 더 작을 경우 
				
				dp[index]=Math.min(left,right);
				j++;
				index++;
				continue;
			}
			if(left==right) {//같을경우
				dp[index]=Math.min(left,right);
				j++;
				i++;
				index++;
				continue;
			}
			
			dp[index]=Math.min(left,right);
			i++;
			index++;
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[Integer.parseInt(input.readLine())]);
	}
}
