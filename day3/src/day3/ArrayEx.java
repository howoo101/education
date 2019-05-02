package day3;

import java.util.Arrays;

/*
 * 배열 arr1과 arr2가 같은지 확인하여 결과를 출력하시오
 * #1.길이가 같고, 각 요소들이 같을때 ?
 * #2.배열을 string으로 바꿧을때 같을때 ?
 * 
 
 */
public class ArrayEx {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 2, 3 };

		// 길이가 같은지 확인
		boolean arrLengthEq = arr1.length == arr2.length;
		// 각요소가 같은지 확인
		boolean arrValueEq = true;

		//#2 배열을 string으로 바꿧을때 문자열이 같으면 같은 배열이다?
		boolean arrStringEq = Arrays.toString(arr1).equals(Arrays.toString(arr2));
		
		//배열의 길이가 같을때
		if(arrLengthEq) {
			// 배열의 길이만큼 배열의 각 요소 비교
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] != arr2[i]) {
					// 요소 비교해서 다르면 다른배열이다.
					arrValueEq = false;
					break;
				}
			}
		}

		if (arrLengthEq && arrValueEq) {
			System.out.println("같습니다. ");
		} else {
			System.out.println("다릅니다. ");
		}
		
	}
}
