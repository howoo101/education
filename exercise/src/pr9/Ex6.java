package pr9;

import java.util.Arrays;

public class Ex6 {
	/*
	 * 주어진 문자열(숫자)로 주어진 길이의 문자열로 만들고, 왼쪽 빈 공간은 '0'으로
	 * 채운다.
	 * 만일 주어진 문자열이 null이거나 문자열의 길이가 length의 값과 같으면 그대로
	 * 반환한다.
	 * 만일 주어진 length의 값이 0보다 같거나 작은 값이면, 빈 문자열("")을 반환한다.
	 * String src - 반환할 문자열
	 * int length - 반환할 문자열의 길이
	 */
	
	public static String fillZero(String src, int length) {
		//src가 널이거나 src.length()가 length와 같으면 src 반환
		if(src == null || src.length() == length) return src;
		//length의 값이 0보다 같거나 작으면 빈 문자열("")을 반환한다.
		if (length <= 0) return "";
		//src의 길이가 length의 값보다 크면 src를 length만큼 잘라서 반환한다.
		if (src.length() > length) return src.substring(0, length);
		
		//길이가 length인 char배열을 생성한다.
		char[] tmp = new char[length];
		//char배열을 '0' 으로 채운다.
		for(int i = 0; i < tmp.length; i++) {
			tmp[i] = '0';
		}
		//src에서 문자배열을 뽑아내서 위에서 생성한 배열에 복사한다.
		for(int i = 0; i < src.length(); i++) {
			tmp[length-src.length()+i] = src.charAt(i);
		}
		//생성한 배열로 String을 생성해서 반환한다.
		return String.copyValueOf(tmp);
	}
	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src,10));
		System.out.println(fillZero(src,-1));
		System.out.println(fillZero(src,3));
	}
}
