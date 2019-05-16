package pr9;

public class Ex8 {
	/*
	 * 주어진 값을 반올림하여, 소수점 이하 n자리의 값을 반환한다.
	 * 예를 들어 n의 값이 3이면, 소수점 4째 자리에서 반올림하여 소수점 이하 3자리의
	 * 수를 반환한다.
	 * Math.round() Math.pow()
	 */
	public static double round(double d, int n) {

		return Math.round(d*Math.pow(10,n)) * Math.pow(10, -n);
	}
	public static void main(String[] args) {
		System.out.println(round(3.1415,1));
		System.out.println(round(3.1415,2));
		System.out.println(round(3.1415,3));
		System.out.println(round(3.1415,4));
		System.out.println(round(3.1415,5));
	}
}
