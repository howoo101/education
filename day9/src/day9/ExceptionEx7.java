package day9;

public class ExceptionEx7 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		}catch (ArithmeticException ae) {
			if (ae instanceof ArithmeticException)
				System.out.println("true");
			System.out.println("ArithmeticException");
		} catch(Exception e) { //어떠한 예외더라도 위에서 처리되지 않았을 경우에 여기서 처리된다.
			System.out.println("Exception");
		}
		System.out.println("6");
	}
}
