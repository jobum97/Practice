import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

class CardPack{
	int NumOfCard;
	int Cost;
	float costPerCard;
	
	public CardPack(int NumOfCard, int cost) {
		this.NumOfCard=NumOfCard;
		this.costPerCard=(float)cost/NumOfCard;
		this.Cost=cost;
	}
}


public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src ="4\r\n"
			+ "3 6 9 12";
	
	static int N,cost;
	static ArrayList<CardPack> data;
	
	public static void main(String args[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		
		N= Integer.parseInt(input.readLine());
		
		StringTokenizer str=new StringTokenizer(input.readLine());
		
		data=new ArrayList<CardPack>();
		cost=0;
		
		for(int i=1;i<=N;i++) {
			data.add(new CardPack(i,Integer.parseInt(str.nextToken())));
		}
		
		//카드 당 가격 내림차순으로 정렬
		Collections.sort(data, new Comparator<CardPack>() {
			@Override
			public int compare(CardPack o1, CardPack o2) {
				// TODO Auto-generated method stub
				if(o1.costPerCard<o2.costPerCard) {
					return 1;
				}else if(o1.costPerCard>o2.costPerCard) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		
		////////////////////////////////////////////////////////
		for(int i=0;i<N;i++) {
			System.out.println(data.get(i).NumOfCard+" "+data.get(i).costPerCard);
		}
		System.out.println();
		////////////////////////////////////////////////////////
		
		sol(N,0);
		System.out.println(cost);
		
	}
	
	//구매할 카드 수를 받아 계산하는 메소드
	public static void sol(int card, int index) {
		
		int num,packs;
		
		while(card>0) {
			//System.out.println(card+" "+index+" "+data.get(index).costPerCard);
			num=data.get(index).NumOfCard; //카드팩의 카드 개수
			packs=card/num; //카드팩개수 
			
			if(packs>0) { //구매한다면
				cost+=packs*data.get(index).Cost; //가격 계산
				card-=packs*num; //구매하는 카드개수 만큼 카드 개수 빼줌
				index=-1;
			}
			index++;
		}
		
		
	}
}