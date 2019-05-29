package java60;

import java.util.Arrays;

/*
 * 단어 spelling 섞어놓고 원래 단어를 맞추는 게임
 * 
 */
public class WordScrambleEx1 {
	public static void main(String[] args) {
		String[] strArr = {"CHANGE", "LOVE", "HOPE", "VIEW"};
		
		String answer = getAnswer(strArr);
		String question = getScambledWord(answer);
		
		System.out.println("Question: " +question);
		System.out.println("Answer: " +answer);
	}
	
	//주어진 문자열 str의 각 문자의 순서를 뒤섞은 다음, 새로운 문자열로 반환한다.
	public static String getScambledWord(String answer) {
		//answer를 배열로 쪼갠다.
		String[] answerArr = answer.split("");
//		System.out.println(Arrays.toString(answerArr));
		//배열만큼 반복문돌면서 0번째요소와 범위안에있는 랜덤번째요소와 계속 바꾼다.
		for(int i = 0; i < answerArr.length; i++) {
			int idx = (int)(Math.random()*answerArr.length);
			String tmp = answerArr[0];
			answerArr[0] = answerArr[idx];
			answerArr[idx] = tmp;
		}
		//배열을 스트링으로 바꿔준다.
		String result = String.join("", answerArr);
		
		return result;
	}
	//배열 strArr의 요소중의 하나를 임의로 골라서 반환한다.
	//가독성,효율성,테스트
	public static String getAnswer(String[] strArr) {
		int idx = (int)(Math.random()*strArr.length);
//		System.out.println(idx);
		return strArr[idx];
	}
}
