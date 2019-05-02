package day3;

import java.util.Arrays;

/*
 * 
 * 두 배열의 같은 숫자가 몇개인지 출력하시오 (중복은 제외)
 *  배열 길이 만큼 각배열요소 비교한다. 2중 for문으로
 */
public class ArrayEx2 {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 2, 3,2,1 };
		int count = 0;
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if(arr1[i] == arr2[j]) {
					count++;
					break;
				}
			}
		}
		
		System.out.println("같은 개수 : " + count);

	}
}
