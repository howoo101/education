package java60;

import java.util.Scanner;

/*
 * 문제2를 변경해서, 문제를 맞추더라도 프로그램이 종료되지 않고 다음문제 보여주기
 */
public class WordScrambleEx3 {
	public static void main(String[] args) {
		String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW" };

		// 코드를 넣어 완성하세요.
		//바깥 while에서는 계속 돌아가게 합니다. 안쪽 while에서는 문제정답 유무 체크
		while(true) {
			boolean correct = true;
			String answer = getAnswer(strArr);
			String question = getScrambledWord(answer);
			while(correct) {
				System.out.println("Question :" +question);
				Scanner sc = new Scanner(System.in);
				System.out.print("Yor answer is :");
				String input = sc.next();
				//입력한거랑 정답이랑 맞으면 빠져나가기
				if(input.equalsIgnoreCase(answer)) {
					System.out.println("정답입니다.");
					correct = false;
				}else {
					System.out.println("틀렸습니다.");
				}
			}
		}
		// hint : while문을 중첩해서(2개의 while문) 작성하세요.

	} // main

	public static String getAnswer(String[] strArr) {
		int idx = (int) (Math.random() * strArr.length);
		return strArr[idx];
	}

	public static String getScrambledWord(String str) {
		char[] chArr = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			int idx = (int) (Math.random() * str.length());
			char tmp = chArr[i];
			chArr[i] = chArr[idx];
			chArr[idx] = tmp;
		}
		return new String(chArr);
	} // scramble(String str)
}
