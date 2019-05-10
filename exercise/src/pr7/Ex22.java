package pr7;

abstract class Shape {
	Point p;
	
	Shape()	 {
		this(new Point(0,0));
	}
	
	Shape(Point p) {
		this.p = p;
	}
	
	abstract double calcArea(); //도형의 면적을 계산해서 반환하는 메서드
	
	Point getPosition() {
		return p;
	}
	
	void setPosition(Point p) {
		this.p = p;
	}
}

class Point {
	int x;
	int y;
	
	Point() {
		this(0,0);
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "["+x+","+y+"]";
	}
}

class Circle extends Shape {
	double r;

	public Circle(double d) {
		this.r = d;
	}

	@Override
	double calcArea() {
		return r*r*Math.PI;
	}
}

class Rectangle extends Shape {
	double width;
	double height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	double calcArea() {
		return width * height;
	}
	
	boolean isSquare() {
		return width == height;
	}
}

public class Ex22 {
	
}
