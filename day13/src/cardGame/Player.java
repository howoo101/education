package cardGame;

import java.util.Arrays;

public class Player {
	Card[] cards = new Card[5]; // 5장
	int money; // 소유한돈
	String name;
	String result; // 카드5장 결과
	int score; // 결과점수

	Player() {
		this("길동이", 1000);
	}

	Player(String name, int money) {
		this.name = name;
		this.money = money;
	}

	// 카드 5장 결과 판단
	public String getResult(Card[] cards) {
		System.out.println(Arrays.toString(cards));
	
		//숫자 판단
		int[] cArr = new int[Deck.NUM_MAX + 1];
		int pair = 0;
		for(int i = 0; i < cards.length; i++) {
			cArr[cards[i].number]++;
		}
		boolean threeCard = false;
		boolean fourCard = false;
		int straightCount = 0;
		boolean straight = false;
		boolean flush = true;
		
		
		for(int i = 1; i < cArr.length; i++) {
			//스트레이트 체크
			if(cArr[i] != 0) straightCount++;
			else straightCount = 0;
			if(flush && i < cards.length) {
				if(!(cards[i-1].shape.equals(cards[i].shape))) {
					flush = false;
				}
			}
			if(cArr[i] == 2) pair++;
			else if(cArr[i] == 3) threeCard = true;
			else if (cArr[i] == 4) fourCard = true;
			else if (straightCount == 5) straight = true;
		}	
		
			if(flush && straight) return "STRAIGHT FLUSH";
			if(flush) return "FLUSH";
			if(threeCard && pair == 1) return "FULL HOUSE";
			if(pair != 0) return pair+" PAIR";
			if(threeCard) return "THREE CARD";
			if(fourCard) return "FOUR CARD";
			if(straight) return "STRAIGHT";
		return "NO RANK";
	}

	public String toString() {
		return name + ": " + money;
	}
}
