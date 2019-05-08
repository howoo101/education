package day6;

class Product {
	int price;
	int bonusPoint;
	
	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}

class Tv extends Product {
	Tv() {
		// 조상클래스의 생성자 Product(int price)를 호출한다.
		super(100); // Tv의 가격을 100만원으로 한다.
	}
	public String toString() { return "TV"; }
}

class Computer extends Product {
	Computer() { 
		super(200);
	}
	
	public String toString() {return "Computer"; }
	
}

class Audio extends Product {
	Audio() { super(50); }
	public String toString() {return "Audio"; }
}

class Buyer {			//고객, 물건을 사는 사람
	int money = 1000;   //소유금액
	int bonusPoint = 0; //bonus점수
	
	void Buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		money -= p.price; 	//가진돈에서 구입한 제품의 가격을 뺀다.
		bonusPoint += p.bonusPoint;  //제품의 보너스 점수를 추가한다.
		System.out.println(p + "을/를 구입혀셨습니다.");
	}
}

public class PolyArgumentTest {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.Buy(new Tv());
		b.Buy(new Computer());
		System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
		System.out.println("현재 보너스점수는 " + b.bonusPoint + "점입니다. ");
	}
}
