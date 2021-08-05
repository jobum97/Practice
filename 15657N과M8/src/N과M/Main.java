package N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static String src="4 2\r\n"
			+ "9 8 7 1";
	
	public static void main(String args[])throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));				
		StringTokenizer str=new StringTokenizer(input.readLine());
		LinkedList<Integer> list=new LinkedList<Integer>();
		
		int N,M;
		N=Integer.parseInt(str.nextToken());
		M=Integer.parseInt(str.nextToken());
		//N���� �ڿ����� M�� 
		int[] data=new int[N];
		str=new StringTokenizer(input.readLine());
		for(int i=0;i<N;i++) {
			data[i]=Integer.parseInt(str.nextToken());
		}
        Arrays.sort(data);
		//System.out.println(Arrays.toString(data));
		
		Combination(list,data, N, M, 0);
		
		System.out.println(output);
	}
	
	public static void Combination(LinkedList<Integer> list,int[] data, int n, int r, int index) {
		if(r == 0){
			for(int i=0;i<list.size();i++){
				output.append(list.get(i)+" ");
			}
			output.append("\n");
			return;
		}
		if(index == n) return;
		
		list.add(data[index]);
		Combination(list,data, n, r-1, index);
		list.removeLast();
		Combination(list,data, n, r, index+1);
	}

}
/*
output.append(result[0]);
for(int i=1;i<r;i++) {
	output.append(" "+result[i]);
}
output.append("\n");*/