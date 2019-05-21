package day14;

import java.util.Vector;

public class MyVector {

	/*
	 * Object 배열 objArr을 인스턴스변수로 선언하기
	 */
	public Object[] objArr;
	private int capacity; // 배열크기를 정하는 변수
	private int size; // 실제 값이들어있는 사이즈

	/*
	 * 생성자 MyVector(int capacity)와 기본생성자(capacity == 16)
	 */
	public MyVector() {
		this(16);
	}

	public MyVector(int capacity) {
		// 잘못된 수 입력하면 안돼요
		if (capacity < 1)
			throw new IllegalArgumentException("Illegal Capacity: " + capacity);
		this.capacity = capacity;
		objArr = new Object[capacity];
	}

	// 배열 objArr의 길이를 반환하는 capacity
	public int capacity() {
		return this.capacity;
	}

	// 인스턴스 변수 size 반환하는 메서드
	public int size() {
		return this.size;
	}

	// 객체배열이 비어있는지 확인하는
	public boolean isEmpty() {
		return this.size == 0;
	}

	// objArr에 객체를 추가하는 메서드
	public boolean add(Object obj) {
		// 사이즈가 전체크기와 같아지면
		if (this.size == this.capacity) {
			// 1. 2배크기로 만들기
			Object[] objCopy = new Object[this.capacity * 2];
			// 2. 내용 복사하기
			System.arraycopy(this.objArr, 0, objCopy, 0, this.size);
			// 3. 복사한 배열을 참조하기
			this.objArr = objCopy;
			// 기존배열 null처리 해줘야하나? = > X 메소드 호출 끝나면 자동으로 날라감
		}

		// 사이즈 인덱스에 obj를 추가한다.
		this.objArr[this.size] = obj;
		// 사이즈 증가시키기
		this.size++;
		return true;
	}

	// objArr에 저장된 객체를 반환하는 메서드
	// 0보다 작은값 입력하면 안된다. size이상값 입력하면 안된다.
	public Object get(int index) {
//		if(index < 0 || index >= this.size)
		return this.objArr[index];
	}

	// objArr에 저장된 모든 객체를 몬자열로 이어서 반환하는 메서드
	public String toString() {
		String a = "";
		if (size == 0)
			return "[]";

		for (int i = 0; i < size; i++) {
			a += objArr[i];
			if (i < size - 1)
				a += ", ";
		}

		return "[" + a + "]";
	}

	// objArr에 지정된 객체가 저장되어 있는 위치를 반환하는 메서드
	public int indexOf(Object obj) {
		// size-1까지 검사
		for (int i = 0; i < size; i++) {
			if (this.objArr[i] == obj)
				return i;
		}
		// size까지 return 안했으면 못찾은거
		return -1;
	}

	// objArr에서 지정된 객체를 삭제하는 메서드 => add 반대
	public boolean remove(Object obj) {
		// 배열에 있는지 없는지 찾는다.
		int removeIdx = indexOf(obj);
		// 없으면 리턴 false;
		if (removeIdx == -1)
			return false;

		// 중간요소일때는 그뒤에 요소를 한칸씩 앞으로 당긴다. for문돌때 null처리도 자동으로 됨
		for (int i = removeIdx; i < size; i++) {
			objArr[i] = objArr[i + 1];
//			맨마지막요소라면 null 처리하고 size만 줄이면된다.
//			if (removeIdx == size - 1) {
//				this.objArr[removeIdx] = null;
//			}
		}

		size--;
		return true;

	}
}
