package day3;
/*
 * 셔플
 * 배열의 요소의 순서를 반복해서 바꾼다.(카드섞기, 로또번호 생성)
 */
public class ArrayEx8 {
	public static void main(String[] args) {
		int[] ball = new int[45]; // 45개의 정수값을 저장하기 위한 배열 생성
		
		//배열의 각 요소에 1~45의 값을 저장한다.
		for(int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
		}
		
		int temp = 0; // 두 값을 바꾸는데 사용할 임시 변수
		int j = 0; // 임의의 값을 얻어서 저장할 변수
		
		for(int i = 0; i < 6; i++) {
			j = (int)(Math.random() * 45); //0~44범위의 임의의 값을 섞는다.
			temp = ball[i];
			ball[i] = ball[j];
			ball[j] = temp;
		}
		
		for (int i = 0; i < 6; i++) {
			System.out.printf("ball[%d]=%d\n", i, ball[i]);
		}
	}
}
