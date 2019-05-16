package pr9;

public class Ex5 {
	/*
	 * 주어진 문자열(src)에 찾으려는 문자열(target)이 몇번 나오는지 세어서 반환 
	 */
	public static int count(String src, String target) {
		int count = 0; //찾은 횟수
		int pos = 0; //찾기 시작할 위치
		pos = src.indexOf(target);
		do {
//		  1. src에서 target을 pos의 위치부터 찾는다.
			pos = src.indexOf(target,pos);
			
//		2.찾으면 count 1증가, pos값을 target.length만큼 증가
			if(pos != -1) {
				count += 1;
				pos += target.length();
			}
//		3.indexOf 결과가 -1이면 반복문을 빠져나가서 count 반환
			else break;
		}while(pos != -1);
		return count;
		
	}
	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB","AB"));
		System.out.println(count("12345","AB"));
	}
}
