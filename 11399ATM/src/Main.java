import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="5\r\n"
			+ "3 1 4 3 2";
	
	public static void main(String arg[]) throws IOException {
		input= new BufferedReader(new InputStreamReader(System.in));
		//input= new BufferedReader(new StringReader(src));
		
		int n=Integer.parseInt(input.readLine());
		StringTokenizer str=new StringTokenizer(input.readLine());
		int Sum=0;
		
		int[] data=new int[n+1];
		for(int i=1;i<n+1;i++) {
			data[i]=Integer.parseInt(str.nextToken());
		}
		
		quickSort(data);
		
		for(int i=1;i<n+1;i++) {
			Sum+=data[i]*(n+1-i);
		}
		
		System.out.print(Sum);
	}
	
	
	public static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = partition(arr, low, high);
        sort(arr, low, mid - 1);
        sort(arr, mid, high);
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        while (low <= high) {
            while (arr[low] < pivot) low++;
            while (arr[high] > pivot) high--;
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}


    
