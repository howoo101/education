package day15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapEx4 {
	public static void main(String[] args) {
		String[] data = {"A","K","A","K","D","K","A","K","K","K","Z","D" };
		
		HashMap map = new HashMap();
		
		for(int i = 0; i < data.length; i++) {
			if(map.containsKey(data[i])) { // 있으면 키에대한 value를 찾아서 +1해서 다시 넣는다.
				Integer value = (Integer)map.get(data[i]);
				map.put(data[i], value + 1);
			}else { //없으면 키로 해당값 넣고 value로 1넣는다.
				map.put(data[i], new Integer(1));
			}
		}
		System.out.println(map.entrySet());
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
		}
	}
	
	public static String printBar(char ch, int value) {
		char[] bar = new char[value];
		
		for(int i = 0; i < bar.length; i++)
			bar[i] = ch;
		
		return new String(bar); // String(char[] chArr)
	}
}
