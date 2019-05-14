package pr7;
class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck() {
		int num = 0;
		
		for(int i = 0; i < CARD_NUM; i++) {
			num = (i%10) + 1;
			boolean isKwang = (i < 10) &&
					(num==1 || num==3 || num==8);
//			if(i/10 == 0) {
//				num = i + 1;
//				if(i != 0 && i != 2 && i != 7 ) isKwang = false; 	
//			} else {
//				num = (i%10)+1;
//				isKwang = false;
//			}
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
		if(index < 0 || index >= CARD_NUM) //index의 유효성을 검사한다.
			return null;
		return this.cards[index];
	}
	
	public SutdaCard pick() {
		return pick((int)(Math.random()*CARD_NUM));
	}
}

class SutdaCard {
	final private int num;
	final private boolean isKwang;
	
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
