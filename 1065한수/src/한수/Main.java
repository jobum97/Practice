package 한수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {
	static BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	
	static int result;
	
	public static void main(String args[]) throws IOException {
		input=new BufferedReader(new InputStreamReader(System.in));
		int number=Integer.parseInt(input.readLine());
		result=0;
		
		if(number<100) { //100������ �˴� �Ѽ��� 
			result=number;
		}else {
			result=99;
			for(int i=100;i<=number;i++) {
				check(i);
			}
			
		}
		
		System.out.print(result);
			
	}
	public static void check(int number) {
		int tmp1,tmp2,diff; //���� �ӽ� �ڸ��� 2�� , ù����
		boolean find=true;
		
		tmp1=number%10; //1�� �ڸ���
		number/=10; //������ 10���� ������
		tmp2=number%10; //10�� �ڸ���
		diff=tmp1-tmp2; //���� ���� ���س���
		
		while(number/10!=0) { //�׸��� �����鼭 ���� ���� ���ؼ�
			tmp1=number%10;
			number/=10;
			tmp2=number%10;
			if(tmp1-tmp2!=diff) { //���ߴµ� ���� ������ �ٸ��� 
				find=false; //false �׸��� Ż����
				break;
			}
		}
		if(find) { //���� ��� ������ �����ϴٸ� find�� true ��� �Ѽ�++
			result++;
		}
		
	}
}
