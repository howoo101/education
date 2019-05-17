package cardGame;

public class Dealer {
	Deck deck = new Deck();
	int battedMoney; //player들이 배팅한돈합산
	int index = 0;//카드뽑을때마다 인덱스 +=1
	
	//덱 섞기
	public void shuffle() {
			for(int i = 0; i < Deck.CARD_NUM; i++) {
				int num = (int)(Math.random()* Deck.CARD_NUM);
				Card tmp = deck.cards[i];
				deck.cards[i] = deck.cards[num];
				deck.cards[num] = tmp;
			}
		}
	
	//플레이어들에게 카드 배포
	public void deal(Player player) {
		for(int i = 0; i < player.cards.length; i++) {
			player.cards[i] = deck.pickCard(index++);
		}
	}
	
	//결과 점수 반환
	public int getResultPoint(String result) {
		return 0;
	}
	
	//1등 찾기
	public Player getWinner(int score) {
		return new Player();
	}
}
