package 쉬운거스름돈;

import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	
	
	
	static int fiftyTwon;
	static int tenTwon;
	static int fiveTwon;
	static int Twon;
	static int fiveHwon;
	static int Hwon;
	static int fiftyWon;
	static int tenWon;
	
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		for(int i=1;i<=testcase;i++) {
			int money=sc.nextInt();
			fiftyTwon=money/50000;
			money%=50000;
			tenTwon=money/10000;
			money%=10000;
			fiveTwon=money/5000;
			money%=5000;
			Twon=money/1000;
			money%=1000;
			fiveHwon=money/500;
			money%=500;
			Hwon=money/100;
			money%=100;
			fiftyWon=money/50;
			money%=50;
			tenWon=money/10;
			money%=10;
			
			System.out.println("#"+i);
			System.out.println(fiftyTwon+" "+tenTwon+" "+fiveTwon+" "+
			Twon+" "+fiveHwon+" "+ Hwon+" "+fiftyWon+" "+tenWon);
		}
	}



}
