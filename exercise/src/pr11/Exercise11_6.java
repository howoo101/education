package pr11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * TreeSet이 학생들의 평균을 기준으로 정렬하도록 compare(Object o1, Object o2)와
 * 평균점수의 범위를 주면 해당 범위에 속한 학생 수를 반환하는 메서드 완성하기 getGroupCount()
 */
public class Exercise11_6 {
	static int getGroupCount(TreeSet test, int from, int to) {
		//from과 비교해서 1이 나오고 to+1과 비교해서 -1이 나올때  그범위 안에 들어 올 수 있다고 할 수 있다.
		int count = 0;
		Iterator it = test.iterator();
		TreeSet tmp = new TreeSet();
		Student a = null;
		while(it.hasNext()) {
			a = (Student)(it.next());
			tmp.add((int)a.getAverage());
			
		}
//			System.out.println(tmp.subSet(from, to));
		return tmp.subSet(from, to).size();
	}
	public static void main(String[] args) {
		TreeSet set = new TreeSet(new Comparator() {
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Student && o2 instanceof Student) {
					return ((Student)o1).getAverage() == ((Student)o2).getAverage()
							? 0 : ((Student)o1).getAverage() > ((Student)o2).getAverage()
									? 1 : -1;
				}else {
					return -1;
				}
			}
		});
		
		set.add(new Student("홍길동",1,1,100,100,100));
		set.add(new Student("남궁성",1,2,90,70,80));
		set.add(new Student("김자바",1,3,80,80,90));
		set.add(new Student("이자바",1,4,70,90,70));
		set.add(new Student("안자바",1,5,60,100,80));
		
		Iterator it = set.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
		
		System.out.println("[60~69] : "+getGroupCount(set,60,70));
		System.out.println("[70~79] : "+getGroupCount(set,70,80));
		System.out.println("[80~89] : "+getGroupCount(set,80,90));
		System.out.println("[90~109] : "+getGroupCount(set,90,101));
	}
}
