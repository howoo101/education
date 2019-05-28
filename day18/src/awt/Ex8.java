package awt;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class BouncingBall extends Frame {
	final int BALL_SIZE = 20;
	final int FRAME_WIDTH = 400;
	final int FRAME_HEIGHT = 300;
	final int TOP;
	final int BOTTOM;
	final int LEFT;
	final int RIGHT;
	final int SPEED = 3;
	int x = 100;
	int y = 100;
	int xStep = SPEED;
	int yStep = SPEED;

	BouncingBall(String title) {
		super(title);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setBounds(300, 200, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setVisible(true);
		Insets insets = getInsets(); // Frame의 테두리의 두께를 얻어온다.
		TOP = insets.top;
		LEFT = insets.left;
		BOTTOM = FRAME_HEIGHT - insets.bottom;
		RIGHT = FRAME_WIDTH - insets.right;
		System.out.println("TOP: "+TOP);
		System.out.println("LEFT: "+LEFT);
		System.out.println("BOTTOM: "+BOTTOM);
		System.out.println("RIGHT: "+RIGHT);
	}
	
	void start() {
		while(true) {
			x += xStep;
			y += yStep;
//			System.out.println(x + "      " + y);
			
//			1.x의 값이 왼쪽 테두리(LEFT)보다 작거나 같으면
//			 * 	 x의 값을 LEFT로 바꾸고 x축 이동방향(xStep)을 반대로 한다.
			if(x <= LEFT) {
				x = LEFT;
				xStep *= -1;
				System.out.println("왼쪽");
//				break;
			}
//			2.x의 값이 오른쪽 테두리(RIGHT-BALL_SIZE)보다 작거나 같으면
//			 * 	 x의 값을 RIGHT-BALL_SIZE로 바꾸고 x축 이동방향(xStep)을 반대로 한다.
			else if(x >= RIGHT-BALL_SIZE) { //문제
				x = RIGHT-BALL_SIZE;
				xStep *= -1;
				System.out.println("오른쪽");
			}
//			3.y의 값이 위 쪽 테두리(TOP) 보다 작거나 같으면
//			 * 	 y의 값을 TOP으로 바꾸고 y축 이동방향(yStep)을 반대로 한다.
			else if(y <= TOP) {
				System.out.println("위");
				y = TOP;
				yStep *= -1;
			}
//			4.y의 값이 아래 쪽 테두리(BOTTON-BALL_SIZE)보다 작거나 같으면
//			 * 	 y의 값을 BOTTON-BALL_SIZE로 바꾸고 y축 이동방향(yStep)을 반대로 한다.
			else if(y >= BOTTOM-BALL_SIZE) { // 문제
				System.out.println("아래");
				y = BOTTOM-BALL_SIZE;
				yStep *= -1;
			}
			repaint();
			
			try {
				Thread.sleep(10);
			} catch(Exception e) {}
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
	}
}

public class Ex8 {
	public static void main(String[] args) {
		new BouncingBall("Bouncing Ball").start();
		
	}
}
