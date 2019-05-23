package pr11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class Student implements Comparable{
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	//11_8
	int total; //총점
	int schoolRank;  //전교등수
	
	//11_9
	int classRank; // 반등수
	
	
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		total = kor+eng+math;
	}
	
	int getTotal() {
		return total;
	}
	
	float getAverage() {
		return (int)((getTotal() / 3f)*10 + 0.5)/10f;
	}
	
//	ban + "," + no + "," + kor + "," + eng+ "," + math
//	+ "," + getTotal() + "," +
	public String toString() {
		return name + "," +  getAverage() + ",   "+schoolRank + ", " + classRank;
	}

	@Override
	//11-5
//	public int compareTo(Object o) {
//			if(o instanceof Student)
//					return (this.name).compareTo(((Student)o).name);
//			return -1;
//	}
	
	//11-5
//	public int compareTo(Student another) {
//		String thisVal = this.name;
//		String anotherVal = another.name;
//		
//		return thisVal.compareTo(anotherVal);
//	}
	
	//11-8
	public int compareTo(Object o) {
		if(o instanceof Student)
			return this.total == ((Student)o).total ? 0 
							: (this.total < ((Student)o).total ? 1 : -1);
		return -1;
	}
}

public class Exercise11_5 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("이자바",2,1,70,90,70));
		list.add(new Student("안자바",2,2,60,100,80));
		list.add(new Student("홍길동",1,3,100,100,100));
		list.add(new Student("남궁성",1,1,90,70,80));
		list.add(new Student("김자바",1,2,80,80,90));
		

//		Collections.sort(list);
		Iterator it = list.iterator();
		
		
		while(it.hasNext())
			System.out.println(it.next());
	}
}
