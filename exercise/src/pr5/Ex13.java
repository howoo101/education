package pr5;

import java.util.Scanner;

public class Ex13 {
	public static void main(String[] args) {
		String[] words = { "television", "computer", "mouse", "phone" };
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < words.length; i++) {
			char[] question = words[i].toCharArray(); // string to charArray
			int ranIdx = 0;
			do {
				 ranIdx = (int)(Math.random() * words.length);
			}while(ranIdx == i);
			
			char tmp = question[i];
			question[i] = question[ranIdx];
			question[ranIdx] = tmp;
			
			System.out.printf("Q%d. %s의 정답을 입력하세요>", i + 1, new String(question));
			String answer = scanner.nextLine();

			// trim으로 answer 좌우 공백 제거후 비교
			if (words[i].equals(answer.trim())) {
				System.out.println("맞았습니다.");
			} else {
				System.out.println("틀렸습니다.");
			}
		}
	}
}
