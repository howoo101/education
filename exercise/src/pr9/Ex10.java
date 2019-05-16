package pr9;

import java.util.Arrays;

public class Ex10 {
	
	/*
	 * 주어진 문자열을 지정된 크기의 문자열로 변환한다. 나머지 공간은 공백으로 채운다.
	 * String str = 반환할 문자열
	 * int length = 변환된 문자열의 길이
	 * int alignment = 변환된 문자열의 정렬조건
	 * 0.왼쪽정렬 1.가운데 정렬 2.오른쪽정렬
	 */
	
	public static String format(String str, int length, int alignment) {
//		1. length의 값이 str의 길이보다 작으면 length만큼만 잘라서 반환한다.
		if(str.length() > length) {
			return str.substring(0, length);
		}
//		2. 1의 경우가 아니면 , length크기의 char배열을 생성하고 공백으로 채운다.
		char[] tmp = new char[length];
		for(int i = 0; i < length; i++) {
			tmp[i] = ' ';
		}
		
//		3. 정렬조건의 값에 따라 문자열을 복사할 위치를 결정한다. (System.arraycopy()사용)
		if(alignment == 0) {
			System.arraycopy(str.toCharArray(),0,tmp,0,str.length());	
		}else if (alignment == 2) {
			System.arraycopy(str.toCharArray(),0,tmp,tmp.length-str.length(),str.length());
		}else {
			System.arraycopy(str.toCharArray(),0,tmp,(tmp.length-str.length())/2,str.length());
		}
//		4. 생성한 char배열을 문자열로 만들어서 반환한다.
		return String.copyValueOf(tmp);
	}
	public static void main(String[] args) {
		String str = "가나다";
		
		System.out.println(format(str,7,0)); // 왼쪽 정렬
		System.out.println(format(str,7,1)); // 가운데 정렬
		System.out.println(format(str,7,2)); // 오른쪽 정렬
	}
}
