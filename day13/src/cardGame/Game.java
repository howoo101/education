package cardGame;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 인원수 받기, 게임 수 받기, 
 * 딜러가 게임 운영
 * 딜러는 덱을 만들어서 셔플한다.
 * 
 * 인원수 만큼 돌면서 카드 5장씩 나누어 준다.
 * 인원수 만큼 플레이어에게 결과 알려준다.
 * 인원수 만큼 플레이어에게 점수 알려준다.
 * 1등 찾아내서 모인돈 준다.
 */
public class Game {
	static final int MAX_PLAYERS = 5;
	static Player[] players; //최대 5명 받아
	static Dealer dealer = new Dealer(); 
	int numOfGame; //게임 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Game game = new Game(); //게임시작
		game.getPlayers(sc); //플레이어 참여
//		System.out.println(Arrays.toString(game.players));
		dealer.shuffle(); //카드 셔플
		game.dealForAll(players); //카드 분배
		System.out.println(Arrays.toString(players[0].cards));
		
		sc.close();
	}
	//게임수 입력받기 (보류)
	public void getGame(Scanner sc) {
		sc.nextInt();
	}
	
	//인원수 입력받기
	public void getPlayers(Scanner sc) {
		System.out.println("몇명 게임 참가할래요?");
		players = new Player[sc.nextInt()];
		for(int i = 0; i < players.length; i++) {
			players[i] = new Player("길동이"+i,1000);
		}
	}
	//인원수 만큼 배팅한다.
	public void bet() {
		Scanner sc = new Scanner(System.in);
		int betMoney = sc.nextInt();
		for(int i = 0; i < players.length; i++) {
			players[i].money -= betMoney;
			dealer.battedMoney += betMoney;
		}
		sc.close();
	}
//	인원수 만큼 돌면서 카드 5장씩 나누어 준다.
	public void dealForAll(Player[] players) {
		for(int i = 0; i < players.length; i++) {
			dealer.deal(players[i]);		
		}
	}
	//인원수 만큼 돌면서 결과 확인. 
	public void giveResult() {
		for(int i = 0; i < players.length; i++) {
			players[i].setResult(players[i].cards);
		}
	}
	//인원수 만큼 돌면서 결과 점수 알려준다.
	public void giveResultPoint() {
		players[0].score = dealer.getResultPoint(players[0].result);
	}
	//인원수만큼 돌면서 1등찾고 돈 넘기기
	public void giveWinnerMoney() {
		Player winner = dealer.getWinner(players[0].score);
		winner.money += dealer.battedMoney;
	}
	
}