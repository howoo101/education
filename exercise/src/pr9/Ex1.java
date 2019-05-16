package pr9;

public class Ex1 {
	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3,true);
		SutdaCard c2 = new SutdaCard(3,true);
		
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		System.out.println("c1.equals(c2):"+c1.equals(c2));
	}
}

class SutdaCard {
	int num;
	boolean isKwang;
	
	SutdaCard() {
		this(1,true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public boolean equals(Object obj) {
		/*
		 * 매개변수로 넘겨진 객체의 num, isKwang과
		 * 멤버변수 num, isKwang을 비교하도록 오버라이딩
		 */
		
		//obj가 SutdaCard의 인스턴스일때 검사
		if(obj instanceof SutdaCard) {
			return this.isKwang == ((SutdaCard)obj).isKwang && this.num == ((SutdaCard) obj).num;
		}
		return false;
	}
	
	public String toString() {
		return num + ( isKwang ? "K":"");
	}
}
