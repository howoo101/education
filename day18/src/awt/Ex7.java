package awt;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Ex7 extends Frame implements MouseListener {
	final int LINE_NUM = 9; // 오목판 줄 수
	final int LINE_WIDTH = 30; // 오목판 줄 간격
	final int BOARD_SIZE = LINE_WIDTH * (LINE_NUM - 1); // 오목판의 크기
	final int STONE_SIZE = (int) (LINE_WIDTH * 0.8); // 돌의 크기
	final int X0; // 오목판 시작위치 x좌표
	final int Y0; // 오목판 시작위치 y좌표
	final int FRAME_WIDTH; // Frame의 폭
	final int FRAME_HEIGHT; // Frame의 높이
	Image img = null;
	Graphics gImg = null;

	public Ex7(String title) {
		super(title);
		// Event Handler를 등록한다.
		addMouseListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		setVisible(true); // Frame을 화면에 보이게 한다.
		Insets insets = getInsets(); // 화면에 보이기 전에는 Insets의 값을 얻을 수 없다.
		// 오목판 그려질 위치(LEFT, TOP)의 좌표 X0, Y0를 지정한다.
		X0 = insets.left + LINE_WIDTH;
		Y0 = insets.top + LINE_WIDTH;
		System.out.println(X0 + "   " + Y0);
		// Frame의 크기를 계산한다.
		FRAME_WIDTH = BOARD_SIZE + LINE_WIDTH * 2 + insets.left + insets.right;
		FRAME_HEIGHT = BOARD_SIZE + LINE_WIDTH * 2 + insets.top + insets.bottom;
		// Frame을 화면의 (100,100)의 위치에 계산된 크기로 보이게 한다.
		setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		
		img = createImage(FRAME_WIDTH, FRAME_HEIGHT);
		gImg = img.getGraphics();
		setResizable(false); // Frame의 크기를 변경하지 못하게 한다.
		drawBoard(gImg);
	}

	public static void main(String[] args) {
		new Ex7("OmokTest");
	}

	public void drawBoard(Graphics g) {
		for (int i = 0; i < LINE_NUM; i++) {
			g.drawLine(X0, Y0 + i * LINE_WIDTH, X0 + BOARD_SIZE, Y0 + i * LINE_WIDTH);
			g.drawLine(X0 + i * LINE_WIDTH, Y0, X0 + i * LINE_WIDTH, Y0 + BOARD_SIZE);
		}
	}

	public void paint(Graphics g) {
		if (img == null)
			return;

		g.drawImage(img, 0, 0, this); // 가상화면에 그려진 그림을 Frame에 복사
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		/*
		 * 1. x와 y의 값이 오목판의 밖을 벗어난 곳이면 돌을 그리지 않는다. 2. x와 y의 값을 클릭한 가장 가까운 교차점으로 변경한다. 3.
		 * x와 y의 값엣 돌의 크기(STONE_SIZE)의 절반을 빼야 클릭한 곳에 돌이 그려진다. 4. 눌러진 버튼이 마우스 왼쪽 버튼이면,
		 * (x,y)의 위치에 검은 돌을 그리고 눌러진 버튼이 마우스 오른쪽 버튼이면, (x,y)의 위치의 흰 돌을 그린다.(검은색 테두리도)
		 * 5.repaint()를 호출한다.
		 */

		int x = e.getX(); // 마우스 포인터의 x좌표
		int y = e.getY(); // 마우스 포인터의 y좌표
//		System.out.println(x + "          " + y);
		// 1번 마우스 x,y가 시작점 보다 작을때, 테두리 끝선보다 클때
		if (x < X0 || y < Y0 || x > X0 + LINE_WIDTH * (LINE_NUM - 1) || y > Y0 + LINE_WIDTH * (LINE_NUM - 1))
			return;
		// 2번 교착점
		// 간격별로  검사할건데 간격의 반보다 작으면 왼쪽이 기준점이되고 
		// 간격의 반보다 크면 오른쪽이 기준점이 된다.
		for (int i = X0; i < X0 + LINE_WIDTH * (LINE_NUM - 1); i += LINE_WIDTH) {
			if(x <(i + LINE_WIDTH)) {
				if(x < (i+LINE_WIDTH/2))
					x = i;
				else
					x = i + LINE_WIDTH;
				break;
			}
		}
		for (int i = Y0; i < Y0 + LINE_WIDTH * (LINE_NUM - 1); i += LINE_WIDTH) {
			if(y <(i + LINE_WIDTH)) {
				if(y < (i+LINE_WIDTH/2))
					y = i;
				else
					y = i + LINE_WIDTH;
				break;
			}
		}
		// 3,4번  (클릭한 위치에서 돌의 절반크기를 빼야함 ) 왼쪽마우스 클릭
		if (e.getButton() == 1) {
			gImg.fillOval(x - STONE_SIZE / 2, y - STONE_SIZE / 2, STONE_SIZE, STONE_SIZE);
		} else { // 오른쪽 마우스 클릭
			gImg.drawOval(x - STONE_SIZE / 2, y - STONE_SIZE / 2, STONE_SIZE, STONE_SIZE);
		}

		// 5번
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}