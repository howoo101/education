package day9;

public class ExceptionEx4 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(4);
		} catch(Exception e) {
			System.out.println(5); // 예외가 발생하지 않는경우 실행 안됨
		}
		System.out.println(6);
	}
}
