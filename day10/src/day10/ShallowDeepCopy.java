package day10;

class Circle implements Cloneable {
	Point1 p; // 원점
	double r; //반지름
	
	Circle(Point1 p, double r) {
		this.p = p;
		this.r = r;
	}
	
	public Circle shallowCopy() { //얕은복사
		Object obj = null;
		
		try {
			obj = super.clone(); //복사대상 인스턴스 그자체
		} catch(CloneNotSupportedException e) {}
		
		return (Circle) obj;
	}
	
	public Circle deepCopy() {
		Object obj = null;
		
		try {
			obj = super.clone();
		} catch(CloneNotSupportedException e) {}
		//복사대상 인스턴스의 멤버로 참조형 변수가 있을때 그 참조형 변수의 인스턴스를
		//		복사한 새로운 인스턴스로 참조할 수 있게 바꿔준다.
		Circle c = (Circle)obj;
		c.p = new Point1(this.p.x, this.p.y);
		
		return c;
	}
	
	public String toString() {
		return "[p=" + p + ", r="+ r +"]";
	}
}

class Point1 {
	int x,y;
	
	Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "("+x +", "+y+")";
	}
}

public class ShallowDeepCopy {
	public static void main(String[] args) {
		Circle c1 = new Circle(new Point1(1,1),2.0);
		Circle c2 = c1.shallowCopy();
		Circle c3 = c1.deepCopy();
		
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		System.out.println("c3="+c3);
	
		c1.p.x = 9;
		c1.p.y = 9;
		System.out.println("= 본체 c1의 변경후 =");
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		System.out.println("c3="+c3);

	}
}
