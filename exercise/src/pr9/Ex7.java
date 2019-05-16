package pr9;

public class Ex7 {
	/*
	 * 첫 번째 문자열(src)에 두 번째 문자열(target)이 포함되어 있는지 확인한다.
	 * 포함되어 있으면 true, 그렇지 않으면 false를 반환한다.
	 */
	public static boolean contains(String src, String target) {
//		return src.contains(target); //아래 2줄과 같음 
		if(src.indexOf(target) != -1) return true;
		return false;
	}
	public static void main(String[] args) {
		System.out.println(contains("12345","234"));
		System.out.println(contains("12345","67"));
	}
}
