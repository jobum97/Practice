import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.util.Map.*;


public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src = "3 2 3\n" +
			"noodle 10000\n" +
			"tteokbokki 5000\n" +
			"sundae 7000\n" +
			"cutlet 12000\n" +
			"friedrice 8000\n" +
			"dumpling\n" +
			"potatochips\n" +
			"fishcake\n" +
			"7\n" +
			"noodle\n" +
			"noodle\n" +
			"cutlet\n" +
			"friedrice\n" +
			"cutlet\n" +
			"potatochips\n"+
			"potatochips";

	static int A, B, C, N, range;
	static boolean BmenuFlag, CmenuFlag, OrderFlag;
	static HashMap<String, Integer> Memu; //메뉴 - 가격
	static HashMap<String, Character> MemuGroup; //메뉴 - 종류
	static HashMap<Character, Long> FeeCount; //메뉴종류 - 총가격

	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));

		StringTokenizer str;
		str = new StringTokenizer(input.readLine());

		A = Integer.parseInt(str.nextToken()); //일반 메뉴
		B = Integer.parseInt(str.nextToken()); //특별 메뉴 , B메뉴 제외 총 2만원 이상 주문해야 가능
		C = Integer.parseInt(str.nextToken()); //서비스 메뉴 , C메뉴 제외 총 5만원 이상 주문해야됨

		Memu = new HashMap<>();
		MemuGroup = new HashMap<>();
		FeeCount = new HashMap<>();
		FeeCount.put('A', 0L);
		FeeCount.put('B', 0L);
		FeeCount.put('C', 0L);


		BmenuFlag = false; //B메뉴 먹었는지
		CmenuFlag = false; //C메뉴 먹었는지
		OrderFlag = true; //주문이 맞는지
		//메뉴들 입력
		range = A;
		for (int i = 0; i < range; i++) {
			str = new StringTokenizer(input.readLine());
			String name = str.nextToken();
			Memu.put(name, Integer.parseInt(str.nextToken()));
			MemuGroup.put(name, 'A');
		}
		range += B;
		for (int i = A; i < range; i++) {
			str = new StringTokenizer(input.readLine());
			String name = str.nextToken();
			Memu.put(name, Integer.parseInt(str.nextToken()));
			MemuGroup.put(name, 'B');
		}
		range += C;
		for (int i = A + B; i < range; i++) {
			String name = input.readLine();
			Memu.put(name, 1);
			MemuGroup.put(name, 'C');
		}

		/*for (Entry<String, Integer> entry : Memu.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		for (Entry<String, Character> entry : MemuGroup.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}*/

		N = Integer.parseInt(input.readLine()); //주문수

		for (int i = 0; i < N; i++) {
			Order(input.readLine());
		}

		for (Entry<Character, Long> entry : FeeCount.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		//B메뉴 먹었는데 A메뉴 2만원 이상 주문하지 않은 경우
		if (BmenuFlag && FeeCount.get('A') < 20000) {
			OrderFlag = false;
		}
		// C메뉴 먹었는데 A+B 합쳐서 5만원 미만으로 먹은 경우
		if (CmenuFlag && FeeCount.get('A') + FeeCount.get('B') < 50000) {
			OrderFlag = false;
		}
		// C메뉴는 1개 초과로 못 시킴
		if (FeeCount.get('C') > 1) {
			OrderFlag = false;
		}

		if (OrderFlag) {
			System.out.println("Okay");
		} else {
			System.out.println("No");
		}
	}

	public static void Order(String menu) {
		String temp;
		char menuClass;
		long Fee;
		if (Memu.containsKey(menu)) {
			menuClass = MemuGroup.get(menu);
			Fee = Memu.get(menu) + FeeCount.get(menuClass);
			FeeCount.put(menuClass, Fee);

			if (menuClass == 'B') {
				BmenuFlag = true;
			}
			if (menuClass == 'C') {
				CmenuFlag = true;
			}
		}

	}

}
