package cardGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class PlayerTest {
	Player a = new Player();
	@Test
	 // 같은 숫자가 2개 있으면 페어(pair)라고 한다.
	 // 페어가 1개면 "1 PAIR"를 2개면 "2 PAIR"를 반환
	 void pairTest() {             //인스턴스 메서드
	  Card[] cArr = {                 //card배열 cArr에 카드정보 가져옴
	    new Card("SPADE", 1),
	    new Card("DIAMOND", 1),
	    new Card("HEART", 3),
	    new Card("CLUB", 4),
	    new Card("SPADE", 5)   
	   };
	   assertTrue(a.setResult(cArr).equals("1 PAIR")); 
	  }

	 @Test
	 // 같은 숫자가 2개 있으면 페어(pair)라고 한다.
	 // 페어가 1개면 "1 PAIR"를 2개면 "2 PAIR"를 반환
	 void pairTest2() {
	  Card[] cArr = {
	    new Card("SPADE", 1),
	    new Card("DIAMOND", 1),
	    new Card("HEART", 3),
	    new Card("CLUB", 4),
	    new Card("SPADE", 4)   
	   };
	   assertTrue(a.setResult(cArr).equals("2 PAIR")); 
	  }

	 @Test
	 // 같은 숫자가 3개 있으면 쓰리카드("THREE CARD")라고 한다.
	 void threeCardTest() {
	  Card[] cArr = {
	    new Card("SPADE", 1),
	    new Card("DIAMOND", 1),
	    new Card("HEART", 1),
	    new Card("CLUB", 2),
	    new Card("SPADE", 4)   
	   };
	   assertTrue(a.setResult(cArr).equals("THREE CARD")); 
	  }

	 @Test
	 // 같은 숫자가 4개 있으면 쓰리카드("FOUR CARD")라고 한다.
	 void fourCardTest() {
	  Card[] cArr = {
	    new Card("SPADE", 1),
	    new Card("DIAMOND", 1),
	    new Card("HEART", 1),
	    new Card("CLUB", 1),
	    new Card("SPADE", 4)   
	   };
	   assertTrue(a.setResult(cArr).equals("FOUR CARD")); 
	  }

	 @Test
	 // 쓰리카드와 원 페이가 같이 있으면 풀 하우스("FULL HOUSE")라고 한다.
	 void fullHouseTest() {
	  Card[] cArr = {
	    new Card("SPADE", 1),
	    new Card("DIAMOND", 1),
	    new Card("HEART", 1),
	    new Card("CLUB", 4),
	    new Card("SPADE", 4)   
	   };
	   assertTrue(a.setResult(cArr).equals("FULL HOUSE")); 
	  }
	 
	 @Test
	 // 카드의 숫자가 모두 연속인 경우 "STRAIGHT"를 반환
	 // 1,2,3,4,5 또는 4,5,6,7,8 인 경우
	 void straightTest() { 
	  Card[] cArr = {
	   new Card("SPADE", 1),
	   new Card("DIAMOND", 2),
	   new Card("HEART", 3),
	   new Card("CLUB", 4),
	   new Card("SPADE", 5)   
	  };
	  assertTrue(a.setResult(cArr).equals("STRAIGHT")); 
	 }

	 @Test
	 // 카드의 무늬가 모두 같은 경우 "FLUSH"를 반환
	 void flushTest() { 
	  Card[] cArr = {
	   new Card("SPADE", 1),
	   new Card("SPADE", 2),
	   new Card("SPADE", 8),
	   new Card("SPADE", 4),
	   new Card("SPADE", 5)   
	  };
	  assertTrue(a.setResult(cArr).equals("FLUSH")); 
	 }
	 
	 @Test
	 // 스트레이트 이면서 카드의 무늬가 모두 같은 경우 "STRAIGHT FLUSH"를 반환
	 void straightFlushTest() { 
	  Card[] cArr = {
	   new Card("SPADE", 1),
	   new Card("SPADE", 2),
	   new Card("SPADE", 3),
	   new Card("SPADE", 4),
	   new Card("SPADE", 5)   
	  };
	  assertTrue(a.setResult(cArr).equals("STRAIGHT FLUSH")); 
	 }

	 @Test
	 // 어느 랭크(족보)에도 해당하지 않으면 NO RANK를 반환
	 void noRankTest() { 
	  Card[] cArr = {
	   new Card("SPADE", 1),
	   new Card("CLUB", 7),
	   new Card("SPADE", 3),
	   new Card("SPADE", 4),
	   new Card("SPADE", 5)   
	  };
	  assertTrue(a.setResult(cArr).equals("NO RANK")); 
	 }

}
