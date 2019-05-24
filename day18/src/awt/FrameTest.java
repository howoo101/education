package awt;

import java.awt.*;

class FrameTest {
	
	public static void main(String[] args) {
		Frame f = new Frame("Login"); // Frame . 객체를 생성한다
		f.setSize(300, 200); // Frame . 의 크기를 설정한다
		f.setLayout(null);
		Button b = new Button("confirm");
		b.setSize(100, 50);
		b.setLocation(100, 75);
		
		f.add(b);
		f.setVisible(true); // Frame . 생성한 을 화면에 보이도록 한다
		
	}
}
