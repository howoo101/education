package awt;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;

import awt.BouncingBall1.Ball;
import awt.BouncingBall1.BallGenerator;

class BouncingBall3 extends Frame {
	final int BALL_SIZE = 20;
	final int FRAME_WIDTH = 400;
	final int FRAME_HEIGHT = 300;

	final int TOP;
	final int BOTTOM;
	final int LEFT;
	final int RIGHT;
	final int SPEED = 7;

	int x;
	int y;
	boolean isPlaying = true;
	ArrayList balls = new ArrayList();

	BouncingBall3(String title) {
		super(title);

		x = FRAME_WIDTH / 2 - BALL_SIZE / 2;
		y = FRAME_HEIGHT / 2 - BALL_SIZE / 2;

		setBounds(300, 200, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setVisible(true);

		Insets insets = getInsets(); // Frame의 테두리의 두께를 얻어온다.

		TOP = insets.top;
		LEFT = insets.left;
		BOTTOM = FRAME_HEIGHT - insets.bottom;
		RIGHT = FRAME_WIDTH - insets.right;

		registerEventHandler();
	}

	void registerEventHandler() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if(!isPlaying) return;
				int key = ke.getKeyCode();

				if (key == KeyEvent.VK_UP) {
					y -= 10;
					if (y <= TOP)
						y = TOP;
				} else if (key == KeyEvent.VK_DOWN) {
					y += 10;
					if (y >= BOTTOM-BALL_SIZE)
						y = BOTTOM-BALL_SIZE;
				} else if (key == KeyEvent.VK_LEFT) {
					x -= 10;
					if (x <= LEFT)
						x = LEFT;
				} else if (key == KeyEvent.VK_RIGHT) {
					x += 10;
					if (x >= RIGHT-BALL_SIZE)
						x = RIGHT-BALL_SIZE;
				}
			}
		});
	}
	
	void start() {
		new BallGenerator().start();

		while (isPlaying) {
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
				 if (b.x >= RIGHT - b.size) { // 문제
					b.x = RIGHT - b.size;
					b.xStep *= -1;
				}
//			3.y의 값이 위 쪽 테두리(TOP) 보다 작거나 같으면
//			 * 	 y의 값을 TOP으로 바꾸고 y축 이동방향(yStep)을 반대로 한다.
				if (b.y <= TOP) {
					b.y = TOP;
					b.yStep *= -1;
//				break;
				}
//			4.y의 값이 아래 쪽 테두리(BOTTON-BALL_SIZE)보다 작거나 같으면
//			 * 	 y의 값을 BOTTON-BALL_SIZE로 바꾸고 y축 이동방향(yStep)을 반대로 한다.
				if (b.y >= BOTTOM - b.size) { // 문제
					b.y = BOTTOM - b.size;
					b.yStep *= -1;
				}
				
				isPlaying = !collisionCheck(b);
				if(!isPlaying) break;
			}
			repaint();

			try {
				Thread.sleep(100);
			} catch (Exception e) {}
		}
	}
	boolean collisionCheck(Ball b) { //튕기는 공
		//두공이 만난다는 것은 두공의 중심거리 합이 반지름의 합과 같으면 된다는 뜻
		int x1 = this.x+(this.BALL_SIZE/2);
		int y1 = this.y+(this.BALL_SIZE/2);
		int x2 = b.x+(b.size/2);
		int y2 = b.y+(b.size/2);
		
		//두점사이의 거리는  x1-x2의 제곱 + y1-y2의 제곱의 제곱근
		return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2)) <= (this.BALL_SIZE/2 + b.size/2); 
	}
	
	public void paint(Graphics g) {
		g.drawString("Number of balls :" + balls.size(), 20, 50);
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
		g.setColor(Color.RED);
		int size = balls.size();
		
		for (int i = 0; i < size; i++) {
			Ball b = (Ball) balls.get(i);
			g.fillOval(b.x, b.y, b.size, b.size);
		}
	}

	class BallGenerator extends Thread {
		public void run() {
			// 3초마다 Frame의 임의의 위치에 공을 생성해서 balls에 추가한다.
			while (true) {
				int x = (int) (Math.random() * (RIGHT - LEFT - Ball.MAX_SIZE)) + LEFT;
				int y = (int) (Math.random() * (BOTTOM - TOP - Ball.MAX_SIZE)) + TOP;
				balls.add(new Ball(x, y));

				try {
					sleep(3000);
				} catch (Exception e) {
				}
				if (balls.size() == 10)
					break;
			}
		}
	}

	class Ball {
		int x = 100;
		int y = 100;
		int size = 30;

		static final int MAX_SIZE = 30;
		static final int MIN_SIZE = 10;

		final int SPEED = 5;
		int xStep = SPEED;
		int yStep = SPEED;

		Ball(int x, int y) {
			this(x, y, (int)(Math.random() * (MAX_SIZE-MIN_SIZE))+MIN_SIZE);
		}

		Ball(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}
}

public class Ex11 {
	public static void main(String[] args) {
		new BouncingBall3("Bouncing Ball").start();
	}
}
