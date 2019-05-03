package pr4;

public class Ex4_while {
	public static void main(String[] args) {
		int sum = 0;
		int count = 0;
		int i = 1;
		int j = 1;
		while(sum<100) {
			sum += (i*j);
			i++;
			j *= -1;
			count++;
		}
		System.out.println("sum: "+sum);
		System.out.println("count: "+count);
	}
}
