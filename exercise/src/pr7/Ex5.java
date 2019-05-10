package pr7;

class Product {
	int price;
	int bonusPoint;
	
	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}

class Tv extends Product {
	Tv(int price) {
		super(price);
	}
	
	public String toString() {
		return "Tv";
	}
}

public class Ex5 {
	public static void main(String[] args) {
		
	}
}
