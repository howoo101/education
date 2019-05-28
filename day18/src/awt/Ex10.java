package awt;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class BouncingBall2 extends Frame {
	final int BALL_SIZE = 20;
	final int FRAME_WIDTH = 400;
	final int FRAME_HEIGHT = 300;

	final int TOP;
	final int BOTTOM;
	final int LEFT;
	final int RIGHT;

	final int SPEED = 3;
	int xStep = SPEED;
	int yStep = SPEED;

	int x;
	int y;

	BouncingBall2(String title) {
		super(title);

		x = FRAME_WIDTH / 2 - BALL_SIZE / 2;
		y = FRAME_HEIGHT / 2 - BALL_SIZE / 2;

		setVisible(true);
		setBounds(300, 200, FRAME_WIDTH, FRAME_HEIGHT);

		Insets insets = getInsets(); // Frame의 테두리의 두께를 얻어온다.

		TOP = insets.top;
		LEFT = insets.left;
		BOTTOM = FRAME_HEIGHT - insets.bottom;
		RIGHT = FRAME_WIDTH - insets.right;
		setResizable(false);
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
				int key = ke.getKeyCode();

				if (key == KeyEvent.VK_UP) {
					y -= yStep;
					if(y <= TOP-30) y = BOTTOM;
				} else if (key == KeyEvent.VK_DOWN) {
					y += yStep;
					if(y >= BOTTOM+30) y = TOP;
				} else if (key == KeyEvent.VK_LEFT) {
					x -= xStep;
					if(x <= LEFT-30) x = RIGHT;
				} else if (key == KeyEvent.VK_RIGHT) {
					x += xStep;
					if(x >= RIGHT+30) x = LEFT;
				}
			}
		});
	}

	void start() {

		while (true) {
			repaint();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}

	public void paint(Graphics g) {
		g.setColor(Color.magenta);
		g.fillOval(x, y, Ball.SIZE, Ball.SIZE);
	}

	class Ball {
		int x = 100;
		int y = 100;

		static final int SIZE = 30;

		final int SPEED = 5;
		int xStep = SPEED;
		int yStep = SPEED;

		Ball(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

public class Ex10 {
	public static void main(String[] args) {
		new BouncingBall2("Bouuncing Ball").start();
	}
}
