package day7;

/*
 * 클래스 A 와 클래스 B가 직접적인 관계에 있음.
 * B를 구현하기 전에 A를 구현 할 수가 없음.
 * B의 methodB 메소드가 변경되면 A도 변경되어야 한다.
 */

class A {
	public void methodA(B b) {
		b.methodB();
	}
}

class B {
	public void methodB() {
		System.out.println("method B()");
	}
}

public class InterfaceTest {
	public static void main(String[] args) {
		A a = new A();
		a.methodA(new B());
	}
}
