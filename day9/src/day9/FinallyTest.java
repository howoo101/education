package day9;

public class FinallyTest {
	public static void main(String[] args) {
		try {
			startInstall();
			copyFiles();
		} catch (Exception e) {
			e.printStackTrace();
			deleteTempFiles();
		}
	}

	static void startInstall() {
		System.out.println("startInstall()");
	}

	static void copyFiles() throws Exception {
		throw new Exception("copy");
	}

	static void deleteTempFiles() {
		System.out.println("deleteTempFiles");
	}
}