package java60;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

/*
 * [문제6] TextArea의 각 라인의 앞에는 param1에 입력된 문자열을, 뒤에는 param2에 입력된 문자열을 제거 기능의
            'substring'버튼을 구현하세요.
 */

public class TextToolEx6 extends Frame implements WindowListener {
	TextArea ta;
	TextField tfParam1, tfParam2;
	Panel pNorth, pSouth;
	Label lb1, lb2;

	String[] btnName = { "Undo", // 작업이전 상태로 되돌림
			"짝수줄삭제", // 짝수줄을 삭제하는 기능
			"문자삭제", // Param1에 지정된 문자들을 삭제하는 기능
			"trim", // 라인의 앞뒤 공백을 제거
			"빈줄삭제", // 빈 줄 삭제
			"접두사추가", // Param1과 Param2의 문자열을 각 라인의 앞뒤에 붙이는 기능
			"substring", // Param1과 Param2에 지정된 문자열을 각 라인에서 제거하는 기능
	};

	Button[] btn = new Button[btnName.length];

	private final String CR_LF = System.getProperty("line.separator"); // 줄바꿈문자

	private String prevText = "";

	private void registerEventHandler() {
		addWindowListener(this);

		int n = 0; // 버튼순서

		btn[n++].addActionListener(new ActionListener() { // Undo - 작업이전 상태로 되돌림
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();

				if (!prevText.equals("")) {
					ta.setText(prevText);
				}

				prevText = curText;
			}
		});

		btn[n++].addActionListener(new ActionListener() { // 짝수줄삭제 - 짝수줄을 삭제하는 기능
			public void actionPerformed(ActionEvent ae) {

				/* 내용 생략 */
			}
		});

		btn[n++].addActionListener(new ActionListener() { // 문자삭제 - Param1에 지정된 문자를 삭제하는 기능
			public void actionPerformed(ActionEvent ae) {

				/* 내용 생략 */
			}
		});

		btn[n++].addActionListener(new ActionListener() { // trim - 라인의 좌우공백을 제거하는 기능
			public void actionPerformed(ActionEvent ae) {
				/* 내용 생략 */
			}
		});

		btn[n++].addActionListener(new ActionListener() { // 빈줄삭제 - 빈 줄 삭제
			public void actionPerformed(ActionEvent ae) {
				/* 내용 생략 */
			}
		});

		btn[n++].addActionListener(new ActionListener() { // 접두사 - 각 라인에 접두사, 접미사 붙이기
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());

				prevText = curText;

				String prefix = tfParam1.getText();
				String postfix = tfParam2.getText();

				Scanner s = new Scanner(curText);

				for (int i = 0; s.hasNextLine(); i++) {
					String line = s.nextLine();

					sb.append(prefix);
					sb.append(line);
					sb.append(postfix);
					sb.append(CR_LF);
				}

				ta.setText(sb.toString());
			}
		});

		btn[n++].addActionListener(new ActionListener() { // substring - 문자열 자르기
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());

				prevText = curText;

				/*
				 * 1. param1과 param2의 값을 가져온다.(getText()사용)
				 * 2. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽는다.
				 * (Scanner클래스의 hasNextLine(), nextLine()사용)
				 * 3. 읽어온 라인을 substring으로 자른다. - param1과 param2의 내용에 관계없이 길이만큼 자른다.
				 * (param1의 문자열길이와 param2의 문자열 길이를 이용)
				 * 4. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
				 */
				String f = tfParam1.getText();
				String e = tfParam2.getText();
				System.out.println(f.length());
				Scanner sc = new Scanner(curText);
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					if(line.contains(f)) {
						line = line.substring(f.length());
						line = line.substring(0,line.length()-e.length());
					}else {
						line = line.substring(f.length());
					}
					sb.append(line+CR_LF);
				}
				ta.setText(sb.toString());
			}
		});

	} // end of registerEventHandler()

	public static void main(String[] args) {
		TextToolEx6 win = new TextToolEx6("Text Tool");
		win.show();
	}

	public TextToolEx6(String title) {
		super(title);
		lb1 = new Label("param1:", Label.RIGHT);
		lb2 = new Label("param2:", Label.RIGHT);
		tfParam1 = new TextField(15);
		tfParam2 = new TextField(15);

		ta = new TextArea();
		pNorth = new Panel();
		pSouth = new Panel();

		for (int i = 0; i < btn.length; i++) {

			btn[i] = new Button(btnName[i]);
		}

		pNorth.setLayout(new FlowLayout());
		pNorth.add(lb1);
		pNorth.add(tfParam1);
		pNorth.add(lb2);
		pNorth.add(tfParam2);

		pSouth.setLayout(new GridLayout(2, 10));

		for (int i = 0; i < btn.length; i++) { // 버튼배열을 하단 Panel에 넣는다.
			pSouth.add(btn[i]);
		}

		add(pNorth, "North");
		add(ta, "Center");
		add(pSouth, "South");

		setBounds(100, 100, 600, 300);
		ta.requestFocus();
		registerEventHandler();
		setVisible(true);
	} // public TextToolEx1(String title) {

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		e.getWindow().setVisible(false);
		e.getWindow().dispose();
		System.exit(0);
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}
} // end of class
