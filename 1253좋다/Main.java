import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "10\n" +
            "1 2 3 4 5 6 7 8 9 10";

    public static void main(String[] args) throws IOException {

        //input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        int count = Integer.parseInt(input.readLine());
        int[] arr = new int[count];

        int idx = 0;
        StringTokenizer st = new StringTokenizer(input.readLine());

        while(st.hasMoreTokens()){
            arr[idx++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int goodNumber = 0;


        for(int i = 0; i<arr.length; i++) {
            int findNumber = arr[i];

            // 투포인터
            int s = 0; // 시작지점
            int e = arr.length - 1; // 배열 끝지점
            int sum = 0;


            while(s < e){
                sum = arr[s] + arr[e];
                if(sum == findNumber){
                    if(i == s)
                        s++;
                    else if(e == i)
                        e--;
                    else{
                        goodNumber++;
                        break;
                    }
                }

                if(arr[s] + arr[e] > findNumber) //find 보다 크면 e--
                    e--;
                else if(arr[s] + arr[e] < findNumber) // find보다 작으면 s++
                    s++;


            }
        }
        System.out.println(goodNumber);
    }
}
