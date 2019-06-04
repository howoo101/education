package pr15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex1 {
	public static void main(String[] args) {
//		System.out.println(System.getProperty("user.dir"));
		try {
			FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);
			int line1 = Integer.parseInt(args[1]);
			String line = "";
			for(int i = 1; (line = br.readLine()) !=null && i <= line1; i++) {
				System.out.println(i+":"+line);
			}			
		} catch (FileNotFoundException e) {
			System.out.println(args[0]+"은/는 디렉토리이거나, 존재하지 않는 파일입니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
