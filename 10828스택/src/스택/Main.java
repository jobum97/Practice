package Ω∫≈√;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {
	static BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static String src="7\r\n"
			+ "pop\r\n"
			+ "top\r\n"
			+ "push 123\r\n"
			+ "top\r\n"
			+ "pop\r\n"
			+ "top\r\n"
			+ "pop";
	
	public static void main(String args[]) throws IOException {
		//input=new BufferedReader(new StringReader(src));
		input=new BufferedReader(new InputStreamReader(System.in));
		int command=Integer.parseInt(input.readLine());
		String str,tmp;
		int index=-1;
		String[] temp;
		int[] data=new int[10000];
		
		for(int i=0;i<command;i++) {
			str=input.readLine();
			tmp=str.substring(0,2);
			temp=str.split(" ");
			switch(tmp) {
			case "pu": //push
				index++;
				data[index]=Integer.parseInt(temp[1]);
				break;
			case "po": //pop
				if(index==-1) {
					output.append("-1\n");
					break;
				}else {
					output.append(data[index]+"\n");
					index--;
					break;
				}				
			case "si": //size
				output.append(index+1+"\n");
				break;
			case "em": //empty
				if(index==-1) {
					output.append("1\n");
					break;
				}else {
					output.append("0\n");
					break;
				}
			case "to": //top
				if(index==-1) {
					output.append("-1\n");
					break;
				}else {
					output.append(data[index]+"\n");
					break;
				}
			default:
				break;
			}
			
		}
		System.out.print(output);
	}
}
