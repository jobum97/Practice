import java.util.Arrays;

public class Main {

    public int solution(int[][] queries) {
        int answer = 0;

        // 배열에 원소 추가
        // 배열의 크기는 생성될때 결정, 원소 추가시 꽉 차있으면 더큰 배열로 복사 +추가
        // 새로운 배열의 크기는 원소들 크기 커버하는 값 중 2의 거듭제곱 중 가장 작은 값
        // 복사된 원소의 개수를 구해야함

        // 배열 번호, 배열 크기, 복사한 원소 갯수
        int arrSize[] = new int[1001];
        int elements[] = new int[1001];

        for (int i = 0; i < queries.length; i++) {
            int arrNum = queries[i][0];
            int elementQuantity = queries[i][1];
            answer += solQuery(arrNum, elementQuantity, arrSize, elements);
        }
        System.out.println(Arrays.toString(arrSize));
        System.out.println(Arrays.toString(elements));

        return answer;
    }

    // 복사되는 원소 갯수 리턴
    public int solQuery(int arrNum, int elementQuantity, int arrSize[], int elements[]){
        int beforeSize = arrSize[arrNum];
        int beforeQuantity = elements[arrNum];

        elements[arrNum] += elementQuantity;
        arrSize[arrNum] = setArrSize(elements[arrNum]);


        return getAnswer(beforeSize, beforeQuantity, elements[arrNum]);
    }
    // 이전 사이즈, 이전 수량,새로운 수량으로 옮겨지는 원소 수 구함
    public int getAnswer(int beforeSize, int beforeQ, int afterQ){
        int answer = 0;
        // 이전 배열 초과시만 원소 옮겨짐
        if (afterQ > beforeSize) {
            System.out.println(afterQ+" "+beforeSize+" "+beforeQ);
            return beforeQ;
        }

        return answer;
    }

    // n 이상이면서 2의 거듭제곱 수 중 가장 작은 값
    public int setArrSize(int n){
        int i = 1;
        while (i < n) {
            i *= 2;
        }
        System.out.println(n + " " + i);
        return i;
    }


}
