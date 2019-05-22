package day15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx3 {
	static HashMap phoneBook = new HashMap();
	
	public static void main(String[] args) {
		addPhoneNo("친구", "이자바", "010-111-1111");
		addPhoneNo("친구", "김자바", "010-222-1111");
		addPhoneNo("친구", "김자바", "010-333-1111");
		addPhoneNo("회사", "김대리", "010-444-1111");
		addPhoneNo("회사", "김대리", "010-555-1111");
		addPhoneNo("회사", "박대리", "010-666-1111");
		addPhoneNo("회사", "이과장", "010-777-1111");
		addPhoneNo("세탁",  "010-888-1111");
		
		printList();
	}
	
	//그룹에 전화번호를 추가하는 메서드
	static void addPhoneNo (String groupName, String name, String tel) {
		addGroup(groupName);                                                                 
		HashMap group = (HashMap)phoneBook.get(groupName);
		group.put(tel, name);  //이름은 중복가능성있어서 번호를 key로한다.
	}
	
	//그룹 추가하는 메서드
	static void addGroup(String groupName) {
		if(!phoneBook.containsKey(groupName))
			phoneBook.put(groupName, new HashMap());
	}
	
	static void addPhoneNo(String name, String tel) {
		addPhoneNo("기타", name, tel);
	}
	
	//전화번호부 전체를 출력하는 메서드
	static void printList() {
		Set set = phoneBook.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			
			Set subSet = ((HashMap)e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();
			
			System.out.println(" * "+e.getKey() + "[" +subSet.size() + "]");
			
			while(subIt.hasNext()) {
				Map.Entry subE = (Map.Entry)subIt.next();
				String telNo = (String)subE.getKey();
				String name = (String)subE.getValue();
				System.out.println(name + " " + telNo);
			}
		}
	}
}
