package day10;

class Point implements Cloneable {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "x=" + x + ", y=" + y;
	}
	// 자신을 복사하여 새로운 인스턴스를 생성하는 일을 한다.
	public Point clone() {
		Object obj = null;
		try {
			obj = super.clone(); // clone은 반드시 예외처리를 해주어야 한다.
			System.out.println(obj);
		} catch (CloneNotSupportedException e) {
		}
		return (Point) obj;

	}
}

public class CloneEx1 {
	public static void main(String[] args) {
		Point original = new Point(3, 5);
		Point copy = (Point) original.clone();
		Point copy2 = original;
		

		copy.x = 1;
		copy.y = 2;
		System.out.println(original.hashCode());
		System.out.println(copy2.hashCode());
		System.out.println(copy.hashCode());
	}
}
