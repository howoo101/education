package pr6;

public class Student {
	public String name; 
	public int ban;
	public int no;
	public int kor;
	public int eng;
	public int math;
	
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}

	public Student() {
		
	}

	public int getTotal() {
		return this.kor + this.eng + this.math;
	}
	
	public float getAverage() {
		return (int)(((this.getTotal() / 3f) +0.05f) * 10)/10f;
	}

	public String info() {
		return this.name + "," + this.ban + "," + 
				this.no + "," + this.kor + "," + 
				this.eng + "," + this.math + "," +
				this.getTotal() + "," + this.getAverage();
	}
}
