import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "10 13\r\n"
			+ "BBBBBBBBWBWBW\r\n"
			+ "BBBBBBBBBWBWB\r\n"
			+ "BBBBBBBBWBWBW\r\n"
			+ "BBBBBBBBBWBWB\r\n"
			+ "BBBBBBBBWBWBW\r\n"
			+ "BBBBBBBBBWBWB\r\n"
			+ "BBBBBBBBWBWBW\r\n"
			+ "BBBBBBBBBWBWB\r\n"
			+ "WWWWWWWWWWBWB\r\n"
			+ "WWWWWWWWWWBWB";
	
	static boolean[][] BWmap;
	static boolean[][] WBmap;
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		StringTokenizer str=new StringTokenizer(input.readLine());
		
		int row,col;
		
		row=Integer.parseInt(str.nextToken());
		col=Integer.parseInt(str.nextToken());
		
		BWmap=new boolean[row][col];
		WBmap=new boolean[row][col];
		
		String temp=input.readLine();
		String[] line;
		//wbwbw....
		for(int i=0;i<row;i++) {
			line=temp.split("");
			for(int j=0;j<col;j++) {
				if((i+j)%2==0) {
					if(line[j].equals("B")) {
						WBmap[i][j]=true; //틀린 요소
					}
					if(line[j].equals("W")) {
						BWmap[i][j]=true; //틀린 요소
					}
				}else {
					if(line[j].equals("W")) {
						WBmap[i][j]=true; //틀린 요소
					}
					if(line[j].equals("B")) {
						BWmap[i][j]=true; //틀린 요소
					}
				}
			}
				
			temp=input.readLine();
		}
	
		
//		for(int i=0;i<row;i++) {
//			
//			for(int j=0;j<col;j++) {
//				System.out.print(BWmap[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for(int i=0;i<row;i++) {
//			
//			for(int j=0;j<col;j++) {
//				System.out.print(WBmap[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		int BWscore=0;
		int WBscore=0;
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<row-7;i++) {
			for(int j=0;j<col-7;j++) {
				BWscore=0;
				WBscore=0;
				for(int x=i;x<i+8;x++) {
					for(int y=j;y<j+8;y++) {
						if(BWmap[x][y]) {					
							BWscore++;
						}
						if(WBmap[x][y]) {
							WBscore++;				
						}
					}
				}
				if(BWscore<min) {
					min=BWscore;
				}
				if(WBscore<min) {
					min=WBscore;
				}
				//System.out.println(BWscore+" "+WBscore);
			}
		}
		System.out.println(min);
	}
	
}