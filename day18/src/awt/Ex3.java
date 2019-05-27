package awt;

import java.io.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Ex3 extends Frame {
	Panel pUp = new Panel();
	Panel pDate = new Panel();

	Button btnPrevMon = new Button("◀");
	Button btnNextMon = new Button("▶");
	Label lblYearMon = new Label();

	Button[] btnArr = new Button[42];
	Calendar curMon = Calendar.getInstance();

	Ex3(String title) {
		super(title);
		pUp.setBackground(Color.yellow);
		pUp.setLayout(new FlowLayout(FlowLayout.CENTER));
		pUp.add(btnPrevMon);
		pUp.add(lblYearMon);
		pUp.add(btnNextMon);
		pDate.setLayout(new GridLayout(6, 7));
		for (int i = 0; i < btnArr.length; i++) {
			btnArr[i] = new Button(i + "");
			pDate.add(btnArr[i]);
		}

		btnPrevMon.addActionListener(new BtnEventHandler());
		btnNextMon.addActionListener(new BtnEventHandler());
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				we.getWindow().setVisible(false);
				we.getWindow().dispose();
				System.exit(0);
			}
		});
		add(pUp, "North");
		add(pDate, "Center");
		setBounds(200, 200, 500, 300);
		setDays(curMon);
		setVisible(true);
	} // Exercise13_5

	void setDays(Calendar date) {
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);

		lblYearMon.setText(year + "년 " + (month + 1) + "월");
		Calendar sDay = Calendar.getInstance(); // 시작일

		sDay.set(year, month, 1);
		sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);
		for (int i = 0; i < btnArr.length; i++) {
			btnArr[i] = new Button(sDay.get(Calendar.DATE) + "");
			((Button) pDate.getComponent(i)).setLabel(sDay.get(Calendar.DATE) + "");
			if(sDay.get(Calendar.MONTH) == date.get(Calendar.MONTH)) {
				((Button) pDate.getComponent(i)).setBackground(Color.pink);
			}else {
				((Button) pDate.getComponent(i)).setBackground(Color.lightGray);
			}
			sDay.add(Calendar.DATE, 1);
		}
		
		/*
		 * 1.시작일(sDay)을 해당 월의 1일이 포함된 일요일로 설정한다. 2.반복문을 사용해서 sDay의 값을 1씩 증가시키면서 버튼에 날짜를
		 * 넣는다. 3.만일 날짜가 해당 월에 속하면 버튼의 배경색을 흰색으로 하고 그렇지 않으면 밝은 회색으로 설정한다.
		 */
	}

	class BtnEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			/*
			 * //라벨에서 년이랑 월을 가져와야한다. how? => split[?년, ?월]로 나온다. //년, 월을 자를거야 subString(0,
			 * length-1) 그다음 int로 바꾸기 String yearStr = lblYearMon.getText().split(" ")[0];
			 * int year = Integer.parseInt(yearStr.substring(0,yearStr.length()-1));
			 * 
			 * String monthStr = lblYearMon.getText().split(" ")[1]; int month =
			 * Integer.parseInt(monthStr.substring(0,monthStr.length()-1)); //이전
			 * if(ae.getActionCommand().equals("◀")) { if(month == 1) { year -= 1; month =
			 * 12; }else { month -= 1; }
			 * 
			 * } else { if(month == 12) { year += 1; month = 1; } else { month += 1; } }
			 * lblYearMon.setText(year + "년 " + month + "월");
			 */

			/*
			 * (1) 아래의 로직에 맞게 코드를 작성하시오. 1. 눌러진 버튼이 btnPrevMon이면, curMon을 한 달 이전으로 변경한다. 2.
			 * 눌러진 버튼이 btnNextMon이면, curMon을 한 달 이후로 변경한다. 3. setDays()를 호출해서 변경된 내용이 레이블에
			 * 보이게 한다.
			 */
			int year = curMon.get(Calendar.YEAR);
			int month = curMon.get(Calendar.MONTH);
			// 이전 버튼
			if (ae.getActionCommand().equals("◀")) {
				// month가 1이면 년도 -1하고 month 12로 바꾼다
				if (curMon.WEEK_OF_MONTH == 1) {
					year -= 1;
					month = 12;
				} else {
					month -= 1;
				}
			} else { // 다음버튼
				// month가 12이면 년도 +1하고 month 1로 바꾼다.
				if (curMon.WEEK_OF_MONTH == 12) {
					year += 1;
					month = 1;
				} else {
					month += 1;
				}
			}
			curMon.set(year, month, Calendar.DATE);
			setDays(curMon);
		}
	}

	public static void main(String[] args) {
		Ex3 mainWin = new Ex3("Scheduler");
	} // main
}
