package pr4;

public class Ex13 {
	public static void main(String[] args) {
		String value = "12o34";
		char ch = ' ';
		boolean isNumber = true;
		
		for (int i = 0; i < value.length(); i++) {
			if(value.charAt(i) < '0' || value.charAt(i) > '9') {
				isNumber = false;
			}
		}
		
		if (isNumber) {
			System.out.println(value+"는 숫자입니다.");
		} else {
			System.out.println(value+"는 숫자가 아닙니다.");
		}
	}
}
