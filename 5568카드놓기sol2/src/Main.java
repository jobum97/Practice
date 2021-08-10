import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int n,k;
	static int[] arr = new int[10];
	static boolean[] selected = new boolean[10];
	static Set<Integer> set = new HashSet<>();
	static int rslt = 0;
	static String src="6\n" +
			"3\n" +
			"72\n" +
			"2\n" +
			"12\n" +
			"7\n" +
			"2\n" +
			"1";
	
	
	public static void main(String[] args) throws IOException {
		
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));
		
		n = Integer.parseInt(input.readLine());
		k = Integer.parseInt(input.readLine());

		
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(input.readLine());
		}
		
		find(0, 0);
		System.out.println(set.size());
	}
	
	static void find(int cnt, int num){
		if(cnt == k){
			set.add(num);
			return;
		}
		for(int i = 0; i < n; i++){
			int tmp = 0;
			if(selected[i]) //이미 선택한 것이면 넘김
				continue;
			
			selected[i] = true; //아니면 선택하고 
			if(arr[i] > 9) //10보다 크면 num을 100곱하고 더함으로 숫자를 뒤에 붙이는 효과냄 
				tmp = num*100+arr[i];
			else //10보다 작으면 num 에 10곱하고 더함으로 같은 효과 
				tmp = num*10+arr[i];
			
			find(cnt+1, tmp);
			selected[i] = false;
		}
	}
}
	