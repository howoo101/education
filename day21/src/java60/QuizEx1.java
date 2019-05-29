package java60;

import java.util.Arrays;

/*
 * [문제1] 주어진 문자열 데이터를 가지고 실행결과와 같이 출력되도록 코드를 완성하세요.
            데이터의 형식은 문제, 답, 선택지의 순서로 되어 있으며 구분자는 `(숫자1옆의 키)입니다
 */
class QuizEx1 {
	public static void main(String[] args) {
		String[] data = { "다음 중 키워드가 아닌 것은?`2 `final `True `if `public", "다음 중 자바의 연산자가 아닌 것은?`5`&`|`++`!=`/`^",
				"다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false", };
		//문제는 0번째 , 정답은 1번째 나머지는 보기
		for (int i = 0; i < data.length; i++) {

			// 1. String클래스의 String[] split(String regex, int limit)를 사용해서 문제와 선택지를 나누세요.
			String[] eachData = data[i].split("`",2);
//			System.out.println(Arrays.toString(eachData));
//			System.out.println("-------------------------------------------");
			// 2. 문제를 출력하세요.
			System.out.println("["+(i+1)+"] " + eachData[0]);
			// 3. 선택지를 나누기 위해 String[] split(String regex)를 사용하세요.
			
			String[] choice = eachData[1].split("`");
//			System.out.println(Arrays.toString(choice));
			// 4.반복문을 이용해서 선택지를 출력하세요.
			for(int j = 1; j < choice.length; j++) {
				System.out.print(j +"." +choice[j]+"  ");
			}
			System.out.println();
		}
	} // main
}
