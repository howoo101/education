package day2;

import java.util.Scanner;

public class ScannerEx {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.print("두 자리 정수를 하나 입력해주세요 >");
		 
//		String input = scanner.nextLine(); //문자열 한줄 입력받기
//		int num = Integer.parseInt(input); //문자열을 int형으로 형변환하기

		int num = scanner.nextInt(); //int형 입력받기
		
		System.out.println("입력내용: "+num);
		System.out.printf("num: %d\n", num);
	}
}
