package version1;

import java.util.Scanner;

public class TestCalenda1 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the year:");
		int year = input.nextInt();
		System.out.println("Please input the year's first day week:");
		int first = input.nextInt();
		try{
			(new Calendar1(year, first)).display();	
		}
		catch(YearNumberException ex){
			System.out.println("The year shoulde bigger than 0");
		}
		catch(FirstDayException ex){
			System.out.println("The first day of the year is err");
		}
		input.close();
	}
}
