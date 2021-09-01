import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String[] src = {"Enter uid123 uid1234", "Leave uid1234", "Enter uid4567 uid123", "Change uid4567 uid1234", "Leave uid4567"};

	public static void main(String arg[]) throws IOException {

		Solution(src);
	}

	public static void Solution(String[] record) {

		HashMap<String, String> idNicknameMap = new HashMap<>();
		int printCnt = 0;

		//최종 닉네임 알기위해 한번 돌림
		for (int i = record.length - 1; i >= 0; i--) {
			StringTokenizer str = new StringTokenizer(record[i]);
			String order = str.nextToken(); //명령어
			String id = str.nextToken();  //아이디

			//입장하거나 Change 할때 닉네임이 바뀜
			//입장 명령어
			if (order.equals("Enter")) {
				if (!idNicknameMap.containsKey(id)) {
					String nickName = str.nextToken(); //닉네임
					idNicknameMap.put(id, nickName);
				}
				printCnt++;
			} // 나가기 명령어
			else if (order.equals("Leave")) {
				printCnt++;
			} //닉네임 변경 명령어
			else if (order.equals("Change")) {
				if (!idNicknameMap.containsKey(id)) {
					String nickName = str.nextToken(); //닉네임
					idNicknameMap.put(id, nickName);
				}
			}
		}
		String result[] = new String[printCnt];
		int j = 0;

		for (int i = 0; i < record.length; i++) {
			StringTokenizer str = new StringTokenizer(record[i]);

			String order = str.nextToken(); //명령어
			String id = str.nextToken();  //아이디
			String nickName = idNicknameMap.get(id);
			System.out.println(id + " " + nickName);
			//입장 명령어
			if (order.equals("Enter")) {
				result[j] = nickName + "님이 들어왔습니다.";
				j++;
			} // 나가기 명령어
			else if (order.equals("Leave")) {
				result[j] = nickName + "님이 나갔습니다.";
				j++;
			}

		}

		System.out.println(Arrays.toString(result));

	}
}
