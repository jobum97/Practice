import java.util.*;
public class Main {

    public static void main(String[] args) {
        ArrayList<String> answer = solution(new String[]{"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"});
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }
    public static ArrayList<String> solution(String[] commands) {
        ArrayList<String> answer = new ArrayList<>();

        String[][] table = new String[6][6];

        int[][] mergeList = new int[6][6];

        for (int i = 1; i < mergeList.length; i++) {
            for (int j = 1; j < mergeList.length; j++) {
                mergeList[i][j] = 50 * (i - 1) + j;
            }
        }


        for (int i = 0; i < commands.length; i++) {
            StringTokenizer str = new StringTokenizer(commands[i]);
            String order = str.nextToken();

            System.out.println(commands[i]);
            for (int j = 0; j < table.length; j++) {
                System.out.println(Arrays.toString(table[j]));
            }
            System.out.println("---------------------");
            for (int j = 0; j < table.length; j++) {
                System.out.println(Arrays.toString(mergeList[j]));
            }
            System.out.println("============================");

            if (order.equals("UPDATE") && str.countTokens() == 3) {
                int row = Integer.parseInt(str.nextToken());
                int col = Integer.parseInt(str.nextToken());
                String value = str.nextToken();
                int linkRow = (mergeList[row][col] / 50) + 1;
                int linkCol = mergeList[row][col] % 50;
                table[linkRow][linkCol] = value;

            }else if (order.equals("UPDATE") && str.countTokens() == 2){
                String value1 = str.nextToken();
                String value2 = str.nextToken();
                for (int r = 1; r < table.length; r++) {
                    for (int c = 1; c < table[r].length; c++) {
                        if (table[r][c] != null && table[r][c].equals(value1)) {
                            table[r][c] = value2;
                        }
                    }
                }

            }
            else if (order.equals("MERGE")) {
                int row1 = Integer.parseInt(str.nextToken());
                int col1 = Integer.parseInt(str.nextToken());
                int row2 = Integer.parseInt(str.nextToken());
                int col2 = Integer.parseInt(str.nextToken());

                int origin1 = mergeList[row1][col1];
                int origin1row = origin1 / 50 + 1;
                int origin1col = origin1 % 50;
                String origin1Value = table[origin1row][origin1col]; // 기존 값

                int origin2 = mergeList[row2][col2]; // 병합되는 쪽의 뿌리
                int origin2row = origin2 / 50 + 1;
                int origin2col = origin2 % 50;
                String origin2Value = table[origin2row][origin2col]; // 기존 값
                int targetNum = (row1 - 1) * 50 + col1;


                // 병합당하는 쪽 처리 (연결 + 값 초기화)
                for (int r = 1; r < table.length; r++) {
                    for (int c = 1; c < table.length; c++) {
                        if (mergeList[r][c] == origin2) {
                            mergeList[r][c] = targetNum;
                            table[r][c] = null;
                        }
                    }
                }

                // 기존 무리 중심 옮기기
                for (int r = 1; r < table.length; r++) {
                    for (int c = 1; c < table.length; c++) {
                        if (mergeList[r][c] == origin1) {
                            mergeList[r][c] = targetNum;
                        }
                    }
                }
                table[origin1row][origin1col] = null;
                // 만약 병합하는쪽의 값이 없으면 병합되는 쪽 값 가져오기
                if (origin1Value == null) {
                    table[row1][col1] = origin2Value;
                }else{
                    table[row1][col1] = origin1Value;
                }


            } else if (order.equals("UNMERGE")) {
                int row = Integer.parseInt(str.nextToken());
                int col = Integer.parseInt(str.nextToken());

                int linkRow = (mergeList[row][col] / 50) + 1;
                int linkCol = mergeList[row][col] % 50;
                int origin = mergeList[row][col];
                String value = table[linkRow][linkCol];

                // 연결 해제 + 값 초기화
                for (int r = 1; r < table.length; r++) {
                    for (int c = 1; c < table.length; c++) {
                        if (mergeList[r][c] == origin) {
                            mergeList[r][c] = (r - 1) * 50 + c;
                            table[r][c] = null;
                        }
                    }
                }
                if(value != null){
                    table[row][col] = value;
                }


            } else if (order.equals("PRINT")) {
                int row = Integer.parseInt(str.nextToken());
                int col = Integer.parseInt(str.nextToken());
                int linkRow = (mergeList[row][col] / 50) + 1;
                int linkCol = mergeList[row][col] % 50;

                if (table[linkRow][linkCol] == null) {
                    answer.add("EMPTY");
                }else{
                    answer.add(table[linkRow][linkCol]);
                }

            }
        }

        return answer;
    }


}
