package section2;

import java.util.Arrays;
import java.util.Scanner;

public class Code8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[n];
		
		for(int i = 0; i < n; i++) {
			data[i] = sc.nextInt();
		}
		sc.close();
		
		bubbleSort(data);
		System.out.println("after Sort: "+ Arrays.toString(data));
	}
	
	public static void bubbleSort(int[] data) {
		int n = data.length;
		for(int i = n-1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(data[j] > data[j+1]) {
					//swap data -> call by value라 변화 없음
					swap(data[j],data[j+1]);
				}
			}
		}
	}
	
	/*
	 * call by value
	 * 값을 복사해서 매개변수로 넘겨주는 것이기 때문에
	 * 실제 값에는 변화가 없다.
	 */
	public static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}
}
