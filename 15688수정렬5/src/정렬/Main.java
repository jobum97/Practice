package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//�ð� ���� 10�� �޸� ���� 128MB //heapsort�� �ð��ʰ�...????
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
	
	public static void mergeSort(int start, int end) { 
		if (start<end) { 
			int mid = (start+end) / 2; //둘로 나눌 기준점 
			mergeSort(start, mid); //
			mergeSort(mid+1, end);  //
			int p = start;  //
			int q = mid + 1; 
			int idx = p; //
			while (p<=mid || q<=end) {  //
				if (q>end || (p<=mid && number[p]<number[q])) { //중간+1이 끝보다 크거나 p번째 숫자가 q번째 숫자보다 작다면   
					tmp[idx++] = number[p++]; //앞에 쌓음 
				} else { //아닌경우
					tmp[idx++] = number[q++]; //중간보다 큰 곳에 쌓음
					} 
				}
			//임시 배열의 리스트 복사 
			for (int i=start;i<=end;i++) {  
				number[i]=tmp[i]; 
				} 
			} 
		}
}
