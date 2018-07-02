package javaBasic;

public class NumberOfDaysAYear {
	public static void main(String[] args){
		for(int i = 0; i <= 10; i++){
			System.out.println((2000 + i) + ": " + numberOfDaysInAYear(2000 + i));		
		}
	}
	
	public static int numberOfDaysInAYear(int year){
		return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 366 : 365;
		/**通过判断平闰年，返回相应的天数*/
	}
}
