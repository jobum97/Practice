import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	 static StringBuilder output = new StringBuilder();
	 static String src = "9";
	 static int n, m, count;
	static int moveSet[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public static void main(String[] args) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		int n = Integer.parseInt(input.readLine());
		int x = 0;
		int y = 0;
		int tick = 0;
		int mult = 1;
		int move = 0;
		int time = 0;
		for (int i = 0; i < n; i++) {
			if (tick == 2) {
				mult++;
				tick = 0;
			}
			x += moveSet[move][0] * mult;
			y += moveSet[move][1] * mult;
			time += Math.abs(moveSet[move][0] * mult) + Math.abs(moveSet[move][1] * mult);
			if (time >= n) {
				x -= moveSet[move][0] * (time - n);
				y -= moveSet[move][1] * (time - n);
				//System.out.println(time);
				break;
			}
			//System.out.println(moveSet[move][0] * mult + " " + moveSet[move][1] * mult);
			move = (move + 1) % 4;
			tick++;
		}

		System.out.println(x + " " + y);


	}
}