package pr4;

public class Ex12 {
	public static void main(String[] args) {
		int a = 2;
		for (int k = 1; k <= 3; k++) {
			for (int i = 1; i <= 3; i++) {
				a = 2;
				for (int j = 1; j <= 3; j++) {
					System.out.print(a + "*" + i + "=" + a * i + "\t");
					a++;
				}
				System.out.println();
			}
			a += 3;
		}
	}
}
