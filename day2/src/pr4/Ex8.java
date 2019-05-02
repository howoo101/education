package pr4;

public class Ex8 {
	public static void main(String[] args) {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if(2*i + 4*j == 10)
				System.out.println("x="+i+", y="+j);
			}
		}
	}
}
