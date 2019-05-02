package day1;
/*
 * sysout + ctrl + space 자동완성
 * line선택후 alt + 위 아래 하면 통째로 이동됨
 * 단일주석 comment  ctrl + /
 * 줄맞춤:   ctrl + shift + F
 * 한줄 삭제 : ctrl + d
 */

public class Star {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (true) { // i 와 j가 같을때 *을 출력
					System.out.print("[" + i + "," + j + "]");
//					System.out.print(i+j+" ");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}
}
