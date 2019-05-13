package day9;

public class ExceptionEx11 {
	// 컴파일 오류는 없지만 런타임 오류 발생
	public static void main(String[] args) {
		throw new RuntimeException();
	}
}
