import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }
    public static int solution(String str1, String str2) {
        int answer = 0;

        // 자카드 유사도 => 교집합 / 합집합
        // 문자열 2글자씩 끊어서 다중 집합 만들어서 자카드 유사도?
        // 문자열에서 영문자만 다중 집합의 재료 이외는 버림
        // 자카드 유사도 * 65536, 소수부분 버림

        //aa1+aa2	AAAA12
        // aa aa  AA AA AA

        ArrayList<String> cluster1 = makeCluster(str1);
        ArrayList<String> cluster2 = makeCluster(str2);

        answer = (int) (getSimilarity(cluster1, cluster2) * 65536);

        return answer;
    }

    public static double getSimilarity(ArrayList<String> cluster1, ArrayList<String> cluster2) {
        Collections.sort(cluster1);
        Collections.sort(cluster2);

        for (int i = 0; i < cluster1.size(); i++) {
            System.out.print(cluster1.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < cluster2.size(); i++) {
            System.out.print(cluster2.get(i) + " ");
        }
        System.out.println();

        ArrayList<String> intersection = getIntersection(cluster1, cluster2);
        ArrayList<String> union = getUnion(cluster1, cluster2);

        for (int i = 0; i < intersection.size(); i++) {
            System.out.print(intersection.get(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < union.size(); i++) {
            System.out.print(union.get(i) + " ");
        }
        System.out.println();

        System.out.println(intersection.size());
        System.out.println(union.size());
        if (intersection.size() == 0) {
            if (union.size() == 0) {
                return 1;
            }
            return 0;
        }

        return (double) intersection.size() / union.size();
    }


    public static ArrayList<String> getIntersection(ArrayList<String> cluster1, ArrayList<String> cluster2) {
        ArrayList<String> intersection = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i >= 0 && i < cluster1.size() && j >= 0 && j < cluster2.size()) {
            if (cluster1.get(i).equals(cluster2.get(j))) {
                intersection.add(cluster1.get(i));
                i++;
                j++;
            } else {
                if (cluster1.get(i).compareTo(cluster2.get(j)) > 0) {
                    j++;
                } else {
                    i++;
                }
            }
        }

        return intersection;
    }

    public static ArrayList<String> getUnion(ArrayList<String> cluster1, ArrayList<String> cluster2) {
        ArrayList<String> union = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i >= 0 && i < cluster1.size() && j >= 0 && j < cluster2.size()) {
            if (cluster1.get(i).equals(cluster2.get(j))) {
                union.add(cluster1.get(i));
                i++;
                j++;
            } else {
                if (cluster1.get(i).compareTo(cluster2.get(j)) > 0) {
                    union.add(cluster2.get(j++));
                } else {
                    union.add(cluster1.get(i++));
                }
            }
        }


        while (i < cluster1.size()) {
            union.add(cluster1.get(i++));
        }
        while (j < cluster2.size()) {
            union.add(cluster2.get(j++));
        }

        return union;
    }
    public static ArrayList<String> makeCluster(String input) {

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < input.length() - 1; i++) {
            char first = input.charAt(i);
            char second = input.charAt(i + 1);
            if (isValidChar(first) && isValidChar(second)) {
                list.add(merge(first, second));
            }
        }
        return list;
    }

    public static String merge(char input1, char input2) {
        String result = String.valueOf(input1) + input2;
        return result.toLowerCase();
    }

    public static boolean isValidChar(char input) {
        int ascll1 = input - 'a';
        int ascll2 = input - 'A';

        if (ascll1 >= 0 && ascll1<=26) {
            return true;
        }

        if (ascll2 >= 0 && ascll2<=26) {
            return true;
        }
        return false;
    }

}
