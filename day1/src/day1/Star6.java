package day1;

public class Star6 {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
//			for문 3개로 하기
//			for (int j = 1; j <=5; j++) {
//				System.out.print("["+i+","+j+"]");
//			}
//			for (int k = 1; k <= 5; k++) {
//				if (i >= k) {
//					System.out.print("["+i+","+k+"]");
//				} else {
//					System.out.print("     ");
//				}
//			}
//			for문 2개로 하기
			for (int j = 1; j <= 5 + i; j++) {
				System.out.print("["+i+","+j+"]");	
			}
			System.out.println();
		}
	
	}
}
