package pr3;

public class Ex7 {
	public static void main(String[] args) {
		int Fahrenheit = 100;
		float celouis = ((5/9f) * (Fahrenheit-32)) +((5/9f) * (Fahrenheit-32))%0.01f-(((5/9f) * (Fahrenheit-32))+((5/9f) * (Fahrenheit-32))%0.01f)%0.01f;
		System.out.println("Fahrenheit: " +Fahrenheit);
		System.out.println("celouis: " +(celouis));
	}
}
