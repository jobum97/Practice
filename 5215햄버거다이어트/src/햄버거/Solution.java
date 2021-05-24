package 햄버거;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int Ingre;
	static int CalorieLimit;
	static int Score;
	static int BurgerTable[][];
	
	public static void TableShow(int Ingre,int BurgerTable[][]) {
		for(int i=0;i<Ingre;i++) {
			System.out.print(Arrays.toString(BurgerTable[i]));
			System.out.println();
		}
	}
	
	public static void SearchSol(int count,int Sum,int Cal) {
		 //System.out.println(count+","+Sum+","+Cal);
		if(Cal>CalorieLimit) {
			return;
		}
		
		if(count ==Ingre) {
			Score=Math.max(Score, Sum);
			return;
		}
		SearchSol(count+1,Sum+BurgerTable[count][0],Cal+BurgerTable[count][1]);
		
		SearchSol(count+1,Sum,Cal);
		
	}
	
	public static void main(String[] args) {
		int TestCase;
		int num1,num2;
		
		Scanner sc=new Scanner(System.in);
		TestCase=sc.nextInt();
		for(int i=0;i<TestCase;i++) {
		  //System.out.println("�׽�Ʈ ���̽� #"+(i+1));
		  
		  Ingre=sc.nextInt();
		  CalorieLimit=sc.nextInt();
		  Score=0;
		  //System.out.println("���� "+Ingre+" ����Į�θ� "+CalorieLimit);
		  
		  BurgerTable= new int[Ingre][2];
		  for(int k=0;k<Ingre;k++) {
			num1=sc.nextInt();
			num2=sc.nextInt();
			BurgerTable[k][0]=num1;
			BurgerTable[k][1]=num2;
		  }
		
		  SearchSol(0,0,0);
		  System.out.println("#"+(i+1)+" "+Score);
		  //TableShow(Ingre,BurgerTable);
		}
		
	}
	
	
	
}

