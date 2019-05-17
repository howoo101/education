package cardGame;

public class Deck {
	static final int SHAPE_MAX = 4; //모양 개수
	static final int NUM_MAX = 13; //숫자 개수
	static final int CARD_NUM = NUM_MAX * SHAPE_MAX;
	static final String[] shapes = {"HEART","SPADE","DIAMOND","CLOVER"};
	
	Card[] cards = new Card[CARD_NUM]; //52장
	
	Deck() {
		makeDeck(); //덱만들기
	}
	
	//덱만들기
	public void makeDeck() {
		for(int i = 0; i < SHAPE_MAX; i++) {
			for(int j = 0; j < NUM_MAX; j++) {
				cards[(NUM_MAX*i)+j] = new Card(shapes[i],j+1);
			}
		}
	}
	
	//카드 한장뽑기
	public Card pickCard(int index) {
		return cards[index];
	}
	
}
