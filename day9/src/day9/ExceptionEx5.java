package day9;

public class ExceptionEx5 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(0/0); //ArithmeticException 고의 발생
			System.out.println(4);  //catch문으로 빠져나가서 실행안됨
		} catch(ArithmeticException ae) {
			System.out.println(5);
		}
		System.out.println(6);
	}
}
