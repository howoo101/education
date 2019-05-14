package day10;

final class Card1 {
	String kind;
	int num;
	
	Card1() {
		this("SPADE", 1);
	}
	
	Card1(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	
	public String toString() {
		return kind + ":" + num;
	}
}

public class ClassEx1 {
	public static void main(String[] args) throws Exception {
		Card1 c = new Card1("HEART", 3);
		Card1 c2 = Card1.class.newInstance();
		
		Class cObj = c.getClass();
		
		System.out.println(c);
		System.out.println(c2);
		System.out.println(cObj.getName());
		System.out.println(cObj.toGenericString());
		System.out.println(cObj.toString());
	}
}
