package pr11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class BanNoAscending implements Comparator {
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Student && o2 instanceof Student)
			// 반이 크면 큰거        반이 같은데 번호가 크면 큰거
			if(((Student) o1).ban > ((Student) o2).ban)
				return 1;
			if(((Student) o1).ban == ((Student) o2).ban)
				if(((Student) o1).no > ((Student) o2).no)
					return 1;
			return -1;
	}
}

/*
 * ArrayList에 담긴 Student인스턴스들이 반과 번호로 오름차순 정렬 반이 같은경우 번호를 비교해서 정렬한다.
 */
public class Exercise11_7 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("이자바", 2, 1, 70, 90, 70));
		list.add(new Student("안자바", 2, 2, 60, 100, 80));
		list.add(new Student("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student("김자바", 1, 2, 80, 80, 90));

		Collections.sort(list, new BanNoAscending());

		Iterator it = list.iterator();

		while (it.hasNext())
			System.out.println(it.next());
	}
}
