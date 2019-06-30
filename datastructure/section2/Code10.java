package section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code10 {
	static String[] name = new String[100];
	static String[] phoneNum = new String[100];
	static int n = 0;

	public static void main(String[] args) {
		
				
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
		
		bubbleSort();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Name :"+name[i] + " Phone :"+ phoneNum[i]);
		}
		
		
	}
	
	static void bubbleSort() {
		for(int i = n-1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(name[j].compareTo(name[j+1]) > 0) {
					String tmp = name[j];
					name[j] = name[j+1];
					name[j+1] = tmp;
					
				    tmp = phoneNum[j];
				    phoneNum[j] = phoneNum[j+1];
				    phoneNum[j+1] = tmp;
				    
				}
			}
		}
	}
}
