package pr15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/*
 * 지정된 이진파일의 내용을 16진수로 보이게 하기
 */
public class Ex2 {
	public static void main(String[] args) {
		try {
			PrintStream fr1 = new PrintStream(args[0]);
				fr1.print("%x");
			}catch(Exception e) {}			
			
		}
	}

