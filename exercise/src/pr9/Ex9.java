package pr9;

public class Ex9 {
	/*
	 * 주어진 문자열에서 금지된 문자들을 제거하여 반환
	 * String src - 반환할 문자열
	 * String delCh - 제거할 문자들로 구성된 문자열
	 * StringBuffer, String 의 charAt indexOf 사용
	 */
	public static String delChar(String src, String delCh) {
		StringBuffer a = new StringBuffer();
		//문자열이 제거할 문자열에 없으면 버퍼에 더한다.
		for(int i = 0; i < src.length(); i++) {
			if(delCh.indexOf(src.charAt(i)) == -1) {
				a.append(src.charAt(i));
			}	
		}
		return a.toString();
//		return a.toString();
	}
	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)"+" - > "
				+ delChar("(1!2@3^4~5)","~!@#$%^&*()"));
		System.out.println("(1	2		3	4\t5)"+" - > "
				+  delChar("(1	2		3	4\t5)"," \t"));
	}
}
