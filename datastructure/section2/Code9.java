package section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code9 {
	public static void main(String[] args) {
		
		String[] name = new String[100];
		String[] phoneNum = new String[100];
		int n = 0;
		
		try {
			Scanner inFile = new Scanner(new File("input.txt"));
			while(inFile.hasNext()) {
				name[n] = inFile.next();
				phoneNum[n] = inFile.next();
				n++;
			}
			inFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("No file");
			return;
		}
			
		for(int i = 0; i < n; i++) {
			System.out.println("Name :"+name[i] + " Phone :"+ phoneNum[i]);
		}
		
		
	}
}
