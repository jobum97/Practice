import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		int input;
		int testcase;
		int sum;
		Scanner sc=new Scanner(System.in);
		testcase=sc.nextInt();
		int[] result=new int[testcase];
		for(int k=0;k<testcase;k++) {
			input=sc.nextInt();
			
			sum=0;
			for(int i=1;i<=input;i++) {
				if(i%2==0) {
					sum-=i;
				}
				else {
					sum+=i;
				}
			}
			result[k]=sum;
			//System.out.println(sum);
		}
		
		for(int i=1;i<=testcase;i++) {
			System.out.println("#"+i+" "+result[i-1]);
		}
			
	}
	
	
}
