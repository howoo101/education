package day16;

enum Direction1 {
	EAST(1, ">"), SOUTH(2,"V"), WEST(3, "<"), NORTH(4, "^");
	
	private static final Direction1[] DIR_ARR = Direction1.values();
	private final int value;
	private final String symbol;
	
	Direction1 (int value, String symbol) {  //접근제어자 private이 생략됨
		this.value = value;
		this.symbol = symbol;
	}
	
	public int getValue() {return value;}
	public String getSymbol() {return symbol; }
	
	public static Direction1 of(int dir) {
		if(dir < 1 || dir > 4) {
			throw new IllegalArgumentException("Invalid value :" + dir);
		}
		return DIR_ARR[dir - 1];
	}
	
	//방향을 회전시키는 메서드, num의 값만큼 90도씩 시계방향으로 회전한다.
	public Direction1 rotate(int num) {
		num = num % 4;
		
		if(num < 0) num +=4; //num이 음수일 때는 시계방향으로 회전
		
		return DIR_ARR[value - 1 + num];
	}
	
	public String toString() {
		return name() + getSymbol();
	}
}
public class EnumEx2 {
}
