package pr7;

import java.util.Arrays;

public class Ex19 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Tv1());
		b.buy(new Computer1());
		b.buy(new Tv1());
		b.buy(new Audio1());
		b.buy(new Computer1());
		b.buy(new Computer1());
		b.buy(new Computer1());

		b.summary();
	}
}

class Buyer {
	int money = 1000;
	Product1[] cart = new Product1[3];
	int i = 0; // cart에 사용될 index

	void buy(Product1 p) {
		/*
		 * 1. 가진 돈과 물건의 가격을 비교해서 가진 돈이 적으면 메서드를 종료한다. 2. 가진 돈이 충분하면, 제품의 가격을 가진 돈에서 빼고
		 * 3. 장바구니에 구입한 물건을 담는다.(add메서드 호출)
		 */
		if (this.money < p.price) {
			System.out.println("잔액이 부족하여 " + p + "을/를 살수 없습니다.");
			return;
		}

		this.money -= p.price;
		add(p);

	}

	void add(Product1 p) {
		/*
		 * 1.1 i의 값이 장바구니의 크기보다 같거나 크면 1.1.1 기존의 장바구니보다 2배 큰 새로운 배열을 생성한다. 1.1.2 기존의
		 * 장바구니의 내용을 새로운 배열에 복사한다. 1.1.3 새로운 장바구니와 기존의 장바구니를 바꾼다. 1.2 물건을 장바구니(cart)에
		 * 저장한다. 그리고 i의 값을 1증가시킨다.
		 */
		if (this.i >= this.cart.length) {
			Product1[] cartTmp = Arrays.copyOf(this.cart, cart.length * 2);
			this.cart = cartTmp;
		}
		this.cart[i++] = p;
		
	}

	void summary() {
		/*
		 * 1. 장바구니에 담긴 물건들의 목록을 만들어 출력한다. 2. 장바구니에 담긴 물건들의 가격을 모두 더해서 출력한다. 3. 물건을 사고 남은
		 * 금액(money)를 출력한다.
		 */
		System.out.println("구입한 물건:" + Arrays.toString(cart));
		System.out.println("사용한 금액:" + (1000 - this.money));
		System.out.println("남은 금액:" + this.money);
	}
}

class Product1 {
	int price;

	Product1(int price) {
		this.price = price;
	}
}

class Tv1 extends Product1 {
	Tv1() {
		super(100);
	}

	public String toString() {
		return "Tv";
	}
}

class Computer1 extends Product1 {
	Computer1() {
		super(200);
	}

	public String toString() {
		return "Computer";
	}
}

class Audio1 extends Product1 {
	Audio1() {
		super(50);
	}

	public String toString() {
		return "Audio";
	}
}