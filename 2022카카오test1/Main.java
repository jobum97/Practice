import java.util.*;
public class Main {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<Character, Integer> termsMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            StringTokenizer str = new StringTokenizer(terms[i]);
            termsMap.put(str.nextToken().charAt(0), Integer.parseInt(str.nextToken()));
        }
        // 1~n 개인정보 약관 마다 보관 유효기간
        // 오늘 파기해야하는 개인정보 번호 구하기
        for (int i = 0; i < privacies.length; i++) {
            StringTokenizer str = new StringTokenizer(privacies[i]);
            String date = str.nextToken();
            char term = str.nextToken().charAt(0);

            if (!isValid(today, date, termsMap.get(term))) {

                answer.add(i + 1);
            }
        }
        return answer;
    }

    private boolean isValid(String today, String date, Integer term) {
        // date(수집일자)+ term가 today를 초과하면 true

        System.out.println(today+" "+date);
        String[] todays = today.split("\\.");
        String[] dates = date.split("\\.");

        int todayY = Integer.parseInt(todays[0]);
        int todayM = Integer.parseInt(todays[1]);
        int todayD = Integer.parseInt(todays[2]);

        int dateY = Integer.parseInt(dates[0]);
        int dateM = Integer.parseInt(dates[1]);
        int dateD = Integer.parseInt(dates[2]);

        dateM += term;
        while (dateM > 12) {
            dateM -= 12;
            dateY++;
        }

        System.out.println(todayY+" "+todayM+ " "+todayD);
        System.out.println(dateY + " " + dateM + " " + dateD);

        if (dateY > todayY) {
            return false;
        } else if (dateY == todayY && dateM > todayM) {
            return false;
        } else if (dateY == todayY && dateM == todayM && dateD > todayD) {
            return false;
        }

        return true;
    }
}
