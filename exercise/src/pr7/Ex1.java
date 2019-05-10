package pr7;
class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck() {
		int num = 0;
		boolean isKwang = true;
		for(int i = 0; i < CARD_NUM; i++) {
			isKwang = true;
			if(i/10 == 0) {
				num = i + 1;
				if(i != 0 && i != 2 && i != 7 ) isKwang = false; 	
			} else {
				num = (i%10)+1;
				isKwang = false;
			}
			cards[i] = new SutdaCard(num,isKwang);
		}
	}
	
	public void shuffle() {
		for(int i = 0; i < this.CARD_NUM; i++) {
			int idx = (int)(Math.random()*CARD_NUM);
			SutdaCard tmp = this.cards[i];
			cards[i] = cards[idx];
			cards[idx] = tmp;
		}
	}
	
	public SutdaCard pick(int index) {
		return this.cards[index];
	}
	
	public SutdaCard pick() {
		return this.cards[(int)(Math.random()*CARD_NUM)];
	}
}

class SutdaCard {
	private int num;
	private boolean isKwang;
	
	SutdaCard() {
		this(1,true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	//info() 대신 Object클래스의 toString()을 오버라이딩
	public String toString() {
		return num + ( isKwang ? "K":"");
	}
}


public class Ex1 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		
		for(int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i]+",");
		}
	}
}
