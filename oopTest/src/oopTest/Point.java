package oopTest;

public class Point {
	/*
	 * Q1-1 두개의 정수 x y를 저장하기 위한 인스턴스 변수가 선언된 Point 클래스를 정의하시오
	 */
	public int x;
	public int y;

	/*
	 * Q1-4.Point클래스에 x y를 매개변수로 하는 생성자와 기본생성자 (x,y 를 모두 1로 초기화)를 추가하시오
	 */
	Point() {
		this(1, 1);
	}

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/*
	 * Q1-5. Point클래스에 두 점 사이의 거리를 double타입의 로 계산해서 반환하는 getDistance(Point p1, Point
	 * p2)를 추가하시오.
	 */
	public static double getDistance(Point p1, Point p2) {
		double x = (double) p1.x - p2.x;
		double y = (double) p1.y - p2.y;
		return Math.sqrt(Math.abs(x * x + y * y));
	}

	/*
	 * Q1-6. Point클래스에 두점 사이의 거리를 double타입의 값으로 계산해서 반환하는 getDistance(Point p)를
	 * 추가하시오.
	 */
	public double getDistance(Point p) {
		return Point.getDistance(this, p);
	}

	/*
	 * Q1-7. Point클래스의 equals()를 다음과 같은 조건으로 오버라이딩 하기 - 
	 * 비교하는 객체가 Point객체가 아니면 false를
	 * 반환 - Point객체의 x y의 값이 같을 때만 true를 반환
	 	비교하는 객체가 Point 객체이면 그 객체의 변수 x y를 검사해서 같으면 true 반환
	 */
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Point) {
			if (((Point) obj).x == ((Point) obj).y) {
				result = true;
			}
		}
		return result;
	}

	/*
	 * Q1-3. Point클래스에 toString()을 오버라이딩해서 x y 값을 포함한 문자열을 반환하도록 하세요
	 */
	public String toString() {
		return "x : " + x + ", y : " + y;
	}
}

/*
 * Q1-8. Point클래스를 상속받고 z를 인스턴스 변수로 갖는 Point3D클래스를 작성하시오.
 */
class Point3D extends Point {
	public int z;
	/*
	 * Q1-9. Point3D클래스에 생성자 Point3D(int x, int y, int z)와 기본생성자(x,y,z를 1로 초기화)를
	 * 추가하시오.
	 */

	Point3D() {
		this(1,1,1);
	}

	Point3D(int x, int y, int z) {
		super(x,y);
		this.z = z;
	}
	/*
	 * Q-10. Point3D 클래스의 toString() 
	 * x,y,z 문자열로 오버라이딩
	 */
	public String toString() {
		return super.toString() + (", z: " + z);
	}
}
