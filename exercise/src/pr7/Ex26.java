package pr7;

class Outer1 {
	static class Inner {
		int iv = 200;
	}

}
public class Ex26 {
	public static void main(String[] args) {
		Outer1.Inner oi = new Outer1.Inner();
		System.out.println(oi.iv);
	}
}
