package pr3;

public class Ex7 {
	public static void main(String[] args) {
		int fahrenheit = 100;
		float celouis = ((5/9f) * (fahrenheit-32)) +((5/9f) * (fahrenheit-32))%0.01f-(((5/9f) * (fahrenheit-32))+((5/9f) * (fahrenheit-32))%0.01f)%0.01f;
		float celouis1 = (int)((5/9f * (fahrenheit-32)+0.005)*100)/100f;
		System.out.println("Fahrenheit: " +fahrenheit);
		System.out.println("celouis: " +(celouis));
		System.out.println("celouis1: "+celouis1);
	}
}
