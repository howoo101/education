package pr9;

public class Ex11 {
	/*
	 * 2~9 사이의  두개의 숫자를 받아서 두 숫자사이의 구구단 출력하기
	 */
	public static void main(String[] args) {
		try {
		//		두개의 숫자입력받아서 하나씩 나누어서 변수에 담는다.
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		// 범위 외의 변수를 출력하면 
		if(num1 > 9 || num1 < 2 || num2 > 9 || num2 < 2) {
			//범위값 2 ~ 9 가 넘어가면 문구 출력하기
			System.out.println("단의 범위는 2와 9사이의 값이어야 합니다.");
			return;
		}
		
		for(int i = Math.min(num1, num2); i< Math.max(num1,num2); i++) {
			for(int j = 1; j < 10; j++ ) {
				System.out.println("i*j = " + i*j);;
			}
		}
		
		//2개외의 개수를 입력받으면  문구 출력하기
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("시작 단과 끝 단, 두 개의 정수를 입력해 주세요.");
		}finally {
			System.out.println("USAGE : GugudanTest 3 5");
		}
	}
}
