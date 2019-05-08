package pr6;

public class Ex6 {
	static double getDistance(int x, int y, int x1, int y1) {
		double xD = x-x1;
		double yD = y-y1;
		return Math.sqrt(xD*xD + yD*yD);
	}
	
	public static void main(String[] args) {
		System.out.println(getDistance(1, 1, 2, 2));
	}
}
