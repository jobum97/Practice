import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        System.out.println(getPhoneNumbers("Afghanistan", "656445445"));
    }

    public static String getPhoneNumbers(String country, String phoneNumber) {
        // +<Calling Code><space><Phone Number> 나 <지역> 으로 api 호출해서 폰번호 받아온다
        //https://jsonmock.hackerrank.com/api/countries?name=<country>
        // 지역명으로 호출해서 지역번호 알아내서 지역번호 + 폰번호해서 리턴

        //country = country.replace(" ", "");

        boolean isValid = true;
        ArrayList<Integer> code = new ArrayList<>();
        try {
            URL url = new URL("https://jsonmock.hackerrank.com/api/countries?name=" + country);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            conn.setRequestMethod("GET"); // http 메서드
            conn.setRequestProperty("Content-Type", "application/json"); // header Content-Type 정보
            conn.setRequestProperty("auth", "myAuth"); // header의 auth 정보
            conn.setDoOutput(true); // 서버로부터 받는 값이 있다면 true

            // 서버로부터 데이터 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            String json = response.toString();
            JSONObject objData = (JSONObject)new JSONParser().parse(json);

            JSONArray arrData = (JSONArray)objData.get("data");

            //System.out.println(arrData);
            //JSONObject code = (JSONObject)arrData.get("callingCodes");
            //JSONArray codes = (JSONArray)objData.get("callingCodes");

            JSONObject tmp= (JSONObject)arrData.get(0);
            // JSONArray tmpArr;
            JSONArray codes = (JSONArray)tmp.get("callingCodes");
            System.out.println(codes);
            for (int i = 0; i < codes.size(); i++) {
                code.add(Integer.parseInt(codes.get(i).toString()));
            }

        } catch (Exception e) {
            e.printStackTrace();
            isValid = false;
        }
        Collections.sort(code, Collections.reverseOrder());

        if (isValid) {
            return "+" + code.get(0) + " " + phoneNumber;
        } else {
            return "-1";
        }
    }
}
