package pr3;

public class Ex2 {
	public static void main(String[] args) {
		int numOfApple = 123;
		int sizeOfBucket = 10;
		int numOfBucket = 
				numOfApple/sizeOfBucket + (numOfApple%sizeOfBucket > 0 ? 1 : 0);
		
		System.out.println("필요한 바구니의 수 : "+numOfBucket);
	}
}
