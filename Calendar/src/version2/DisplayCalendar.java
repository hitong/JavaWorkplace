package version2;


import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Calendar;


public class DisplayCalendar{
	private static String[] Week = {
		 "SUN ","MON ", "TUE ", "WED ",
		 "THU ", "FRI ", "SAT "
	};
	
	public static void main(String[] args){
		int year;
		int month;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please input year and month(eg:2017 7):");
		year = input.nextInt();
		month = input.nextInt();
		
		input.close();
		printMonth(year , month);
		
		Calendar date = Calendar.getInstance();
        String y = String.valueOf(date.get(Calendar.YEAR));
		
        System.out.println();
		printMonth(Integer.parseInt(y), month);
	}
	
	static void printMonth(int year, int month){
		printMonthTitle(year, month);
		GregorianCalendar g = new GregorianCalendar(year, month-1, 1);
		printMonthBody(g.get(Calendar.DAY_OF_WEEK) - 1, g.getActualMaximum(Calendar.DAY_OF_MONTH));
	}
	
	static int getStartDay(){	
		return -1;
	}
	
	static void printMonthBody(int startDay, int numOfDaysInMonth){	
		startDay = startDay % 7;
		for(int k = 0; k < 7; k++){
			System.out.printf("%s", Week[k]);
		}
		System.out.println();
		
		for(int k = 0; k < startDay; k++){
			System.out.print("    ");
		}

		for(int k = 1; k <= numOfDaysInMonth; k++){
			System.out.printf("%2d  ", k);
			startDay++;
			if(startDay % 7 == 0){
				System.out.println();
			}
		}				
	}
	
	
	static void printMonthTitle(int year, int month){
		System.out.println(year + "/" + month);
		System.out.println("=============================");
	}
	
}

