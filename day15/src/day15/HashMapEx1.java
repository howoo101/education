package day15;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx1 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("myId", "1234");
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("id와 password를 입력해주세요");
			System.out.print("id : ");
			String id = s.nextLine().trim();
			
			System.out.print("password :");
			String password = s.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) {
				System.out.println("입력하신 아이디는 존재하지않습니다." + " 다시 입력해주세요");
				continue;
			} else {
				if(!(map.get(id)).equals(password)) {
					System.out.println("비밀번호 노 일치 다시 입력");
				} else {
					System.out.println("일치합니다.");
					break;
				}
			}
		}
	}
}
