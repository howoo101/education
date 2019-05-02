package day3;

/*
 * 배열 arr 있을때
 * int[] arr = {3, 1, 4, 2, 2, 3, 1, 4, 4, 4,1}
 * 
 * #1 배열 arr에서 중복된 값을 제거한 결과를 출력하시오 1 ~ 9
 *  출력결과 : 1,2,3,4
 *  1. 배열의 길이만큼 배열 하나도 선언후 0으로 초기화
 *  2. 배열의 길이만큼 순회 하면서 새 배열 index번째 요소랑 배열 요소 -1이랑 비교해서 count++ 시키기
 *  3. 배열요소 값이 1이상인 것만 출력 해준다.
 */

public class ArrayEx12 {
	public static void main(String[] args) {
		int[] arr = {3, 1, 4, 2, 2, 3, 1, 4, 4, 4, 1};
		int[] deDuplication = new int[9];
		
//		1. 배열의 길이만큼 배열 하나도 선언후 0으로 초기화
		for (int i = 0; i < deDuplication.length; i++) {
			deDuplication[i] = 0;
		}
//		2. 배열의 길이만큼 순회 하면서 새 배열 index번째 요소랑 배열 요소 -1이랑 비교해서 count++ 시키기
		for (int i = 0; i < arr.length; i++) {
			deDuplication[arr[i]-1]++;
		}
		
		for(int i = 0; i < deDuplication.length; i++) {
//			System.out.println((i+1)+"의 개수 : "+ deDuplication[i]);
		}
//		3. 배열요소 값이 1이상인 것만 출력 해준다.
		for(int i = 0; i < deDuplication.length; i++) {
			if(deDuplication[i] > 0) {
				System.out.print((i+1) + " ");	
			}
		}
	}
}
