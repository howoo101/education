package pr9;

public class Ex4 {
	/*
	 * 주어진 배열에 담긴 값만큼 주어진 문자를 가로로 출력한 후, 값을 출력한다.
	 * dataArr - 출력할 그래프의 데이터
	 * char ch - 그래프로 출력할 문자
	 */
	static void printGraph(int[] dataArr,char ch) {
		//배열을 순회
		for(int data: dataArr) {
			//배열에 담긴 값의 횟수 만큼 * 찍기
			for(int i = 0; i < data; i++) {
				System.out.print("*");
			}
			//*다찍고 배열에담긴 값 찍기
			System.out.println(data);
		}
	}
	public static void main(String[] args) {
		printGraph(new int[] {3,7,1,4}, '*');
	}
}
