package section2;
import java.util.Scanner;

//메서드 호출과 프로그램의 기능적 분할 1
public class Code5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int result = power(a,b);
		System.out.println("result : "+result);
		
		sc.close();
		
	}
	public static int power(int n, int m) {
		int result = 1;
		for(int i = 0; i < m; i++) {
			result *= n;
		}
		
		return result;
	}
	
}
