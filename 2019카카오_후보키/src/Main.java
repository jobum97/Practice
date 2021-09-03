import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();


    static int N;
    static boolean[] checked;

    public static void main(String arg[]) throws IOException {

        //학번, 이름, 전공, 학년,
        //학번이 key 값, 겹치지 않음
        String[][] relation = {{"100", "ryan", "music", "2", "game"},
                {"200", "apeach", "music", "2", "movie"},
                {"300", "tube", "computer", "3", "soccer"},
                {"400", "con", "computer", "4", "sports"},
                {"500", "muzi", "music", "3", "books"},
                {"600", "apeach", "music", "4", "poems"}};

        System.out.println(solution(relation));

    }

    public static int solution(String[][] relation) {
        ArrayList<Integer> candidateKey = new ArrayList<>();

        int rowLen = relation.length;
        int colLen = relation[0].length;

        //비트마스킹으로 모든 경우의 조합 시도
        for(int set = 1 ; set < (1 << colLen) ; set++) {
            // 최소성 검사
            if(!isMinimal(set, candidateKey))
                continue;
            System.out.println(Integer.toBinaryString(set));
            // 유일성 검사
            if(isUnique(set, rowLen, colLen, candidateKey, relation)) {
                //System.out.println(Integer.toBinaryString(set));
                candidateKey.add(set);
            }
        }

        return candidateKey.size();
    }

    private static boolean isUnique(int set, int rowLen, int colLen, ArrayList<Integer> candidateKey, String[][] relation) {
        HashMap<String, String> map = new HashMap<>();

        //자릿수 구하기
        for(int row = 0 ; row < rowLen ; ++row) {
            String dataByKeySet = "";

            for(int th = 0 ; th < colLen ; ++th) {
                //set과 같다면 dataByKeySet에 추가
                if((set & (1 << th)) != 0) {
                    dataByKeySet += relation[row][th];
                }
            }

            //이미 있다면 => 유일성 깨기에 false
            if(map.containsKey(dataByKeySet))
                return false;
            //없다면 유일성 지킴, hashmap에 저장
            else
                map.put(dataByKeySet, dataByKeySet);
        }

        return true;
    }

    private static boolean isMinimal(int set, ArrayList<Integer> candidateKey) {
        //이미 후보키에 선정된 조합이 들어있다면 최소성을 깸
        for(int key : candidateKey) {
            //key가 set에 포함된다면
            //즉 set이 이미 선정된 조합을 포함한 상태라는 것
            if((key & set) == key)
                return false;
        }

        return true;
    }

}