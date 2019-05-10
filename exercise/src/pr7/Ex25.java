package pr7;

class Outer {
	class Inner {
		int iv = 100;
	}
}

public class Ex25 {
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner in = outer.new Inner();
		System.out.println(in.iv);
	}
}
