package 스도쿠;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src =
			"103000509\r\n"
			+ "002109400\r\n"
			+ "000704000\r\n"
			+ "300502006\r\n"
			+ "060000050\r\n"
			+ "700803004\r\n"
			+ "000401000\r\n"
			+ "009205800\r\n"
			+ "804000107";
	
	static int[][] table=new int[9][9];
	static boolean[] possible=new boolean[10];

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));	
		String str;
		
		for(int i=0;i<9;i++) {
			str=input.readLine();
			table[i]=Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		//printMap();
		//System.out.println("#######################");
		fillSudoku(0, 0);
		printMap();
	}
	
	public static boolean fillSudoku(int x, int y) {
		int[] temp = nextZero(x,y);
		int row = temp[0];
		int col = temp[1];
		if(row==9) {
			return true;
		}
		
		for(int i=1;i<=9;i++) {
			if(check(row, col, i)) {
				table[row][col]=i;
				//System.out.println(row+" "+col+" "+i);
				if(fillSudoku(row, col)) {
					return true;
				}
				table[row][col]=0;
			}
		}
		return false;
	}
	
	public static void printMap() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(table[i][j]);				
			}			
			System.out.println();
		}
	}
	
	public static int[] nextZero(int x, int y) {
		int[] temp=new int[2];
		while(true) {
			if(x==9) {
				break;
			}
			if(table[x][y]==0) {
				temp[0]=x;
				temp[1]=y;
				return temp;
			}
			y++;
			if(y==9) {
				y=0;
				x++;
			}
		}
		temp[0]=x;
		temp[1]=y;
		return temp;
	}
	
	public static boolean check(int x, int y,int i) {
		Arrays.fill(possible, true);
		check_box(x, y);
		check_col(y);
		check_row(x);
		//System.out.println(Arrays.toString(possible));
		return possible[i];
	}
	
	
	
	public static void check_row(int row){
		for(int i=0;i<9;i++) {
			possible[table[row][i]]=false;
		}
		
	}
	public static void check_col(int col){
		for(int i=0;i<9;i++) {
			possible[table[i][col]]=false;
		}
		
	}
	
	public static void check_box(int row,int col) {
		row/=3;
		col/=3;
		row*=3;
		col*=3;
		
		for(int i=row;i<row+3;i++) {
			for(int j=col;j<col+3;j++) {
				possible[table[i][j]]=false;
			}
		}
		
		
	}
	
	
}