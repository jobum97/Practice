package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//�ð� ���� 2�� �޸� ���� 256MB�� MergeSort�� 
public class Main {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static int[] number;
	static int[] tmp;
	static String src="10\r\n"
			+ "5\r\n"
			+ "2\r\n"
			+ "3\r\n"
			+ "1\r\n"
			+ "4\r\n"
			+ "2\r\n"
			+ "3\r\n"
			+ "5\r\n"
			+ "1\r\n"
			+ "7";
			
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));		
		int n=Integer.parseInt(input.readLine());
		number=new int[n];
		tmp=new int[n];
		for(int i=0;i<n;i++) {
			number[i]=Integer.parseInt(input.readLine());
		}
		mergeSort(0, n-1);
			

		for(int i=0;i<n;i++) {
			output.append(number[i]+"\n");
		}
	
		System.out.println(output);
	}
	
	public static void mergeSort(int start, int end) { //�迭 ���� index, �� index
		if (start<end) {  //���ۺ��� ���� ������
			int mid = (start+end) / 2; //������ ���� �߰��� ����
			mergeSort(start, mid); //ù��° ���� ���
			mergeSort(mid+1, end);  //�ι�° ���� �κ� ���
			int p = start;  //�κ����� ���� ù index ����
			int q = mid + 1; 
			int idx = p; //������ ������ġ index
			while (p<=mid || q<=end) {  //p�� �߰������ϰų� q�� �������϶�, �̸��̶�� ���Ұ� 1���϶��� �ɰ� 
				if (q>end || (p<=mid && number[p]>number[q])) { //ù��° ���ҿ��� ���� �������°�� 1. �ι�° ������ ���� �̴̹� ������, 
					//2. ù��°���� �������������� ����&&ù��° ������ ù������ ���� �ι�° ������ ù ���Ұ����� �������
					tmp[idx++] = number[p++]; 
				} else { //�ι�° ���ҿ��� ������
					tmp[idx++] = number[q++]; 
					} 
				}
			for (int i=start;i<=end;i++) { 
				number[i]=tmp[i]; 
				} 
			} 
		}
}
