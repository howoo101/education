package pr6;

public class Ex22 {
	public static boolean isNumber(String str) {
		if(str == null || str.equals(""))
			return false;
		
		boolean isNumber = true;
		for(int i = 0; i < str.length(); i++) {
			if('0' > str.charAt(i) || str.charAt(i) > '9') {
				isNumber = false;
				break;
			}
		}
		return isNumber;
	}
	
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까?" + isNumber(str));
		
		str = "1234ㅇ";
		System.out.println(str + "는 숫자입니까?" + isNumber(str));
	}
}
