package 최빈수;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static String src="1\r\n"
			+ "1\r\n"
			+ "41 85 72 38 80 69 65 68 96 22 49 67 51 61 63 87 66 24 80 83 71 60 64 52 90 60 49 31 23 99 94 11 25 24 51 15 13 39 67 97 19 76 12 33 99 18 92 35 74 0 95 71 39 33 39 32 37 45 57 71 95 5 71 24 86 8 51 54 74 24 75 70 33 63 29 99 58 94 52 13 35 99 46 57 71 23 17 3 94 48 77 18 83 11 83 25 59 62 2 78 86 7 94 65 80 32 39 84 60 65 72 61 58 84 8 72 12 19 47 49 49 59 71 52 34 22 21 20 92 33 80 39 74 9 28 97 100 93 29 25 4 66 79 81 98 21 91 62 82 4 59 100 34 1 51 80 92 69 77 39 38 97 51 34 35 19 22 1 67 9 90 31 82 11 51 84 78 70 74 42 100 88 53 80 57 62 32 51 48 63 92 46 4 61 31 98 69 52 88 20 68 41 48 79 97 98 56 44 73 3 63 100 87 87 41 79 64 83 63 1 21 72 24 9 75 51 25 53 77 0 52 30 96 93 32 89 70 89 55 71 79 40 10 64 80 30 19 62 67 98 42 8 32 57 27 22 1 38 89 52 74 43 8 2 65 82 20 67 22 43 22 95 16 48 25 6 75 86 96 3 85 43 69 93 4 61 53 81 43 84 20 15 34 22 35 26 28 33 67 19 79 19 45 8 13 51 0 86 68 18 47 82 3 16 80 0 18 39 22 5 26 65 70 21 92 66 65 14 6 46 46 21 32 80 35 86 6 67 29 42 71 14 77 55 3 1 14 38 71 82 41 65 12 5 77 3 67 22 59 40 81 48 63 63 25 45 32 78 83 26 96 18 99 45 56 31 30 45 47 80 1 7 81 18 1 90 15 71 22 69 44 18 31 60 16 93 13 17 44 97 98 51 46 42 22 47 72 97 24 52 55 59 25 100 28 5 14 76 32 41 97 61 32 20 0 2 8 41 52 77 35 22 98 78 92 68 29 82 33 28 16 5 9 21 13 26 39 59 69 10 42 4 13 80 34 42 100 44 32 70 15 32 8 83 10 23 73 8 53 7 21 10 52 14 82 28 24 33 94 59 4 17 73 53 85 31 100 74 74 12 72 38 34 14 22 53 0 30 95 3 52 79 41 36 81 25 24 67 48 95 44 7 96 77 90 48 92 45 78 93 95 38 71 4 83 79 64 89 0 76 81 34 66 1 13 58 4 40 5 24 17 6 65 13 13 76 3 20 8 36 12 60 37 42 53 87 10 65 42 25 47 41 33 71 69 94 24 12 92 11 71 3 82 91 90 20 95 44 76 60 34 95 49 40 89 4 45 27 9 34 82 59 2 20 68 22 29 10 1 23 19 47 16 76 47 49 90 94 10 18 55 69 14 26 59 77 73 8 21 72 1 74 76 51 94 44 24 98 71 77 59 9 12 49 38 72 22 55 35 61 16 48 41 21 67 74 92 4 7 85 34 92 39 96 42 26 1 1 4 64 33 96 62 23 67 76 26 47 32 73 82 30 14 61 21 92 40 4 2 38 76 64 8 14 3 49 71 31 38 86 98 17 15 98 32 55 69 46 61 3 44 67 50 44 76 0 45 23 25 11 82 99 11 39 50 40 21 52 17 60 44 90 44 6 16 38 3 41 43 56 26 24 0 9 90 36 50 13 42 88 87 66 32 28 73 94 52 11 35 47 9 87 37 57 15 56 38 95 6 43 23 30 84 39 88 69 5 34 81 93 86 2 77 10 28 30 97 68 14 12 88 1 100 35 73 30 2 43 11 41 58 82 6 84 71 16 18 67 41 100 92 78 57 7 35 69 56 76 13 93 26 26 38 21 96 7 88 2 60 17 54 95 26 2 0 21 87 11 96 36 83 88 31 24 24 62 14 88 84 39 22 17 84 96 1 78 91 53 9 35 75 87 100 33 80 42 7 20 50 65 81 92 14 45 96 34 6 20 86 51 4 19 70 91 13 0 42 70 43 15 47 14 96 72 41 91 11 72 7 92 12 16 51 13 86 40 50 43 55 26 7 1 70 18 71 99 49 55 94 78 40 59 20 96 34 6 28 85 42 70 62 63 32 34 97 80 49 47 50 73 85 63 20 29 0 19 91 84 58 55 33 4 68 55 12 38 49 9 13 99 4 35 26 5 42 29 98 20 95 77 36 63 41 42 45 81 40 53 60 5 55 9 13 34 6 52 28 35 33 29 21 67 57 61 21 41 95 54 50 19 81 75 67 73 77 47 40 83 16 28";
	public static void bubbleSort(int[][] A,int length) {
		int tmp;
		for(int i=length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(A[j][1]<A[j+1][1]) {
					tmp=A[j][1];
					A[j][1]=A[j+1][1];
					A[j+1][1]=tmp;
					tmp=A[j][0];
					A[j][0]=A[j+1][0];
					A[j+1][0]=tmp;
				}
			}
		}
	}
	public static int count(int array[][]) {
		
		bubbleSort(array,array.length);
		int tmp;
		int max=array[0][0];
		int i=0;
		
		while(true) {
			if(array[i][1]>array[i+1][1]) {
				break;
			}
			tmp=array[i][0];
			if(max<tmp) {
				max=tmp;
			}
			i++;
		}
		
		
		
		return max;
	}
	
	
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input=new BufferedReader(new StringReader(src));
		int testcase=Integer.parseInt(input.readLine());
		int j,num;
 		for(int t=1;t<=testcase;t++) {
 			j=0;
 			num=Integer.parseInt(input.readLine());
 			int[] array=new int[1000];
 			StringTokenizer str;
 			str=new StringTokenizer(input.readLine());
 			while(str.hasMoreTokens()) {
 				array[j]=Integer.parseInt(str.nextToken());
 				j++;
 			}
 			int[][] data=new int[array.length][2];
 			data[0][0]=array[0];
 			for(int i=1;i<array.length;i++) {
 				for(int k=0;k<i;k++) {
 					if(data[k][0]==array[i]) {
 						data[k][1]+=1;
 					}else {
 						data[i][0]=array[i];
					}
				}
 			}
 			
 			System.out.println("#"+num+" "+count(data));
 			
 		}
	}
}