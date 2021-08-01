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
	static String src="4 2";
	
	public static void main(String args[])throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));				
		StringTokenizer str=new StringTokenizer(input.readLine());
		LinkedList<Integer> list=new LinkedList<Integer>();
		
		int N,M;
		N=Integer.parseInt(str.nextToken());
		M=Integer.parseInt(str.nextToken());
		//N���� �ڿ����� M�� 
		
        
		//System.out.println(Arrays.toString(data));
		
		combination(list, N, M, 1);
		
		System.out.println(output);
	}
	//����
	 public static void combination(LinkedList<Integer> list, int n, int r, int index) {
			if(r == 0){//r�� 0�̸� �� �̾Ҵٴ� ��
				for(int i=0;i<list.size();i++){
					output.append(list.get(i)+" ");
				}
				output.append("\n");
				return;
			}
			if(index == n+1) return; //�� Ž�������� ����..
			
			list.add(index);
			combination(list, n, r-1, index+1);//�̾����� ,r-1
			list.removeLast();
			combination(list, n, r, index+1);//�Ȼ̾�����, r
		}
}
/*
output.append(result[0]);
for(int i=1;i<r;i++) {
	output.append(" "+result[i]);
}
output.append("\n");*/