package oopTest;

public class PointTest {
	public static void main(String[] args) {
		/*
		 * Q1-2. 앞서 정의한 Point 클래스를 테스트하기 위한
		 * PointTest 클래스 를 정의하고, Point객체를 생성하는 코드를 작성하시오 
		 */
		Point p = new Point();
		p.x = 1;
		p.y = 2;
		System.out.println("1-2:  " +"x: "+ p.x +", y: " +p.y);
		
		/*
		 * Q1-3. PointTest클래스에서 Point객체를 생성한 다음, x y값을
		 * 3과 5로 초기화 하시오. 그리고 toString()을 호출해서 x y의 값을
		 * 출력하시오
		 * 
		 * Q1-4. 기본생성자 모두 1로초기화 테스트
		 */
		Point p1 = new Point(1,1);
		Point p2 = new Point(0,0);

		
		System.out.println("1-3:  " +p1.toString());
		System.out.println("1-4:  " +p2.toString());
		
		/*
		 * Q1-5. static 메서드 두점사이의 거리 test
		 */
		System.out.println("1-5 루트2:  " +Point.getDistance(p1, p2));
		System.out.println("동일한 점:  " +Point.getDistance(p1, p1));
		/*
		 * Q1-6. getDistance(Point p) test
		 */
		System.out.println("1-6: 루트2  " +p1.getDistance(p2));
		System.out.println("동일한 점:   " +p1.getDistance(p1));
		
		// Q1-7. equals() test하기
		Point p5 = new Point(3,5);
		String a = "a";
		System.out.println("1-7: 다른 객체 " +p2.equals(a));
		System.out.println("1-7:  같은 객체 같은점 " +p2.equals(p2));
		System.out.println("1-7:  같은 객체 다른 점 " +p2.equals(p5));
		
		/* Q1-9 기본생성자 3개다 1로 초기화, Point3d(1,2,3)
		 * Q1-10. Point3D클래스의 toString()이 
		 * x,y,z의 값을 문자열로 오버라이딩하시오.
		 */
		 
		Point3D p3 = new Point3D();
		Point3D p4 = new Point3D(2,2,2);
		
		System.out.println("1-9,10:  " +p3.toString());
		System.out.println("1-9,10:  " +p4.toString());
	}
}
