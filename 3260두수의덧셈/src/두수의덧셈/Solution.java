package 두수의덧셈;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output=new StringBuilder();
    static String src="2\n" +
			"1 2\n" +
			"100000000000000000000000007 99";
    
    public static void main(String arg[]) throws IOException {
        //input=new BufferedReader(new InputStreamReader(System.in));
        input=new BufferedReader(new StringReader(src));

		int t = Integer.parseInt(input.readLine());
		StringTokenizer str;
		int index;
		for (int testcase = 1; testcase <= t; testcase++) {
			str = new StringTokenizer(input.readLine());
			String N1 = str.nextToken();
			String N2 = str.nextToken();
			int N1l = N1.length();
			int N2l = N2.length();
			int[] num1 = new int[N1l];
			int[] num2 = new int[N2l];
			index=0;

			for (int i = 0; i < N1l; i++) {
				num1[i] = N1.charAt(N1l - i - 1) - '0';
			}
			for (int i = 0; i < N2l; i++) {
				num2[i] = N2.charAt(N2l - i - 1) - '0';
			}

		/*	System.out.println(Arrays.toString(num1));
			System.out.println(Arrays.toString(num2));*/

			int[] result = new int[Math.max(N1l, N2l)+1];

			while (index < N1l || index < N2l) {
				if (index < N1l) {
					result[index] += num1[index];
				}
				if (index < N2l) {
					result[index] += num2[index];
				}

				if(result[index]>9){
					result[index]-=10;
					result[index + 1]++;
				}
				index++;
			}

			output.append("#" + testcase + " ");
			if(result[result.length-1]>0){
				output.append(result[result.length-1]);
			}
			for (int i = result.length-2; i >= 0; i--) {
				output.append(result[i]);
			}
			output.append("\n");
		}
        System.out.print(output);
    }   
}