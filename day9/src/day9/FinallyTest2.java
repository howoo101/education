package day9;

public class FinallyTest2 {
	public static void main(String[] args) {
		try {
			startInstall();   //프로그램 설치에 필요한 준비를 한다.
			copyFiles();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			deleteTempFiles(); //프로그램 설칯에 사용된 임시파일들을 삭제한다.
		}
	}
	
	static void startInstall() {
		System.out.println("startInstall()");
	}

	static void copyFiles() {
		System.out.println("copyFiles()");
	}

	static void deleteTempFiles() {
		System.out.println("deleteTempFiles");
	}
}
