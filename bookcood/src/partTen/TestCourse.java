package partTen;

import java.util.Scanner;
public class TestCourse {
	public static void main(String[] args) throws CloneNotSupportedException{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the course's name:");
		String course = input.nextLine();
		Course studentAndCourse = new Course(course);
		
		
		System.out.print("Input the first student's name:");
		studentAndCourse.addStudent(input.next());
		System.out.print("Input the second student's name:");
		studentAndCourse.addStudent(input.next());
		System.out.print("Input the last student's name:");
		studentAndCourse.addStudent(input.next());
		
		String[] students = studentAndCourse.getStudents();
		Course clone = (Course)(studentAndCourse.clone());
		
		for(int i = 0; i < studentAndCourse.getNumberOfStudents(); i++)
			System.out.println(students[i]);
		
		
		System.out.println(clone.getCourseName());
		System.out.print("Drop Who?  ");
		
		clone.dropStudent(input.next());
		
		String[] students2 = clone.getStudents();
		String[] s = studentAndCourse.getStudents();
		for(int i = 0; i < clone.getNumberOfStudents(); i++)
			System.out.println(students2[i]);
		for(int j = 0; j < studentAndCourse.getNumberOfStudents(); j++)
				System.out.println(s[j]);
		
		input.close();
		
	}
}
