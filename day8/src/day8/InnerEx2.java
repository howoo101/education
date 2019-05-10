package day8;

public class InnerEx2 {
	class InstanceInner {
		
	}
	static class StaticInner {
		
	}
	
	InstanceInner iv = new InstanceInner();
	
	static StaticInner cv = new StaticInner();
	
	static void staticMethod() {
//		InstanceInner obj1 = new InstanceInner(); static멤버는 인스턴스멤버에 직접 접근할 수 없다.
		StaticInner obj2 = new StaticInner();
		//인스턴스클래스는 외부클래스를 먼저 생성해야만 생성할 수 있다.
		InnerEx2 outer = new InnerEx2();
		InstanceInner obj = outer.new InstanceInner();
	}
	
	void instanceMethod() {
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
	}
	
	void myMethod() {
		class LocalInner {}
		LocalInner lv = new LocalInner();
	}
}
