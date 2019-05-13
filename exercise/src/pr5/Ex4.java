package pr5;

public class Ex4 {
	/*
	 * int형보다 크기가 작은 자료형은 int형으로 형변환 후에 연산 수행
	 * 두 개의 피연산자 중 자료형의 표현범위가 큰쪽에 맞춰서 형변환 된 후 연산 수행
	 * 정수형 간의 나눗셈에서 0으로 나누는 것은 금지 되어 있다.
	 */
	public static void main(String[] args) {
		int [][] arr = {
				{5,5,5,5,5},
				{10,10,10,10,10},
				{20,20,20,20,20},
				{30,30,30,30,30}
		};
		
		int total = 0;
		float average = 0;
		
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				total += arr[i][j];
			}
			average = total/(float)(arr.length*arr[i].length);
		}
		
		
		System.out.println("total=" +total);
		System.out.println("average="+average);
	}
}
