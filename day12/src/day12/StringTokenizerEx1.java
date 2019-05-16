package day12;

import java.util.StringTokenizer;

public class StringTokenizerEx1 {
	
	public static void main(String[] args) {
		String source = "100,200,300,400";
		StringTokenizer st = new StringTokenizer(source,",");
		System.out.println();
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
