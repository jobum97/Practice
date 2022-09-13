import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static String src = "6 8 10\n" +
            "25 52 60\n" +
            "5 20 13\n" +
            "0 0 0";

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));
        //풀이
        int arr[] = new int[3];
        while (true){
            StringTokenizer str = new StringTokenizer(input.readLine());
            arr[0]= Integer.parseInt(str.nextToken());
            arr[1]= Integer.parseInt(str.nextToken());
            arr[2]= Integer.parseInt(str.nextToken());
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                break;
            }
            Arrays.sort(arr);
            if (arr[2] * arr[2] == arr[1] * arr[1] + arr[0] * arr[0]) {
                output.append("right").append("\n");
            }else{
                output.append("wrong").append("\n");
            }
        }
        System.out.print(output);
    }
}
