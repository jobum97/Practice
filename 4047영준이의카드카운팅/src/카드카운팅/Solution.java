package 카드카운팅;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output=new StringBuilder();
    static String src="3\r\n"
    		+ "S01D02H03H04\r\n"
    		+ "H02H10S11H02\r\n"
    		+ "S10D10H10C01";
    
    public static void main(String arg[]) throws IOException {
        //input=new BufferedReader(new InputStreamReader(System.in));
        input=new BufferedReader(new StringReader(src));
        int t=Integer.parseInt(input.readLine());
        StringTokenizer str;
        String temp,pattern;
        int number,token;
        boolean multiple_check=false;
        ArrayList<Integer> S_pattern,D_pattern,H_pattern,C_pattern;
        for(int testcase=1;testcase<=t;testcase++) {
        	S_pattern=new ArrayList<Integer>(); 
        	D_pattern=new ArrayList<Integer>();
        	H_pattern=new ArrayList<Integer>();
        	C_pattern=new ArrayList<Integer>();
        	multiple_check=false;
        	temp=input.readLine();
        	token=temp.length()/3;
        	Loop1:
        	for(int i=0;i<token;i++) {
        		pattern=temp.substring(3*i,3*i+1);       		
        		number=Integer.valueOf(temp.substring((3*i)+1,(3*i)+3));
        		switch(pattern) {
        		case "S":
        			if(S_pattern.contains(number)) {
        				multiple_check=true;
        				break Loop1;
        			}else {
        				S_pattern.add(number);
        				break;
        			}        			        
        		case "D":
        			if(D_pattern.contains(number)) {
        				multiple_check=true;
        				break Loop1;
        			}else {
        				D_pattern.add(number);
        				break;
        			}        		
        		case "H":
        			if(H_pattern.contains(number)) {
        				multiple_check=true;
        				break Loop1;
        			}else {
        				H_pattern.add(number);
        				break;
        			}        		
        		case "C":
        			if(C_pattern.contains(number)) {
        				multiple_check=true;
        				break Loop1;
        			}else {
        				C_pattern.add(number);
        				break;
        			}        		
        		default:
        			System.out.println("switch error");
        			break;
        		}       	        		
        	}
        	
        	output.append("#"+testcase);
        	if(multiple_check) {
        		output.append(" ERROR\n");
        	}else {
        		output.append(" "+(13-S_pattern.size()));
        		output.append(" "+(13-D_pattern.size()));
        		output.append(" "+(13-H_pattern.size()));
        		output.append(" "+(13-C_pattern.size()+"\n"));
        	}
 
        }
       System.out.println(output);
    }
}
