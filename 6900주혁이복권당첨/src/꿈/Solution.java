package 꿈;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output=new StringBuilder();
    static String src="1\r\n"
    		+ "4 4\r\n"
    		+ "*******1 1\r\n"
    		+ "******12 10\r\n"
    		+ "66*66**3 1000\r\n"
    		+ "87654320 1000000\r\n"
    		+ "87654320\r\n"
    		+ "85288251\r\n"
    		+ "48888812\r\n"
    		+ "12345678";
    static int total_reward;
    static int n,m;
    public static void main(String arg[]) throws IOException {
        //input=new BufferedReader(new InputStreamReader(System.in));
        input=new BufferedReader(new StringReader(src));
        int t=Integer.parseInt(input.readLine());  
        StringTokenizer str;
        ArrayList<String> lotto;
        ArrayList<Integer> reward;        
        String mylotto;
        for(int testcase=1;testcase<=t;testcase++) {
        	total_reward=0;
        	lotto=new ArrayList<String>();
        	reward=new ArrayList<Integer>();
        	str=new StringTokenizer(input.readLine());
        	n=Integer.parseInt(str.nextToken());
        	m=Integer.parseInt(str.nextToken());
        	for(int i=0;i<n;i++) { //���� ���� �Է�
        		str=new StringTokenizer(input.readLine());
        		lotto.add(str.nextToken());
        		reward.add(Integer.parseInt(str.nextToken()));
        	}
        	for(int i=0;i<m;i++) { //���� �ִ� ���� ��ȣ
        		mylotto=input.readLine();
        		check(lotto,reward,mylotto);
        	}
        	
        	output.append("#"+testcase+" "+total_reward+"\n");
        	
        }
        System.out.println(output);
        
        
    }   
    
    public static void check(ArrayList<String> lotto,ArrayList<Integer> reward,String mylotto) {
    	String temp;
    	boolean success;
    	for(int i=0;i<lotto.size();i++) {
    		success=true;
    		temp=lotto.get(i);
    		for(int j=0;j<8;j++) {
    			if(!temp.substring(j,j+1).equals("*")) { //*�� �ƴҶ��� ���� �����غ�
    				if(!temp.substring(j,j+1).equals(mylotto.substring(j,j+1))) {
    					success=false;
    				}
    			}
    		}
    		if(success) {
    			total_reward+=reward.get(i);
    		}
    	}
    }
}