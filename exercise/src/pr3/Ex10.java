package pr3;

public class Ex10 {
	public static void main(String[] args) {
		char ch = 'A';
		char lowerCase = (char) (ch <97 ? ch+32 : ch);
		char lowerCase1 = (char) (('A' <= ch && ch <= 'Z') ? ch+32 : ch);
		System.out.println("ch:" + ch);
		System.out.println("ch to lowerCase:"+lowerCase);
		System.out.println("ch to lowerCase2:"+lowerCase1);
		
	}
}
