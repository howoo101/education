package day6;

public class CastingTest2 {
	public static void main(String[] args) {
		Car car = new Car();
		Car car2 = null;
		FireEngine fe = null;
		
		car.drive();
		fe = (FireEngine)car;  //조상타입을 바로 자손타입으로 캐스팅 불가   => 조상타입 변수에 자손타입을 조상타입으로 캐스팅 참조후 수행해야함
		fe.drive();
		car2 = fe;
		car2.drive();
	}
}
