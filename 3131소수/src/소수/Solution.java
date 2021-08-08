package 소수;

public class Solution {
   
   static int target=1000000;
   
   public static void main(String args[]) {
      boolean[] data=new boolean[target+1];
      int sqrt_target=(int) Math.sqrt(target);
      data[1]=false;
       
      for(int i=2;i<target+1;i++) {
         data[i]=true;
      }
      for(int n=2;n<sqrt_target;n++) {
         if(data[n]==false) {
            continue;
         }
         
         for(int m=2;(m*n)<=target;m++) {
            data[m*n]=false;
            //System.out.println(m*n);
         }
         
      }
      System.out.print(2);
      for(int i=3;i<target+1;i++) {
         if(data[i]==true) {
            System.out.print(" "+i);
         }
      }
   }
}