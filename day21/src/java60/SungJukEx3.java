package java60;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * [문제3] list를 다양한 기준으로 정렬하기 위해 Comaprator를 구현한 클래스를 구현하세요.
           ClassTotalComparator - 반별로 총점이 높은 순에서 낮은 순으로 정렬(반은 오름차순, 총점은 내림차순)
           ClassStudentNo - 반, 번호 순으로 내림차순 정렬
 */
public class SungJukEx3 { 
    public static void main(String[] args) { 
        ArrayList<Student> list = new ArrayList<Student>(); 

         // 이름, 반, 번호, 국어, 수학, 영어 
        list.add(new Student("남궁성", 3,2,100,100,100)); 
        list.add(new Student("왕자바", 3,1,90,100,80)); 
        list.add(new Student("자바왕", 3,3,70,100,100)); 
        list.add(new Student("킹왕짱", 1,2,100,60,90)); 
        list.add(new Student("자바짱", 1,1,100,100,100)); 
        list.add(new Student("최고수", 1,3,100,80,60)); 
        list.add(new Student("홍길동", 2,1,50,80,100)); 
        list.add(new Student("일지매", 2,3,70,80,100)); 
        list.add(new Student("변강쇠", 2,4,80,80,85)); 
        list.add(new Student("이원구", 2,2,90,90,90)); 

        System.out.println("[반별 총점높은 순으로 정렬]"); 
        Collections.sort(list, new ClassTotalComparator()); // 반, 총점 순으로 정렬 
        printList(list); 

        System.out.println(); 

        System.out.println("[반, 번호 순으로 정렬]"); 
        Collections.sort(list, new ClassStudentNoComparator()); // 반, 번호 순으로 정렬 
        printList(list); 
  } 

  public static void printList(List<Student> list) { 
        System.out.println("이름\t학년\t반\t국어\t수학\t영어\t총점 "); 
        System.out.println("===================================================="); 

        for(Student s : list) { 
              System.out.println(s); 
        } 

        System.out.println("===================================================="); 
  } 
} 

//class Student implements Comparable<Student> { 
//  String name = ""; 
//  int classNo = 0; 
//  int studentNo = 0; 
//  int koreanScore = 0; 
//  int mathScore = 0; 
//  int englishScore = 0; 
//
//  int total = 0; 
//
//  Student(String name, int classNo, int studentNo, int koreanScore, int mathScore, int englishScore) { 
//        this.name = name; 
//        this.classNo = classNo; 
//        this.studentNo = studentNo; 
//        this.koreanScore = koreanScore; 
//        this.mathScore = mathScore; 
//        this.englishScore = englishScore; 
//
//        total = koreanScore + mathScore + englishScore; 
//  } 
//
//  public String toString() { 
//        return name + "\t" 
//              + classNo + "\t" 
//              + studentNo + "\t" 
//              + koreanScore + "\t" 
//              + mathScore + "\t" 
//              + englishScore + "\t" 
//              + total + "\t"; 
//  } 
//
//  public int compareTo(Student obj) { 
//        return obj.total - this.total; 
////         return this.name.compareTo(obj.name); // 이름기준으로 오름차순 정렬 
//  } 
//
///* 제네릭스(Generics) 사용하지 않은 버젼 
//  public int compareTo(Object obj) { 
//        int result = -1; 
//
//        if(obj instanceof Student) { 
//              Student tmp = (Student)obj; 
//
//              result = tmp.total - this.total; 
//        } 
//
//        return result; 
//  } 
//*/ 
//} // end of class Student 
//
////반별 총점 높은순
//class ClassTotalComparator implements Comparator<Student> { 
//  public int compare(Student s1, Student s2) { 
//	  //반은 오름차순 점수는 내림차순인데
//	  //반이같은데 점수가 높으면 1 낮으면 -1 
//	  //다른상황에서 반이 높으면 1 낮으면 -1
//	  
//	  if(s1.classNo==s2.classNo)  // 반이 같다면
//		   return s1.total - s2.total;  //점수로 비교
//	  
//	  return s1.classNo - s2.classNo;  
//	  
////	return s1.classNo == s2.classNo ? (s1.total < s2.total ? 1 : -1) : (s1.classNo > s2.classNo ? 1 : -1);
//  } 
//} 
////반이 우선 번호순 오름차순
//class ClassStudentNoComparator implements Comparator<Student> { 
//  public int compare(Student s1, Student s2) { 
//	  
//	  if(s1.classNo == s2.classNo)  // 반이 같으면
//		  return s1.studentNo - s2.studentNo;
//	  
//	  return s1.classNo - s2.classNo; 
////	  return s1.classNo == s2.classNo ? (s1.studentNo > s2.studentNo ? 1 : -1) : (s1.classNo > s2.classNo ? 1 : -1);
//  } 
//}
