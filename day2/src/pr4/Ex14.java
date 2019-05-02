package pr4;

import java.util.Scanner;

public class Ex14 {
	public static void main(String[] args) {
		int answer = (int)(Math.random()*100) + 1;
		int input = 0;
		int count = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println(answer);
		do {
			count++;
			System.out.print("1과 100 사이의 값을 입력하세요 : ");
			input = sc.nextInt();
			if (input > answer) {
				System.out.println("더 작은수를 입력하세요");
			} else if(input == answer) {
				System.out.println("맞췄습니다.");
				System.out.println("시도횟수는 "+ count+"번입니다.");
				break;
			} else {
				System.out.println("더 큰 수를 입력하세요");
			}
		} while(true);
	}
}
