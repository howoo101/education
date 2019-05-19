package cardGame;

public class Dealer {
	Deck deck = new Deck();
	int battedMoney; //player들이 배팅한돈합산
	int index = 0;//카드뽑을때마다 인덱스 +=1
	final String[] scores = {"1 PAIR", "2 PAIR", "THREE CARD",
			"FOUR CARD", "FULL HOUSE", "STRAIGHT", "FLUSH", "STRAIGHT FLUSH"};
	
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
		//String 받아서 결과배열이랑 비교후 일치하면 인덱스 +1점 부여
		for(int i = 0; i < scores.length; i++) {
			if(result.equals(scores[i])) return i+1;
		}
		return 0;
	}
	
	//1등 찾기
	public Player getWinner(Player[] players) {
		int max = players[0].score;
		int winnerIdx = 0;
		if(players.length < 2) return players[winnerIdx];
		for(int i = 1; i < players.length; i++) {
			if(max < players[i].score) {
				max = players[i].score;
				winnerIdx = i;
			}
		}
		return players[winnerIdx];
	}
}
