package pr6;

import java.util.Arrays;

public class Ex20 {
	
	static int[] shuffle(int[] arr) {
		
		if(arr == null || arr.length == 0) return arr;
		
		int temp = 0;
		int idx = 0;
		for(int i = 0; i < arr.length; i++) {
			idx = (int)(Math.random() * arr.length);
			temp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = temp;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(Arrays.toString(result));
	}
}
