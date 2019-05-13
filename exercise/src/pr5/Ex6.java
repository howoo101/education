package pr5;

public class Ex6 {
	public static void main(String[] args) {
		// 잔돈 배열이 어떤식으로 이루어져 있을지 모르니
		// 내림차순으로 정렬 해 놓아야함
		int[] coinUnit = { 500, 100, 50, 10 };

		int money = 2680;
		System.out.println("money=" + money);

		for (int i = 0; i < coinUnit.length; i++) {
			System.out.println(coinUnit[i] + "원: " + money / coinUnit[i]);
			money %= coinUnit[i];
		}
	}
}
