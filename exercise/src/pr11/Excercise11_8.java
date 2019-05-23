package pr11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/*
 * Student 클래스의 기본정렬을 이름아닌 총점 기준으로 내림차순 한 뒤,
 * 총점을 기준으로 각 학생의 전교등수를 계산하고  전교등수를 기준으로 
 * 오름차순 정렬하여 출력하시오
 */
public class Excercise11_8 {
	public static void calculateSchoolRank(List list) {
		Collections.sort(list); //먼저 list를 총점기준 내림차순 정렬한다.
	
		int prevRank = -1; //이전 전교등수
		int prevTotal = -1; //이전 총점
		int length = list.size();
		
		
		Iterator it = list.iterator();
		
//		1. 반복문을 이용해서 list에 저장된 Student 객체를 하나씩 읽는다.
		while(it.hasNext()) {
			length++;
			Student tmp = (Student) it.next();
			if(length == list.size()+1) {
				prevRank = 1;
				tmp.schoolRank = prevRank;
				prevTotal = tmp.total;
				tmp.total = prevTotal;
				continue;
			}
			System.out.println("prevTotal: "+prevTotal);
			System.out.println("prevRank: "+prevRank);
			//1.1 총점 (total)이 이전총점(prevTotal)과 같으면
			if(tmp.total == prevTotal) {
				System.out.println("tmp == prev");
//				 이전 등수 (prevRank)를 등수(schoolRank)로 한다.
				tmp.schoolRank = prevRank;
				prevRank++;
			} else {//			1.2 총점이 서로 다르면,등수(shcoolRank)의 값을 알맞게 계산해서 저장한다.
				if(tmp.total > prevTotal) { // 비교점수가 이전점수보다 클때
					System.out.println("tmp > prev");
					prevRank++;
					tmp.schoolRank = prevRank;
					for(int i = 0; i < list.indexOf(tmp.total); i++) {
						System.out.println(i);
						tmp = (Student) list.get(i);
						if(tmp.schoolRank == prevRank) {
							tmp.schoolRank = prevRank+1; //1등 더한걸 이전점수를 가진 것들에게 반영							
						}
					}
				}
				else { // 비교점수가 이전점수보다 작을때
					System.out.println("tmp < prev");
					prevRank++;
					tmp.schoolRank = prevRank;
					prevTotal = tmp.total;
				}
//				이전에 동점자 였다면, 그 다음 등수는 동점자의 수를 고려해야 한다.
					
			}
		}
//			1.3 현재 총점과 등수를 이전총점(prevTotal) 과 이전등수(prevRank)에 저장
	}
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("이자바",2,1,70,90,70));
		list.add(new Student("안자바",2,2,60,100,80));
		list.add(new Student("홍길동",2,1,100,100,100));
		list.add(new Student("남궁성",2,1,90,70,80));
		list.add(new Student("김자바",1,2,80,80,90));
//		list.add(new Student("김자바",1,2,80,80,90));
		
		calculateSchoolRank(list);
		
		Iterator it = list.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
	}
}
