package cardGame;

public class Card {
	String shape; // 하트 스페이드 다이아 클로바
	int number; // 1~13   1:A 2~13 J Q K
	
	Card(String shape, int number) {
		this.shape = shape;
		this.number = number;
	}
	
	public String toString() {
		return "("+shape + " , " + number + ")";
	}
}
