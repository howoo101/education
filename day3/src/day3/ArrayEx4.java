package day3;

import java.util.Arrays;

/*
 * 
 * 두 배열의 같은 숫자가 몇개인지 출력하시오 (중복은 제외) 
 * 단) 위치도 같으면 변수 S의 값을 1증가 위치가 다르면 변수 b의 값을 1증가
 * 
 * Math.random()으로 3개 뽑은 배열(중복 없다) 만들고 
 * 입력한 3개랑 계속 비교 두 배열이 같을 때 까지 while문으로 계속 입력 받는다.
 * 같으면 종료
 * 
 *  배열 길이 만큼 각배열요소 비교한다. 2중 for문으로
 *  각 배열 요소가 같고 index가 같으면 S 증가시키고 for문 break
 *  각 배열 요소가 같고 index가 다르면 B 증가시키고 for문 break 
 */
public class ArrayEx4 {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = new int[3];
		int strike = 0;
		int ball = 0;
		
		//랜덤 숫자 3개 받기 (중복없이)
		
		int num = (int)(Math.random()*3)+1;
		for(int i = 0; i < arr2.length; i++) {
			if(arr2[i] == num) {
				while(num == arr2[i]) {
					num = (int)(Math.random()*3)+1;
				}
			}
			arr2[i] = num;
		}
		System.out.println(Arrays.toString(arr2));
		//기준이 되는 배열
		for (int i = 0; i < arr1.length; i++) {
			//기준 배열의 요소와 비교배열의 요소를 비교한다.
			for (int j = 0; j < arr2.length; j++) {
				if(arr1[i] == arr2[j]) { //요소 값이 같으면
					if(i == j) {  //index가 같으면 strike 1증가
						strike++;
					} else { //index가 다르면 ball 1증가
						ball++;
					}
					break;
				}
				
			}
		}
		
		System.out.println("스트라이크 : " + strike);
		System.out.println("볼 : " + ball);

	}
}
