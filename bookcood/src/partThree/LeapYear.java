package partThree;

import java.util.Scanner;

public class LeapYear {
	public static void main(String[] args) {
		//Create a Scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a year: ");
		int year = input.nextInt();
		
		//Check if the year is a leap year 
		boolean isLeapYear = 
				(year % 4 ==0 && year % 400 != 0 || (year % 400 == 0));
		
		//Display result
		System.out.println(year + " is a lear year? " + isLeapYear);
		input.close();
	}

}