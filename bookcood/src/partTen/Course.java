package partTen;

public class Course implements Cloneable{
	private String courseName;
	private String[] students ;
	private int numberOfStudents;
	
	public Course(String courseName){
		this.courseName = courseName;
	}
	
	public void addStudent(String student){
		String[] students = new String[numberOfStudents + 1];
		for(int i = 0; i < numberOfStudents ; i++){
			students[i]	= this.students[i].substring(0);
		}
		students[numberOfStudents++] = student;
		this.students = students;
	}
	
	public void clear(){
		String[] students = new String[1];
		numberOfStudents = 0;
		this.students = students;
	}

	public String getCourseName() {
		return courseName;
	}


	public String[] getStudents() {
		return students;
	}


	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	
	public void dropStudent(String student){
		String[] students = new String[numberOfStudents];

		for(int i = 0 ; i < students.length; i++){
			if(student.equals(this.students[i])){
				for(int j = i ; j < students.length - 1; j++)
					students[j] = this.students[j + 1].substring(0);
						
				break;
			}
			
			students[i] = this.students[i].substring(0); 
		}
		this.students = students;
		numberOfStudents--;
	}
	
	public Object clone() throws CloneNotSupportedException{	
		Course one = (Course)super.clone();
		return one;
	}
}
