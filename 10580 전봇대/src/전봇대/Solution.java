package 전봇대;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output=new StringBuilder();
    static String src="2\r\n"
    		+ "3\r\n"
    		+ "1 10\r\n"
    		+ "5 5\r\n"
    		+ "7 7\r\n"
    		+ "2\r\n"
    		+ "1 1\r\n"
    		+ "2 2";
    static int contact;	
    public static void main(String arg[]) throws IOException {
        //input=new BufferedReader(new InputStreamReader(System.in));
        input=new BufferedReader(new StringReader(src));
        int t=Integer.parseInt(input.readLine());    
        int line,start_point,end_point;
        ArrayList<Integer> start,end;
        StringTokenizer str;
        for(int testcase=1;testcase<=t;testcase++) {
        	start=new ArrayList<Integer>();
        	end=new ArrayList<Integer>();
        	contact=0;
        	line=Integer.parseInt(input.readLine());
        	for(int i=0;i<line;i++) {    
        		str=new StringTokenizer(input.readLine());
        		start_point=Integer.parseInt(str.nextToken());
        		end_point=Integer.parseInt(str.nextToken());
        		draw_newline(start,end,start_point,end_point);
        		start.add(start_point);
        		end.add(end_point);
        	}
        	output.append("#"+testcase+" "+contact+"\n");
        }        
        System.out.print(output);
    }
    //Ǯ�� idea ���ο� ���� ���� �� ��� ������ ���� ���� ���� ������������ ���ο�� ���������� ������ ���� ����
    //�ݴ�� ��������� ���� ���� ���� ������������ ���ο� ���� ���������� ������ ���� ����
    
    public static void draw_newline(ArrayList<Integer> start,ArrayList<Integer> end,int start_point,int end_point) {
    	for(int i=0;i<start.size();i++) {
    		if(start.get(i)>start_point) { //������ ��������� ������ ������ ������
    			if(end.get(i)<end_point) { //������ ���������� ������ ������ ���� ��
    				contact++;
    			}
    		}else { //������ ��������� ������ ������ ���� ��
    			if(end.get(i)>end_point) { //������ ���������� ������ ������ ���� ��
    				contact++;
    			}
    		}
    	}
    }
    
}