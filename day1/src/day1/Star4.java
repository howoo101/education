package day1;

public class Star4 {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (i >= j) { //i 와 j가 같을때 *을 출력
					System.out.print("["+i+","+j+"]");
				} else {
					System.out.print("     ");
				}
			}
			System.out.println();
		}
	
	}
}
