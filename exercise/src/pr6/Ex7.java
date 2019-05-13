package pr6;

class MyPoint {
	int x;
	int y;

	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double getDistance(int x, int y) {
		return Ex6.getDistance(x, y, this.x, this.y);
	}
	
}

public class Ex7 {
	public static void main(String[] args) {
		MyPoint p = new MyPoint(1,1);

		System.out.println(p.getDistance(2, 2));
	}
}

