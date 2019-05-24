package awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex1 {
	public static void main(String[] args) {
		
		Frame f = new Frame("Bingo");
		String[] bingo = {"참새","두루미","황새","비둘기","까오기","오리","타조","부엉이",
				"올빼미","뱁새","꿩","닭","구관조","잉꼬","매","거위","닭","구관조","잉꼬",
				"매","거위","독수리","콘돌","봉황","공작","까치","까마귀","앵무새","꾀꼬리","고니"};
		f.setSize(500, 500);
		f.setLayout(new GridLayout(5, 5));
		for (int i = 0; i < 25; i++) {
			Button a = new Button(bingo[i]);
			a.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println(a.getLabel());
					if(a.getBackground() == Color.blue)
						a.setBackground(Color.pink);
					else
						a.setBackground(Color.blue);
				}
			});
			f.add(a);
		}
		f.getComponent(0).setBackground(Color.pink);
		
		f.addWindowListener(new EventHandler());
		f.setVisible(true);
	}
}

 class EventHandler implements WindowListener, MouseListener , ActionListener{
	 	public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println(1);
		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {}
	 
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
