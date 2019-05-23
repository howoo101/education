package pr11;

import java.util.ArrayList;
import java.util.Iterator;
/*
 * 정수집합 (1,2,3,4) (3,4,5,6)의  교 차 합 집합을 구하는 코드
 * addAll() removeAll() retainAll()을 사용하라
 */
public class Exercise11_1 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		ArrayList kyo = new ArrayList(); //교집합
		ArrayList cha = new ArrayList(); //차집합
		ArrayList hap = new ArrayList(); //합집합
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);

		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		//합집합은 list1에다가 list1과 list2의 차집합을 더한다.
		hap.addAll(list1);
		hap.removeAll(list2);
		hap.addAll(list2);
		
		//차집합은 list1에서 list2를 다 빼면된다.
		cha.addAll(list1);
		cha.removeAll(list2);
		
		//교집합은 list1에서 list2에 포함되는것만 더한다. 
		kyo.addAll(list1);
		kyo.retainAll(list2);
		
		
		
		System.out.println("list1="+list1);
		System.out.println("list2="+list2);
		System.out.println("kyo="+kyo);
		System.out.println("cha="+cha);
		System.out.println("hap="+hap);
	}
}
