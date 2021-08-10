import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="6\n" +
			"3\n" +
			"72\n" +
			"2\n" +
			"12\n" +
			"7\n" +
			"2\n" +
			"1";
	
	static int n,k;
	static Set<Integer> possibleNum = new HashSet<>();
	
	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		n = Integer.parseInt(input.readLine());
		k = Integer.parseInt(input.readLine());

		int[] Nums = new int[n];
		int[] selected = new int[k];
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			Nums[i] = Integer.parseInt(input.readLine());
		}

		//System.out.println(Arrays.toString(Nums));

		//Combination(Nums, k);
		Permutation(Nums, selected, visited, 0);

		System.out.println(possibleNum.size());
	}

	public static void Permutation(int[] Nums, int[] selected, boolean[] visited, int depth){

		if (depth == k) {
			//System.out.println(Integer.parseInt(Arrays.toString(selected).replaceAll("[^0-9]", "")));
			possibleNum.add(Integer.parseInt(Arrays.toString(selected).replaceAll("[^0-9]", "")));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				selected[depth] = Nums[i];
				Permutation(Nums, selected, visited, depth + 1);
				selected[depth] = 0;
				visited[i] = false;
			}
		}
	}

//	public static void swap(int[] arr, int depth, int i) {
//		int temp = arr[depth];
//		arr[depth] = arr[i];
//		arr[i] = temp;
//	}
//
//
//
//
//	public static void Combination(int[] Nums, int k) {
//		for (int i = 1; i < (1 << n); i++) {
//			if(Integer.bitCount(i) ==k){
//				for (int j = 0; j < n; j++) {
//					if ((i & 1 << j) > 0) {
//						System.out.print(j + " ");
//					}
//				}
//				System.out.println();
//			}
//		}
//	}
}