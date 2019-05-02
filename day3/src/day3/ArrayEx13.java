package day3;

import java.util.Arrays;

/*
 * 배열 arr 있을때
 * int[] arr = {3, 1, 4, 2, 2, 3, 1, 4, 4, 4,1}
 *
 * #2 배열 Arr을 정렬 하여(오름 차순) 출력하시오
 *  출력결과 : 11122334444
 *  버블정렬 
 *  배열 길이 -1만큼 반복문 돌면서
 *  정렬된 개수만큼 추가로 빼서 옆배열과 비교해서 크면 오른쪽으로 변경
 */
public class ArrayEx13 {
	public static void main(String[] args) {
		int[] arr = {3, 1, 4, 2, 2, 3, 1, 4, 4, 4, 1};
		int temp = 0; // 변경시 사용할 임시변수
		boolean changed = false; //변경 유무 변수
		
		for(int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					changed = true;
				}
			}
			if(!changed) {
				break;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
