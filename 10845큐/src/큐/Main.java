package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static String src="15\r\n"
			+ "push 1\r\n"
			+ "push 2\r\n"
			+ "front\r\n"
			+ "back\r\n"
			+ "size\r\n"
			+ "empty\r\n"
			+ "pop\r\n"
			+ "pop\r\n"
			+ "pop\r\n"
			+ "size\r\n"
			+ "empty\r\n"
			+ "pop\r\n"
			+ "push 3\r\n"
			+ "empty\r\n"
			+ "front";
			
	public static void main(String args[])throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));				
		
		int command=Integer.parseInt(input.readLine());
		int[] data=new int[10001];
		String temp;
		int start=0;
		int end=0;
		int size=0;
		StringTokenizer str;
		
		for(int i=0;i<command;i++) {
			temp=input.readLine();
			
			//System.out.println(start+" "+end);
			switch(temp.substring(0, 2)) {
			case "pu": //push ť�� �ֱ�
				str= new StringTokenizer(temp);
				str.nextToken();
				
				size++;
				data[end]=Integer.parseInt(str.nextToken());
				end++;
				break;
			case "po": //pop ť���� ���� �� ���� ���� ���, ������ -1
				if(start!=end) {
					if(size!=0) {
						size--;
					}
					output.append(data[start]+"\n");
					start++;
				}else {
					output.append("-1\n");
				}				
				break;
			case "si": //size ť�� ����ִ� ���� ����
				output.append(size+"\n");
				break;
			case "em": //empty ť ��������� 1 �ƴϸ� 0
				if(start==end) {
					output.append("1\n");
				}else {
					output.append("0\n");
				}
				break;
			case "fr": //front ť ���� �� ���� ��� ������ -1
				if(start==end) {
					output.append("-1\n");
				}else {
					output.append(data[start]+"\n");
				}								
				break;
			case "ba": //back ť ���� �� ���� ��� ������ -1
				if(start==end) {
					output.append("-1\n");
				}else {
					output.append(data[end-1]+"\n");
				}		
				break;	
			}
			
			
		}
		System.out.println(output);	
		//System.out.println(Arrays.toString(data));
		
		
	}
}
		
		