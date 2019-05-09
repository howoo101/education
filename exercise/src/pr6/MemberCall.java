package pr6;

public class MemberCall {
	int iv = 10;
	static int cv = 20;
	
	int iv2 = cv;
//	static int cv2 = iv; 클래스 멤버는 인스턴스 멤버를 참조할 수 없다.

	static void staticMethod1()	 {
		System.out.println(cv);
//		System.out.println(iv); 클래스 메소드에서 인스턴스 멤버 변수 사용 불가
	}
	
	void instanceMethod1()	 {
		System.out.println(cv);
		System.out.println(iv);
	}
	
	static void staticMethod2()	 {
		staticMethod1();
//		instanceMethod1(); 클래스 메소드에서 인스턴스 메소드 사용 불가
	}
	
	void instanceMethod2() {
		staticMethod1();
		instanceMethod1();
	}
}
