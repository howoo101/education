package day15;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class QueueEx1 {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5; // queue에 최대 5개까지만 저장되도록 한다.
	
	public static void main(String[] args) {

		System.out.println("help시 도움말");
		
		while(true) {
			System.out.println(">>");
			try {
				//화면으로부터 라인단위로 입력받는다.
				Scanner s = new Scanner(System.in);
				String input = s.nextLine().trim();
				
				if("".equals(input)) continue;
				
				if(input.equalsIgnoreCase("q")) {
					System.exit(0);
				} else if(input.equalsIgnoreCase("help")) {
					System.out.println("help - help");
					System.out.println("q - exit");
					System.out.println("history - 최근명령어" + MAX_SIZE);
				} else if (input.equalsIgnoreCase("history")) {
					int i = 0;
					//입력받은 명령어를 저장하고,
					save(input);
					
					//LinkedList의 내용을 보여준다.
					LinkedList tmp = (LinkedList)q;
					ListIterator it = tmp.listIterator();
					
					while(it.hasNext())
						System.out.println(++i+"."+it.next());
				} else {
					save(input);
					System.out.println(input);
				}
			} catch(Exception e) {
				System.out.println("입력오류입니다.");
			}
		}
	}
	
	public static void save(String input) {
		//queue에 저장한다.
		if(!"".equals(input))
			q.offer(input);
		//queue의 최대크기를 넘으면 제일 처음 입력된 것을 삭제한다.
		if(q.size() > MAX_SIZE)  //size()는 Collection인터페이스에 정의
			q.remove();
	}
}
