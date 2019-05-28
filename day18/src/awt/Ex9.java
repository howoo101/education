package awt;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

class BouncingBall1 extends Frame {
	final int FRAME_WIDTH = 400;
	final int FRAME_HEIGHT = 300;

	final int TOP;
	final int BOTTOM;
	final int LEFT;
	final int RIGHT;

	ArrayList balls = new ArrayList();

	BouncingBall1(String title) {
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
		
//		System.out.println("TOP: " + TOP);
//		System.out.println("LEFT: " + LEFT);
//		System.out.println("BOTTOM: " + BOTTOM);
//		System.out.println("RIGHT: " + RIGHT);
	}

	void start() {
		new BallGenerator().start();

		while (true) {
			int size = balls.size();

			for (int i = 0; i < size; i++) {
				Ball b = (Ball)balls.get(i);

				b.x += b.xStep;
				b.y += b.yStep;
//			1.x의 값이 왼쪽 테두리(LEFT)보다 작거나 같으면
//			 * 	 x의 값을 LEFT로 바꾸고 x축 이동방향(xStep)을 반대로 한다.
				if (b.x <= LEFT) {
					b.x = LEFT;
					b.xStep *= -1;
				}
//			2.x의 값이 오른쪽 테두리(RIGHT-BALL_SIZE)보다 작거나 같으면
//			 * 	 x의 값을 RIGHT-BALL_SIZE로 바꾸고 x축 이동방향(xStep)을 반대로 한다.
				else if (b.x >= RIGHT - Ball.SIZE) { // 문제
					b.x = RIGHT - Ball.SIZE;
					b.xStep *= -1;
				}
//			3.y의 값이 위 쪽 테두리(TOP) 보다 작거나 같으면
//			 * 	 y의 값을 TOP으로 바꾸고 y축 이동방향(yStep)을 반대로 한다.
				else if (b.y <= TOP) {
					b.y = TOP;
					b.yStep *= -1;
//				break;
				}
//			4.y의 값이 아래 쪽 테두리(BOTTON-BALL_SIZE)보다 작거나 같으면
//			 * 	 y의 값을 BOTTON-BALL_SIZE로 바꾸고 y축 이동방향(yStep)을 반대로 한다.
				else if (b.y >= BOTTOM - Ball.SIZE) { // 문제
					b.y = BOTTOM - Ball.SIZE;
					b.yStep *= -1;
				}
			}
			repaint();

			try {
				Thread.sleep(100);
			} catch (Exception e) {}
		}
	}

	public void paint(Graphics g) {
		g.drawString("Number of balls :" + balls.size(), 20, 50);

		g.setColor(Color.RED);

		int size = balls.size();

		for (int i = 0; i < size; i++) {
			Ball b = (Ball) balls.get(i);
			g.fillOval(b.x, b.y, Ball.SIZE, Ball.SIZE);
		}
	}

	class BallGenerator extends Thread {
		public void run() {
			// 3초마다 Frame의 임의의 위치에 공을 생성해서 balls에 추가한다.
			while(true) {
				int x = (int)(Math.random()*380) + 20;
				int y = (int)(Math.random()*280) + 20;
				try {
					balls.add(new Ball(x , y));
					sleep(3000);
				}catch(Exception e) {}	
				if(balls.size() == 8) break;
			}
		}
	}

	class Ball {
		int x = 100;
		int y = 100;

		static final int SIZE = 20;

		final int SPEED = 5;
		int xStep = SPEED;
		int yStep = SPEED;

		Ball(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

public class Ex9 {
	public static void main(String[] args) {
		new BouncingBall1("Bouuncing Ball").start();
	}
}
