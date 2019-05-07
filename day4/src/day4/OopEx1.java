package day4;

/*
 * #1 세개의 정수를 받아서 중간크기의 값을 반환하는 메서드를 작성하고 테스트 하시오.
 * 메서드이름: mid
 * 매개변수: int x int y int z
 * 반환타입: int
 * 1번째
 * 최대값을 구한 다음에, 나머지 두값중 큰 값을 반환
 * x랑 y랑 비교하고 더 큰수랑 z랑 비교한다  
 * z가 더 크면 비교한숫자가 중간크기이다.
 * z가 더작으면 x랑 비교한다.   비교해서 큰 수가 중간크기이다.
 * 
 * 2번째 
 * 배열에 넣어서 정렬한다.
 * 2번째 인덱스가 중간크기이다. 버블정렬
 */
public class OopEx1 {
//	public int mid1(int x, int y, int z) {
//		int compare1 = x >= y ? x : y;  // x, y 비교해서 더 큰수
//		int notCompare1 = x >= y ? y : x; //x, y 비교해서 더 작은수
//		//x y랑 비교해서 더 큰수랑 z랑 비교해서 z가 더크면 비교한수가 더 큰수
//		if(compare1 <= z) return compare1; 
//		else { //z가 더 작을때  z랑 비교해서 작은수랑 다시 비교해서 큰 수가 중간크기
//			return z >= notCompare1 ? z : notCompare1;
//		}
//	}
	public int mid1(int x, int y, int z) {
		if((x <= y && y <= z) || (z <= y && y <= x)) return y;
		if((y <= x && x <= z) || (z <= x && x <= y)) return x;
		return z;
		
	}
	public int mid2(int x, int y, int z) {
		int[] arr = {x, y, z};
		int tmp = 0;
		for (int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		return arr[1];
	}
}
