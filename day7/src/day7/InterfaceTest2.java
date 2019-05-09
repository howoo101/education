package day7;

/*
 * 직접적인 관계에 있던 클래스를 인터페이스를 통해 간접적으로 접근한다.
 * A클래스는 I인터페이스와 직접적인 관계를 가지고 있기 때문에 매개변수로 들어오는 클래스들의 변경에도
 * 아무런 영향을 받지않는다.
 * 
 * 사용 할 때 마다 매개변수를 동적으로 제공받음
 */


interface I {
	public abstract void play();
}

class A1 {
	void autoPlay(I i) {
		i.play();
	}
}

class B1 implements I {
	public void play() {
		System.out.println("play in B class");
	}
}

class C1 implements I {
	public void play() {
		System.out.println("play in C class");
	}
}

public class InterfaceTest2 {
	public static void main(String[] args) {
		A1 a = new A1();
		a.autoPlay(new B1());
		a.autoPlay(new C1());
	}
}
