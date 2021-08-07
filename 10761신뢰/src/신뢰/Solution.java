package 신뢰;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution {
   
   
   static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output =new StringBuilder(); 
    static String src="3\r\n"
         + "4 B 2 O 1 O 2 B 4\r\n"
         + "3 B 5 B 8 O 100\r\n"
         + "2 O 2 O 1";

   public static void main(String args[]) throws IOException {
       //input= new BufferedReader(new InputStreamReader(System.in));
       input=new BufferedReader(new StringReader(src));
       StringTokenizer str;

       int t = Integer.parseInt(input.readLine());

       int time;

       for (int testcase = 1; testcase <= t; testcase++) {

           str = new StringTokenizer(input.readLine());
           int command = Integer.parseInt(str.nextToken()); //명령 개수
           int[] temp = {1, 1, 1, 1, 0}; //B 최소, B 최대 , O 최소, O 최대, answer

           for (int i = 0; i < command; i++) {
               String type = str.nextToken();
               int num = Integer.parseInt(str.nextToken());

               if (type.equals("B")) { //B인 경우
                   sol(num, temp, 0, 2);
               } else { //O 인 경우
                   sol(num, temp, 2, 0);
               }
           }
           System.out.println("///////////////////////////////");
           output.append("#" + testcase + " " + temp[4] + "\n");
       }
       System.out.println(output);
   }

    public static void sol(int num, int[] temp, int t1, int t2) {
        int tmp = 1;
        //t1 이 선택된 것(최소)의 인덱스
        if (num < temp[t1]) {  // 좌표가 최소보다 작으면
            tmp = temp[t1] - num + 1; // 최소 - 좌표 +1 을 더해줌
        } else if (num > temp[t1 + 1]) { //좌표가 최대보다 크면
            tmp = num - temp[t1 + 1] + 1; //좌표 - 최대 +1 을 더해줌
        }

        temp[4] += tmp; //걸리는 시간(결과)에 tmp 더해줌
        temp[t1] = temp[t1 + 1] = num; //선택된것의 최대 최소 좌표로 초기화해줌
        temp[t2] -= tmp; //선택하지 않은 것의 최소에 tmp 빼줌
        temp[t2 + 1] += tmp; // 최대에는 더해줌
        System.out.println(Arrays.toString(temp)+" "+tmp);
    }
      
}
