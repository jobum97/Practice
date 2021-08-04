package N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static String src="4 3";
			
	public static void main(String args[])throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));				
		StringTokenizer str=new StringTokenizer(input.readLine());
		
		int N,M;
		N=Integer.parseInt(str.nextToken());
		M=Integer.parseInt(str.nextToken());
		//N���� �ڿ����� M�� 
		int[] data=new int[N];
		boolean[] check=new boolean[N];
		int[] result = new int[M];
        
		for(int i=0;i<N;i++) {
			data[i]=i+1;
		}
		//System.out.println(Arrays.toString(data));
		
		perm(data,result,check,0, N, M);
		System.out.println(output);
	}
	//�ߺ� ����
	 public static void perm(int[] data, int[] result, boolean[] visited, int depth, int n, int r) {
	        if (depth == r) { //�ε��� 
	            output.append(result[0]);
	            for(int i=1;i<r;i++) {
	            	output.append(" "+result[i]);
	            }
	            output.append("\n");
	            return;
	        }

	        for (int i = 0; i < n; i++) {
	            if (visited[i] != true) { //���� ���� ���ڸ�
	                //visited[i] = true; //����=boolean �迭 true
	                result[depth] = data[i]; //��� �迭�� �� �ְ�
	                perm(data, result, visited, depth + 1, n, r); //���� index��
	                //visited[i] = false; //���� �־��� ������ �ٽ� false�� ��������
	            }
	        }
	    }
}
	
	/*
	public static void permutation(int[] data, int depth, int n, int r) {
	    if (depth == r) {
	        System.out.println(Arrays.toString(data));
	        return;
	    }
	 
	    for (int i=depth; i<n; i++) {
	        swap(data, depth, i);
	        permutation(data, depth + 1, n, r);
	        swap(data, depth, i);
	    }
	}
	
	
	public static void swap(int[] data,int depth,int i) {
		int temp=data[depth];
		data[depth]=data[i];
		data[i]=temp;
	}*/