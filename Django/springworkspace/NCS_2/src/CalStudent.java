import java.util.ArrayList;
import java.util.List;

public class CalStudent {

	public static void main(String[] args) {
		List<Student> list = sudentList();
		for (Student x : list) {
			System.out.println(x);
		}
		

	}

	
	public static List<Student> sudentList() {
		List<Student> list = new ArrayList<>();
		String[] sts = {"홍길동1","홍길동2","홍길동3","홍길동4","홍길동5","홍길동6","홍길동7","홍길동8","홍길동9","홍길동10"};
		
		
		for (int i = 0 ;i<sts.length;i++) {
			int kor = (int)(Math.random()*100)+1;
			int eng = (int)(Math.random()*100)+1;
			int math = (int)(Math.random()*100)+1;
			
		//	 List<Student> student = (List<CalStudent.Student>) new Student(sts[i],kor,eng,math);
			
			list.add(new Student(sts[i],kor,eng,math));
		}
		return list;
	}
	
	
	static class Student {
		String name;
		int kor;
		int eng;
		int math;
		double avg;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getKor() {
			return kor;
		}
		public void setKor(int kor) {
			this.kor = kor;
		}
		public int getEng() {
			return eng;
		}
		public void setEng(int eng) {
			this.eng = eng;
		}
		public int getMath() {
			return math;
		}
		public void setMath(int math) {
			this.math = math;
		}
		
		public double getavg() {
			avg = (int)((getKor()+getEng()+getMath())/3.0*100)/100.0;
			
			return avg;
		}
		
		
		public Student(String name, int kor, int eng, int math) {
			super();
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		public Student() {
		}
		@Override
		public String toString() {
			return "Student [GGGname=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", avg=" + getavg() + "]";
		}
		
		
		
		
	}
	
}
