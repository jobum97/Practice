import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;


public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="quackqauckquack";
	
	static int n,k;

	static char[] sound;
	static boolean[] checked;
	static char[] quack = {'q', 'u', 'a', 'c', 'k'};
	static boolean error;
	static int duckNum;
	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));

		String str = input.readLine();
		sound=str.toCharArray();
		checked = new boolean[str.length()];
		duckNum=0;

		Quack(0);

		for (boolean i : checked) {
			if(!i){
				error=true;
				break;
			}
		}
		if(error){
			System.out.println(-1);
		}else{
			System.out.println(duckNum);
		}
	}

	public static void Quack(int start) {
		duckNum++;
		int index=start;
		int flag=0;
		int next=0;
		while (index < sound.length) {
			flag %= 5;
			if (sound[index] == quack[flag] && !checked[index]) { // quack 순서지키면서, 검사한적없는 곳인경우
		//		System.out.print(index+" "+sound[index]+" ");
				flag++;
				checked[index] = true;
			} else if (sound[index] == 'q' && !checked[index] && next==0) { // 다른 오리의 첫번째 q 잡아내기 + 검사한적없는
				next=index;
			}
			index++;
		}
		if (flag % 5 != 0) { //quack 을 온전히 마치면 flag %5 는 0이 되어야함
			error = true;
		}
		if(next>0){ //다른 오리 존재시 Quack 재귀
			Quack(next);
		}
	}
}
