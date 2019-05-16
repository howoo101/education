package pr9;

public class Ex3 {
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
		String path = "";
		String fileName = "";
		int a =fullPath.indexOf("PathSeparateTest.java");
		path = fullPath.substring(0,a-1);
		fileName = fullPath.substring(a);
		System.out.println("fullPath: "+fullPath);
		System.out.println("path: "+path);
		System.out.println("fileName: "+fileName);
	}
}
