package pr5;

public class Ex9 {
	public static void main(String[] args) {
		char[][] star = { 
				{'*','*',' ',' ',' '},
				{'*','*',' ',' ',' '},
				{'*','*','*','*','*'},
				{'*','*','*','*','*'} 
		};
		
		char[][] result = new char[star[0].length][star.length];
		
		for(int i = 0; i< star.length; i++) {
			for (int j =0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i < star.length; i++) {
			for (int j =0; j < star[i].length;j++) {
				result[i][j] = star[i][star[i].length-j];
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
		
		for(int i=0; i < result.length;i++) {
			for(int j=0; j < result[i].length;j++) {
				System.out.print(result[i][j]); 
			} 
			System.out.println(); 
		}
		
	}
}
