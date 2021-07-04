package 파스칼삼각형;

import java.util.Scanner;
import java.util.Arrays;
public class Solution {

	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		
		for(int i=1;i<=testcase;i++) {
			int t_scale=sc.nextInt();
			int [][] tr=new int[t_scale][t_scale];
			tr[0][0]=1;
			if(t_scale>1) {
				tr[1][0]=1;
				tr[1][1]=1;
			}
			if(t_scale>2){
				for(int j=2;j<t_scale;j++) {
					tr[j][0]=1;
					for(int n=1;n<j;n++) {
						tr[j][n]=tr[j-1][n-1]+tr[j-1][n];
					}
					tr[j][j]=1;
				}
			}
			System.out.println("#"+i);
			for(int m=0;m<t_scale;m++){
				System.out.println(Arrays.toString(tr[m]));
			}
		}
		
	}
	
	
}
