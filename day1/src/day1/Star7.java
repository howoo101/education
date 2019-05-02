package day1;

public class Star7 {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
//			for문 3개로 하기
//			for (int k = 1; k <= 5; k++) {
//				if (i + k >= 6) {
//					System.out.print("["+i+","+k+"]");
//				} else {
//					System.out.print("     ");
//				}
//			}
//			for (int j = 2; j <=5; j++) {
//				if(i >= j) {
//					System.out.print("["+i+","+j+"]");
//				}else {
//					System.out.print("     ");
//				}
//			}
//			for문 2개로 하기
			for (int j = 1; j <= 4+i; j++) {
				if(i+j >=6) {
					System.out.print("["+i+","+j+"]");
				}else {
					System.out.print("     ");
				}
				
			}
			System.out.println();
		}
	
	}
}
