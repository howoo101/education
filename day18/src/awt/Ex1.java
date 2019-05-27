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
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex1 {
	Button[][] arr = new Button[5][5];
	
	static int bingoCnt(Button[][] bingo) {
		int count = 0;
		int rowAll = 0;
		int rowEqCol = 0;
		int rowPlusCol = 0;
		int[] colArr = new int[bingo[0].length];

		for (int i = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++) {
				if (bingo[i][j].getBackground() == Color.yellow) {
					rowAll++;
					colArr[j]++;
					if (i == j)
						rowEqCol++;
					if (i + j == bingo.length - 1)
						rowPlusCol++;
				}
			}

			// 행이 빙고일때
			if (rowAll == bingo[0].length) {
				System.out.println("행");
				count++;
			}
			rowAll = 0;

		}

		// 열 빙고 구하기
		for (int k = 0; k < colArr.length; k++) {
			if (colArr[k] == bingo.length) {
				count++;
				System.out.println("열");
			}
		}

		// 행과 열이 같을때
		if (rowEqCol == bingo[0].length) {
			System.out.println("행과열");
			count++;
		}

		// 행과열 반대 대각선
		if (rowPlusCol == bingo[0].length) {
			System.out.println("행과열 대각");
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		/*
		 * 1차원 배열25개짜리 만들고 그안에 버튼 하나씩 넣는다. 배열이 체크된걸 알아야 빙고를 체크할수있는데 색이 노란색이면 체크되었다!
		 */
		Ex1 bingo1 = new Ex1();
		Frame f = new Frame("Bingo");
		String[] bingo = { "참새", "두루미", "황새", "비둘기", "까오기", "오리", "타조", "부엉이", "올빼미", "뱁새", "꿩", "닭", "구관조", "잉꼬", "매",
				"거위", "독수리", "콘돌", "봉황", "공작", "까치", "까마귀", "앵무새", "꾀꼬리", "고니" };
		f.setSize(500, 500);
		f.setLayout(new GridLayout(5, 5)); // 프레임에 그리드 레이아웃 생성
		// 이벤트가 발생할 때마다 체크를 해주어야함
		// how??????????????????????????????????????????????? i don't know

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bingo1.arr[i][j] = new Button(bingo[5 * i + j]);
				// 버튼 25개만들어서 버튼별 이벤트 추가
				bingo1.arr[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String btnName = ((Button) e.getSource()).getLabel();
						System.out.println(btnName);
						((Button) e.getSource()).setBackground(Color.YELLOW);
						System.out.println(Ex1.bingoCnt(bingo1.arr));
					}
				});
				f.add(bingo1.arr[i][j]);
			}
		}
		f.addWindowListener(new EventHandler());

		class Thread1 extends Thread {
			public void run() {
				while (true) {
					try {
						f.setTitle(new SimpleDateFormat("hh:mm:ss a").format(new Date()));
						Thread.sleep(1000);
					} catch (Exception e) {
					}
				}
			}
		}
		Thread1 th1 = new Thread1();
		th1.start();
		f.setVisible(true);
	}
}

class EventHandler implements WindowListener, MouseListener, ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
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
	public void mouseExited(java.awt.event.MouseEvent e) {
	}

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
