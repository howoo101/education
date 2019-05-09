package pr6;

public class Ex19 {
	public static void change(String str) {

		//문자열은 변경 불가이기 때문에 기존에 만들어진 문자열과 다른경우에는
		//새로운 인스턴스를 만든다.
		str += "456";
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		String str = "ABC123";
		System.out.println("Before change:"+str);
		change(str);
		System.out.println("After change:"+str);
	}
}
