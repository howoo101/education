package pr4;

public class Ex10 {
	public static void main(String[] args) {
		int num = 12345;
		int sum = 0;
		String numStr = num+"";
		for(int i = 0; i < numStr.length(); i++) {
			sum += Integer.parseInt(numStr.charAt(i)+"");
		}
		System.out.println("sum="+sum);
	}
}
