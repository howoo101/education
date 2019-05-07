package day4;
/*
 * 빙고 몇개인지 확인 count
 * 빙고 경우의수
 * 행이 다 1일때 확인하기 rowAll -> 열돌때 rowAll이 열의 개수랑 같으면 빙고
 * 열이 다 1일때 확인하기 colAll ->열길이만큼의 배열 생성후 그 열인덱스의 요소가 행의 길이와 같으면 빙고
 * 행과열이 같을때 확인하기 rowEqCol ->(정사각형배열에서만 빙고가능) 행과열이 같은경우가 행의 길이와 같으면 빙고
 * 행 + 열이 행의 길이 - 1과 같을때 rowPlusCol ->(정사각형배열에서만 빙고가능) 같은경우가 행의 길이와 같으면 빙고
 */
public class Bingo {
	
	
	int bingoCnt(int[][] bingo) {
		int count = 0;
		int rowCnt = 0; 
		int crossCnt = 0;
		int crossCnt2 = 0;
//		int[]colArr = new int[bingo[0].length];
		int colCnt = 0;
		for(int i = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++) {
				if(bingo[i][j] == 1) {
					rowCnt++; 
//					colArr[j]++;
					if(i == j) crossCnt++;
					if(i+j == bingo.length-1) crossCnt2++;
				}
				if(bingo[j][i] == 1) {
					colCnt++;
				}
			}
			//행이 빙고일때
			if(rowCnt == bingo[0].length) {
				System.out.println("행");
				count++;
			}
			rowCnt = 0;
		}
		
		if(colCnt == bingo[0].length) {
			System.out.println("열");
			count++;
		}
//		//열 빙고 구하기
//		for(int k = 0; k < colArr.length; k++) {
//			if (colArr[k] == bingo.length) {
//				count++;
//				System.out.println("열");
//			}
//		}
		//행과 열이 같을때
		if(crossCnt == bingo[0].length) {
			System.out.println("행과열");
			count++;
		}
		//행과열 반대 대각선
		if(crossCnt2 == bingo[0].length) {
			System.out.println("행과열 대각");
			count++;
		}
		
		return count;
	}
}
