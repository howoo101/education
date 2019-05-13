package day9;

public class ExceptionEx1 {
	public static void main(String[] args) {
		try {
			try {} catch (Exception e) {}
		} catch (Exception e) {
//			try {} catch (Exception e) {}  //error. 변수 e가 중복 선언
		}
		
		try {
			
		}catch (Exception e) {
			
		}
	}
}
