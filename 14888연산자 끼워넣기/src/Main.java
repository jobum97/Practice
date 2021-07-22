import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "6\r\n"
			+ "1 2 3 4 5 6\r\n"
			+ "2 1 1 1";
	
	static int n; 						//수의 개수
	static int Min=Integer.MAX_VALUE;	//최솟값
	static int Max=Integer.MIN_VALUE;	//최대값
	static int[] numbers,operator;		//숫자, 연산자 배열
 	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		
		n= Integer.parseInt(input.readLine());
		StringTokenizer str=new StringTokenizer(input.readLine());
		
		numbers =new int[n];
		
		
		for(int i=0;i<n;i++) {
			numbers[i]=Integer.parseInt(str.nextToken());
		}
		
		int[] operators=new int[n-1]; //연산자들 순열될것
		operator=new int[4]; // 연산자 개수
		str=new StringTokenizer(input.readLine());
		
		
		for(int i=0;i<4;i++) {
			operator[i]=Integer.parseInt(str.nextToken());
		}
		
		Arrays.fill(operators, -1);
		
		boolean[] checked =new boolean[n-1]; //연산자
		//////////////////////////////////////////////////////////
//		System.out.println(Arrays.toString(numbers));
//		System.out.println(Arrays.toString(operators));
//		System.out.println(Arrays.toString(operator));
//		System.out.println();
		/////////////////////////////////////////////////////////
		
		same_permutation(operators, 0 ,0);
		
		System.out.println(Max);
		System.out.println(Min);
	}
	
	///////// * 42, + 43, - 46 , / 47
	
	//같은 것이 있는 순열
	public static void same_permutation(int[] OP,int index,int st) {
		int temp;
		
		if(index==4) { //연산자 전부 배치시
//			System.out.println(Arrays.toString(OP));
//			System.out.println(calculation(OP));
			temp=calculation(OP);
			if(Max<temp) {
				Max=temp;
			}
			if(Min>temp) {
				Min=temp;
			}
			return;
		}
		
		if(operator[index]<=0) { //해당 연산사 모두 배치시 다음
			same_permutation(OP, index+1,0);
		}
		else {
			operator[index]--;
						
			for(int i=st;i<n-1;i++) { 
				
				if(OP[i]<0) { //미정인 경우
					OP[i]=index; //해당 연산자 배치하는 경우 
					same_permutation(OP,index, i+1);
					OP[i]=-1; //아닌 경우 
				}
			}
			operator[index]++;
		}
		
	}
	
	public static int calculation(int[] OP) {
		int temp=numbers[0];
		for(int i=0;i<n-1;i++) {
			if(OP[i]==0) { //+
				temp+=numbers[i+1];
			}else if(OP[i]==1) { //+
				temp-=numbers[i+1];
			}else if(OP[i]==2) { //+
				temp*=numbers[i+1];
			}else if(OP[i]==3) { //+
				temp/=numbers[i+1];
			}
		}
		
		return temp;
	}
}


