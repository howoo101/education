package day5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Card {
 String kind;
 int num;
 
 Card(String kind, int num){
  this.kind = kind;
  this.num = num;
 }
 
 Card() {
  this("SPADE", 1);
 }
}

/*
 * 카드 객체만큼 포문을 돌면서 각각의 숫자 개수, 모양의 개수를 구한다.
 * 숫자 개수확인하는 배열 numArr 배열의 인덱스에 카드의 숫자와 일치하면 개수늘린다.
 * 모양 개수확인하는 배열 shapeArr 배열의 인덱스에 카드의 모양과 일치하면 개수늘린다.
 */
class PokerTest {
 // 5장의 카드 객체가 담긴 cArr을 받아서
 // 랭킹을 문자열로 반환
 // 아래의 메서드를 완성하시오.

 String checkRank(Card[] cArr) {
	 String result = "";
	 int straightCnt = 0;
	 
	 String[] kinds = {"CLUB", "HEART", "DIAMOND", "SPADE" };
	 String numbers = "0123456789XJQK";
	 
	 int[] numArr = new int[14];
	 int[] shapeArr = new int[4];
	 
	 for(int i = 0; i < cArr.length; i++) {
		 numArr[numbers.charAt(cArr[i].num)-'0']++;
		 for(int j = 0; j < kinds.length; j++) {
			 if(cArr[i].kind.equals(kinds[j])) {
				 shapeArr[j]++;
				 break;
			 }
		 } 
	 }
	 System.out.println(Arrays.toString(shapeArr));
	 System.out.println(Arrays.toString(numArr));
	 //숫자탐색
	 for(int i = 1; i < numArr.length; i++) {
		 if(numArr[i] != 0) straightCnt++;
		 else straightCnt = 0; 
			 
		 if(result.equals("") && numArr[i] == 2) result = "1 PAIR";
		 else if(numArr[i] == 3) result = "THREE CARD";
		 else if(result.equals("1 PAIR") && numArr[i] == 2) result = "2 PAIR"; 
		 else if(numArr[i] == 4) result = "FOUR CARD";
		 else if((result.equals("1 PAIR") && numArr[i] == 3) ||(result.equals("THREE CARD") && numArr[i] == 2)) result = "FULL HOUSE";
		 else if(straightCnt == 5) result = "STRAIGHT";
		 else if(result.equals("")) result = "NO RANK";
	 }

	 //모양 탐색
	 for(int i = 0; i < shapeArr.length; i++) {
		 if(shapeArr[i] == 5 && result.equals("STRAIGHT")) result = "STRAIGHT FLUSH";
		 else if(shapeArr[i] == 5) result = "FLUSH";
	 }
	 
	 
  System.out.println(result);	 
  return result;
 }
 
 @Test
 // 같은 숫자가 2개 있으면 페어(pair)라고 한다.
 // 페어가 1개면 "1 PAIR"를 2개면 "2 PAIR"를 반환
 void pairTest() {
  Card[] cArr = {
    new Card("SPADE", 1),
    new Card("DIAMOND", 1),
    new Card("HEART", 3),
    new Card("CLUB", 4),
    new Card("SPADE", 5)   
   };
   assertTrue(checkRank(cArr).equals("1 PAIR")); 
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
   assertTrue(checkRank(cArr).equals("2 PAIR")); 
  }

 @Test
 // 같은 숫자가 3개 있으면 쓰리카드("THREE CARD")라고 한다.
 void threeCardTest() {
  Card[] cArr = {
    new Card("SPADE", 1),
    new Card("DIAMOND", 1),
    new Card("HEART", 1),
    new Card("CLUB", 4),
    new Card("SPADE", 2)   
   };
   assertTrue(checkRank(cArr).equals("THREE CARD")); 
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
   assertTrue(checkRank(cArr).equals("FOUR CARD")); 
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
   assertTrue(checkRank(cArr).equals("FULL HOUSE")); 
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
  assertTrue(checkRank(cArr).equals("STRAIGHT")); 
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
  assertTrue(checkRank(cArr).equals("FLUSH")); 
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
  assertTrue(checkRank(cArr).equals("STRAIGHT FLUSH")); 
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
  assertTrue(checkRank(cArr).equals("NO RANK")); 
 }

 
}

