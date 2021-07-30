package 시리얼번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="5\r\n"
			+ "ABCD\r\n"
			+ "145C\r\n"
			+ "A\r\n"
			+ "A910\r\n"
			+ "Z321";
	static int sum1,sum2;
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int test=Integer.parseInt(input.readLine());
		String[] str=new String[test];
		for(int t=0;t<test;t++) {
			str[t]=input.readLine();
		}
		
		Arrays.sort(str,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1.length()>o2.length()) { //���ڿ� ���� ������ ������ ���� �ճ��� ũ�� 
					return 1; //�� �ڸ� �ٲ�
				}else if(o1.length()==o2.length()){ //������ ���ڿ� �� ���� ���ؼ� �ٲ�
					sum1=0;
					sum2=0;
					char[] strT1=o1.toCharArray();
					char[] strT2=o2.toCharArray();
					for(int i=0;i<o1.length();i++) {
						if(47<(int)strT1[i]&&(int)strT1[i]<58) {
							sum1+=strT1[i]-'0';
						}
						if(47<(int)strT2[i]&&(int)strT2[i]<58) {
							sum2+=strT2[i]-'0';
						}
					}
					if(sum1>sum2) { //���� ���� �͵��� �� ũ�ٸ� �ճ��� ũ�ٸ� 
						return 1; //�ڸ� �ٲ�
					}else if(sum1==sum2) { //���ٸ� ���������� compareTo= ������ �� 
						//������ 0, �ڽ��� ���̸� -1 �� �Ⱥ��� �ڽ��� �ڸ� ��� ��ȯ== �ڸ� �ٲ�
						return o1.compareTo(o2);
					}else { //�״��...
						return -1;
					}
				}else { //�״�� �� �ȹٲ�
					return -1;
				}
			}
			
		});
		for(int i=0;i<str.length;i++) {
			System.out.println(str[i]);
		}
		
		
	}
}