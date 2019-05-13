package day9;

public class ExceptionEx3 {
	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		for(int i = 0; i < 10; i++) {
			try {
				result = number / (int)(Math.random() * 10);
				System.out.println(result);
			} catch (ArithmeticException e) { // try에서 0으로로 나누는 경우 이곳에서 예외처리 한다.
				System.out.println("0");
			}
		}
	}
}
