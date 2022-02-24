import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src =     "8\n" +
            "Foo1Bar\n" +
            "Foo00012Bar\n" +
            "Foo3bar\n" +
            "Fo6Bar\n" +
            "Foo12Bar\n" +
            "Foo3Bar\n" +
            "000BAR01\n" +
            "00BAR001";

    static int N, M, data[][];

    public static void main(String[] args) throws IOException {
        //input= new BufferedReader(new InputStreamReader(System.in));
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());

        String strings[] = new String[N];

        for (int i = 0; i < N; i++) {
            strings[i] = input.readLine();
        }

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                ArrayList<String> A = toArr(o1);
                ArrayList<String> B = toArr(o2);
                //System.out.println("비교 : " + A.toString() + " " + B.toString());
                for (int i = 0; i < Math.min(A.size(), B.size()); i++) {
                    //System.out.println(" 문자 비교 : " + A.get(i) + " " + B.get(i));
                    //둘다 숫자인 경우
                    if (isNum(A.get(i)) && isNum(B.get(i))) {
                        int result = compareNum(A.get(i), B.get(i));
                        if (result != 0) {
                            return result;
                        }
                    } else if (isNum(A.get(i))) {
                        // A만 숫자인 경우
                        // A가 먼저 와야
                        return -1;
                    } else if (isNum(B.get(i))) {
                        // B만 숫자인 경우
                        // B가 먼저와야
                        return 1;
                    } else {
                        // 둘다 문자인 경우 AaBbCc...XxYyZz의 순서를 따른다.
                        // 두 문자가 다른 경우 우열 가리기
                        if (A.get(i).charAt(0) != B.get(i).charAt(0)) {
                            return compareChar(A.get(i).charAt(0), B.get(i).charAt(0));
                        }
                    }
                }
                return A.size() - B.size();
            }
        });

        for (int i = 0; i < N; i++) {
            output.append(strings[i] + "\n");
        }

        System.out.print(output);
    }


    public static ArrayList<String> toArr(String input) {
        ArrayList<String> arr = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < input.length(); i++) {
            //숫자면
            if (input.charAt(i) - '0' >= 0 && input.charAt(i) - '9' <= 0) {
                temp += input.charAt(i);
            } else {
                if (!temp.equals("")) {
                    arr.add(temp);
                    temp = "";
                }
                arr.add(String.valueOf(input.charAt(i)));
            }
        }
        if (!temp.equals("")) {
            arr.add(temp);
            temp = "";
        }
        return arr;
    }

    public static boolean isNum(String input) {
        if (input.length() > 1) {
            return true;
        } else {
            if (input.charAt(0) - '0' >= 0 && input.charAt(0) - '9' <= 0) {
                return true;
            } else {
                return false;
            }
        }
    }
    public static int compareNum(String A,String B){

        int indexA = 0;
        int indexB = 0;
        boolean isRealA = false;
        boolean isRealB = false;
        int realLengthA = 0;
        int realLengthB = 0;

        while (indexA < A.length()) {

            if (!isRealA) {
                if (A.charAt(indexA) != '0') {
                    isRealA = true;
                    realLengthA = A.length() - indexA;
                } else {
                    indexA++;
                }
            }else{
                break;
            }
        }

        while (indexB < B.length()) {
            if (!isRealB) {
                if (B.charAt(indexB) != '0') {
                    isRealB = true;
                    realLengthB = B.length() - indexB;
                } else {
                    indexB++;
                }
            }else {
                break;
            }
        }

//        System.out.println(A + " " + B);
//        System.out.println(realLengthA+" "+realLengthB);
//        System.out.println(indexA + " " + indexB);
        int zeroA = indexA;
        int zeroB = indexB;
        if (realLengthA == realLengthB) {
            while (indexA < A.length()) {
                if (A.charAt(indexA) != B.charAt(indexB)) {
                    return A.charAt(indexA) - B.charAt(indexB);
                }
                indexA++;
                indexB++;
            }
        } else {
            return realLengthA - realLengthB;
        }
        //System.out.println("0 개수로 비교");
        return zeroA - zeroB;
    }

    public static int compareChar(char A, char B) {
        char tempA = Character.toLowerCase(A);
        char tempB = Character.toLowerCase(B);

        //문자가 같은 경우
        if (tempA == tempB) {
            if (A == B) {
                return 0;
            } else {
                //대문자가 아스키코드상 작음
                return A - B;
            }
        } else {
            return tempA - tempB;
        }
    }
}
