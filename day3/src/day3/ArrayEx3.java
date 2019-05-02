package day3;


/*
 * 
 * 두 배열의 같은 숫자가 몇개인지 출력하시오 (중복은 제외) 
 * 단) 위치도 같으면 변수 S의 값을 1증가 위치가 다르면 변수 b의 값을 1증가
 *  
 *  배열 길이 만큼 각배열요소 비교한다. 2중 for문으로
 *  각 배열 요소가 같고 index가 같으면 S 증가시키고 for문 break
 *  각 배열 요소가 같고 index가 다르면 B 증가시키고 for문 break 
 */
public class ArrayEx3 {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 3, 2, 1};
		int strike = 0;
		int ball = 0;
		
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
