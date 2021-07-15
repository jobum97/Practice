package 배틀필드;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output=new StringBuilder();
    static String src="1\r\n"
    		+ "3 7\r\n"
    		+ "***....\r\n"
    		+ "*-..#**\r\n"
    		+ "#<.****\r\n"
    		+ "23\r\n"
    		+ "SURSSSSUSLSRSSSURRDSRDS";
    static int row,col;
    public static void main(String arg[]) throws IOException {
        //input=new BufferedReader(new InputStreamReader(System.in));
        input=new BufferedReader(new StringReader(src));
        int t=Integer.parseInt(input.readLine());
        int tank_x,tank_y,order_length;
        char[] order;
        char tank_front;
        boolean find;
        char[][] map;
        StringTokenizer str;
        tank_x=0;
        tank_y=0;
        for(int testcase=1;testcase<=t;testcase++) {
        	str=new StringTokenizer(input.readLine());
        	row=Integer.parseInt(str.nextToken());
        	col=Integer.parseInt(str.nextToken());
        	map=new char[row][col];
        	find=false; 
        	tank_front=' ';
        	for(int x=0;x<row;x++){
        		map[x]=(input.readLine()).toCharArray();
        		if(!find) {
        			for(int y=0;y<col;y++) {
        				switch(map[x][y]) {
        				case '<':
        					tank_x=x;
            				tank_y=y;
            				tank_front='L';
            				break;
        				case '>':
        					tank_x=x;
            				tank_y=y;
            				tank_front='R';
            				break;
        				case '^':
        					tank_x=x;
            				tank_y=y;
            				tank_front='U';
            				break;
        				case 'v':
        					tank_x=x;
            				tank_y=y;
            				tank_front='D';
            				break;
            			default:
            				break;
        				}            			
        			}        		
        		}     
        	}
        	order_length=Integer.parseInt(input.readLine());
        	order=new char[order_length];        	    
        	order=(input.readLine()).toCharArray();
        	for(int i=0;i<order_length;i++) {        		
        		switch(order[i]) {
        		case 'U': //�ʹ����� ������X,(������,��ö��,��)X 
        			if(tank_x>0) { //y��ǥ>0
        				if(map[tank_x-1][tank_y]=='.') {
        					map[tank_x][tank_y]='.';
        					tank_x--;        			
        				}        				
        			}
        			map[tank_x][tank_y]='^';
        			tank_front='U';
        			break;
        		case 'D':
        			if(tank_x<row-1) {
        				if(map[tank_x+1][tank_y]=='.') {
        					map[tank_x][tank_y]='.';
        					tank_x++;        			
        				}        				
        			}
        			map[tank_x][tank_y]='v';
        			tank_front='D';
        			break;
        		case 'R':
        			if(tank_y<col-1) {          				
        				if(map[tank_x][tank_y+1]=='.') {
        					map[tank_x][tank_y]='.';
        					tank_y++;       					
        				}       				
        			}
        			map[tank_x][tank_y]='>';
        			tank_front='R';
        			break;
        		case 'L':
        			if(tank_y>0) {
        				if(map[tank_x][tank_y-1]=='.') {
        					map[tank_x][tank_y]='.';
        					tank_y--;        					
        				}        				
        			}
        			map[tank_x][tank_y]='<';
        			tank_front='L';
        			break;
        		case 'S':
        			shoot(map,tank_x,tank_y,tank_front);        			
        			break;   
        		}
        	}
        	output.append("#"+testcase+" ");
        	for(int x=0;x<row;x++){
        		for(int y=0;y<col;y++) {
        			output.append(map[x][y]);
        		}
        		output.append("\n");
        	}        	
        }
        System.out.println(output);
    }
    public static void shoot(char[][] map,int x,int y,char tank_front) {
    	switch(tank_front) {
    	case 'U':
    		while(x>0) {
    			x--;
    			if(map[x][y]=='#') {
    				break;
    			}
    			if(map[x][y]=='*') {
    				map[x][y]='.';
    				break;
    			}
    		}
    		break;
    	case 'D':
    		while(x<row-1) {
    			x++;
    			if(map[x][y]=='#') {
    				break;
    			}
    			if(map[x][y]=='*') {
    				map[x][y]='.';
    				break;
    			}
    		}
    		break;
    	
    	case 'R':
    		while(y<col-1) {
    			y++;
    			if(map[x][y]=='#') {
    				break;
    			}
    			if(map[x][y]=='*') {
    				map[x][y]='.';
    				break;
    			}
    		}
    		break;
    	case 'L':
    		while(y>0) {
    			y--;
    			if(map[x][y]=='#') {
    				break;
    			}
				if(map[x][y]=='*') {
					map[x][y]='.';
					break;
				}
    		}
    		break;
    	default:
			break;
    	}
    }
}