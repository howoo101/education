package day25;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerialEx2 {
	public static void main(String[] args) {
		try {
			String fileName = "userInfo.ser";
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			ObjectInputStream in = new ObjectInputStream(bis);
			
			UserInfo u1 = (UserInfo)in.readObject();
			UserInfo u2 = (UserInfo)in.readObject();
			
			
			ArrayList list = (ArrayList)in.readObject();
			list.add(u1);
			list.add(u2);
			
			System.out.println(u1);
			System.out.println(u2);
			System.out.println(list);
			in.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
