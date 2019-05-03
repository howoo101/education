package pr3;

public class Ex9 {
	public static void main(String[] args) {
		char ch = 'H';
		boolean b = (ch >=65 && ch <123) ||(ch <58 && ch >47);
		System.out.println(b);
		boolean c = ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z') 
				|| ('0' <= ch &&  ch <= '9');		
		System.out.println(c);

	}
}
