package day3;
/*
 * 셔플
 * 배열의 요소의 순서를 반복해서 바꾼다.(카드섞기, 로또번호 생성)
 */
public class ArrayEx7 {
	public static void main(String[] args) {
		int[] numArr = new int[10];
		
		for(int i = 0; i < numArr.length; i++) {
			numArr[i] = i; //배열을 0~9로 초기화 한다.
			System.out.print(numArr[i]);
		}
		System.out.println();
		
		for(int i = 0; i < numArr.length; i++ ) {
			int n = (int) (Math.random() * 10); // 0~9 임의로 한 값을 얻는다.
			int tmp = numArr[i];
			numArr[i] = numArr[n];
			numArr[n] = tmp;
		}
		
		for( int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i]);
		}
		
		
	}
}
