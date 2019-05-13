package day9;

public class ExceptionEx6 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		/*
		 * try문안에서 예외가 발생하면 catch문에 발생한 예외가 있는지 확인
		 * instanceof연산자를 이용해서 검사한다. true가 나올때까지 검사
		 */
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		} catch(Exception e) { // 모든예외클래스의 조상
			System.out.println(5);
		}
		System.out.println(6);
	}
}
