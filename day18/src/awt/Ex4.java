package awt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex4 {
	public static void main(String[] args) {
		Thread1 a = new Thread1();
			a.start();
		
	}
}

class Thread1 extends Thread {
	public void run() {
		while(true) {
			try {
				sleep(1000);
			}catch(Exception e) {}
			System.out.println(new SimpleDateFormat("hh:mm:ss a").format(new Date()));
		}
	}
}
