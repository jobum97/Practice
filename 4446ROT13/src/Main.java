import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 static StringBuilder output = new StringBuilder();
	static String src = "b k x z n h d c w g p v j q t s r l m f)." +
			"b k x z n h d c w g p v j q t s r l m f).";


	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		String line = "";
		while ((line=input.readLine()) != null) {

			char[] data = line.toCharArray();
			char[] mLetter = {'a', 'i', 'y', 'e', 'o', 'u'};
			char[] cLetter = {'b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f'};

			System.out.println(String.valueOf(data));
			for (int i = 0; i < data.length; i++) {

				boolean isBigLetter = false;
				if (data[i] - 'A' >= 0 && data[i] - 'A' <= 25) {
					isBigLetter = true;
				}

				if (data[i] == 'a' || data[i] == 'i' || data[i] == 'y' || data[i] == 'e' || data[i] == 'o' || data[i] == 'u' || data[i] == 'A' || data[i] == 'I' || data[i] == 'Y' || data[i] == 'E' || data[i] == 'O' || data[i] == 'U') {
					if (isBigLetter) {
						data[i] = Character.toUpperCase(searchLetter(mLetter,Character.toLowerCase(data[i]),3));
					}else{
						data[i] = Character.toLowerCase(searchLetter(mLetter,Character.toLowerCase(data[i]),3));
					}
				} else {
					if ((data[i] - 'A' >= 0 && data[i] - 'A' <= 25) || (data[i] - 'a' >= 0 && data[i] - 'a' <= 25)) {
						if (isBigLetter) {
							data[i] = Character.toUpperCase(searchLetter(cLetter,Character.toLowerCase(data[i]),10));
						}else{
							data[i] = Character.toLowerCase(searchLetter(cLetter,Character.toLowerCase(data[i]),10));
						}
					}
				}
			}


			System.out.println(String.valueOf(data));
		}
	}

	public static char searchLetter(char[] data, char cur, int next) {
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == cur) {
				index = i;
			}
		}

		return data[(index + data.length - next) % data.length];
	}
}
