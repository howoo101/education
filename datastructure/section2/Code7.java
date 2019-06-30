package section2;

import java.util.Arrays;
import java.util.Scanner;

public class Code7 {
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
					//swap data
					int tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
				}
			}
		}
	}
}
