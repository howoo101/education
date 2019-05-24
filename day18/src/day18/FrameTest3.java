package day18;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class FrameTest3 {
	public static void main(String args[]) {
		Frame f = new Frame("Login"); // Frame . 객체를 생성한다
		f.setSize(300, 200); // Frame . 의 크기를 설정한다
// EventHandler Frame WindowListener . 클래스의 객체를 생성해서 의 로 등록한다
		f.addWindowListener(new EventHandler());
		f.setVisible(true); // Frame . 생성한 을 화면에 보이도록 한다
	}
}

class EventHandler implements WindowListener {
	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) { // Frame . 의 닫기 버튼을 눌렀을 때 호출된다
		e.getWindow().setVisible(false); // Frame을 화면에서 보이지 않도록 하고
		e.getWindow().dispose(); // . 메모리에서 제거한다
		System.exit(0); // . 프로그램을 종료한다
	}

	public void windowClosed(WindowEvent e) {
	} // 아무내용도 없는 메서드 구현

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}
}
