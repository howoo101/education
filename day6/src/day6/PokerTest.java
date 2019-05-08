package day6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Card {
	String kind;
	int num;

	Card(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}

	Card() {
		this("SPADE", 1);
	}
}

class PokerTest {
	// 5장의 카드 객체가 담긴 cArr을 받아서
	// 랭킹을 문자열로 반환
	// 아래의 메서드를 완성하시오.

	String checkRank(Card[] cArr) {
		// 1.같은 숫자의 카드가 몇개인지 세는 것.(pair, three card, four card)
		int[] cntArr = new int[14]; // 0 ~ 13
		
		for(int i = 0; i < cArr.length; i++) {
			cntArr[cArr[i].num]++;
		}
		
		int pair = 0;
		//쓰리카드 포카드는 한번밖에 나올 수 없음
		boolean threeCard = false;
		boolean fourCard = false;
		
		
		for(int i = 0; i < cntArr.length; i++) {
			if(cntArr[i] == 2) pair++;
			if(cntArr[i] == 3) threeCard = true;
			if(cntArr[i] == 4) fourCard = true;
		}
		
		if(pair== 1 && threeCard == true) return "FULL HOUSE";
		if(fourCard) return "FOUR CARD";
		if(threeCard) return "THREE CARD";
		if(pair > 0) return pair + " PAIR";
		
		// 2. 같은 무늬의 카드가 5장인가
		// 3. 모든숫자가 연속적인가
		return "NO RANK";
	}

	@Test
	// 같은 숫자가 2개 있으면 페어(pair)라고 한다.
	// 페어가 1개면 "1 PAIR"를 2개면 "2 PAIR"를 반환
	void pairTest() {
		Card[] cArr = { new Card("SPADE", 1), new Card("DIAMOND", 1), new Card("HEART", 3), new Card("CLUB", 4),
				new Card("SPADE", 5) };
		assertTrue(checkRank(cArr).equals("1 PAIR"));
	}

	@Test
	// 같은 숫자가 2개 있으면 페어(pair)라고 한다.
	// 페어가 1개면 "1 PAIR"를 2개면 "2 PAIR"를 반환
	void pairTest2() {
		Card[] cArr = { new Card("SPADE", 1), new Card("DIAMOND", 1), new Card("HEART", 3), new Card("CLUB", 4),
				new Card("SPADE", 4) };
		assertTrue(checkRank(cArr).equals("2 PAIR"));
	}

	@Test
	// 같은 숫자가 3개 있으면 쓰리카드("THREE CARD")라고 한다.
	void threeCardTest() {
		Card[] cArr = { new Card("SPADE", 1), new Card("DIAMOND", 1), new Card("HEART", 1), new Card("CLUB", 4),
				new Card("SPADE", 2) };
		assertTrue(checkRank(cArr).equals("THREE CARD"));
	}

	@Test
	// 같은 숫자가 4개 있으면 쓰리카드("FOUR CARD")라고 한다.
	void fourCardTest() {
		Card[] cArr = { new Card("SPADE", 1), new Card("DIAMOND", 1), new Card("HEART", 1), new Card("CLUB", 1),
				new Card("SPADE", 4) };
		assertTrue(checkRank(cArr).equals("FOUR CARD"));
	}

	@Test
	// 쓰리카드와 원 페이가 같이 있으면 풀 하우스("FULL HOUSE")라고 한다.
	void fullHouseTest() {
		Card[] cArr = { new Card("SPADE", 1), new Card("DIAMOND", 1), new Card("HEART", 1), new Card("CLUB", 4),
				new Card("SPADE", 4) };
		assertTrue(checkRank(cArr).equals("FULL HOUSE"));
	}

	@Test
	// 카드의 숫자가 모두 연속인 경우 "STRAIGHT"를 반환
	// 1,2,3,4,5 또는 4,5,6,7,8 인 경우
	void straightTest() {
		Card[] cArr = { new Card("SPADE", 1), new Card("DIAMOND", 2), new Card("HEART", 3), new Card("CLUB", 4),
				new Card("SPADE", 5) };
		assertTrue(checkRank(cArr).equals("STRAIGHT"));
	}

	@Test
	// 카드의 무늬가 모두 같은 경우 "FLUSH"를 반환
	void flushTest() {
		Card[] cArr = { new Card("SPADE", 1), new Card("SPADE", 2), new Card("SPADE", 8), new Card("SPADE", 4),
				new Card("SPADE", 5) };
		assertTrue(checkRank(cArr).equals("FLUSH"));
	}

	@Test
	// 스트레이트 이면서 카드의 무늬가 모두 같은 경우 "STRAIGHT FLUSH"를 반환
	void straightFlushTest() {
		Card[] cArr = { new Card("SPADE", 1), new Card("SPADE", 2), new Card("SPADE", 3), new Card("SPADE", 4),
				new Card("SPADE", 5) };
		assertTrue(checkRank(cArr).equals("STRAIGHT FLUSH"));
	}

	@Test
	// 어느 랭크(족보)에도 해당하지 않으면 NO RANK를 반환
	void noRankTest() {
		Card[] cArr = { new Card("SPADE", 1), new Card("CLUB", 7), new Card("SPADE", 3), new Card("SPADE", 4),
				new Card("SPADE", 5) };
		assertTrue(checkRank(cArr).equals("NO RANK"));
	}

}
