package pr9;

import java.util.Arrays;

public class Ex2 {
	public static void main(String[] args) {
		Point3D p1 = new Point3D(1,2,3);
		Point3D p2 = new Point3D(1,2,3);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1==p2?"+(p1==p2));
		System.out.println("p1.equals(p2)?"+(p1.equals(p2)));
	}
}

class Point3D {
	int x,y,z;
	
	Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	Point3D() {
		this(0,0,0);
	}
	
	// 인터턴스변수 x,y,z를 비교하도록 오버라이딩
	public boolean equals(Object obj) {
		//obj 가 Point3D의 인스턴스면
		if(obj instanceof Point3D) {
			//obj의 멤버와 비교대상의 멤버를 비교한다.
			return ((Point3D)obj).x == this.x &&
					((Point3D)obj).y == this.y &&
							((Point3D)obj).z == this.z;
		}
		return false;
	}
	
	// 인스턴스변수 x,y,z,의 내용을 출력하도록 오버라이딩
	public String toString() {
		return "["+x+","+y+","+z+"]";
	}
}
