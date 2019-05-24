package awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridLayoutTest {
	public static void main(String args[]) {
		Frame f = new Frame("GridLayoutTest");
		f.setSize(150, 150);
		f.setLayout(new GridLayout(5, 5)); // 5 5 . 행 열의 테이블을 만든다
		
		for(int i = 1; i < 26; i++) {
			f.add(new Button(i+""));
		}
		
		f.setVisible(true);
		}

}
