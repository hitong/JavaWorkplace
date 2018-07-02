package version1;

public class Calendar1 {
	private int year;
	private int firstDay;
	private boolean isLeap;
	
	private final static String[] Week = {
		 "SUN ","MON ", "TUE ", "WED ",
		 "THU ", "FRI ", "SAT "
	};
	
	public Calendar1(int year, int firstDay) 
			throws FirstDayException,YearNumberException{
		if(year > 0){
			this.year = year;
			isLeap = this.isLeap(year);
		}
		else
			throw new YearNumberException();
		
		if(firstDay == this.computeTheFisrtDay(year)){
			this.firstDay = firstDay;
		}
		else
			throw new FirstDayException();
	}
	
	public int computeTheFisrtDay(int year){
		int firstDay = 1;
		for(int i = 1; i < year; i++){
			int day = 0;
			if(isLeap(i)){
				day = 366;
			}
			else{
				day = 365;
			}
			firstDay = (day + firstDay) % 7;
		}
	
		return firstDay == 0 ? 7 : firstDay;
	}
	
	boolean isLeap(int year){
		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
			return true;
		else
			return false;
	}
	
	public void display(){
		int temp = firstDay;
		for(int i = 0; i < 12; i++){			
			System.out.println((i+1));
				for(int k = 0; k < 7; k++){
					System.out.printf("%s", Week[k]);
				}
				System.out.println();	
			
			for(int k = 0; k < (temp % 7); k++){
				System.out.print("    ");
			}
			
			if(i < 7){
				for(int k = 1; k <= (31 - (i % 2)); k++){
					System.out.printf("%2d  ", k);
					temp++;
					if(temp % 7 == 0){
						System.out.println();
					}
					if(i == 1 && isLeap && k == 29)
						break;	
					else if(i == 1 && !isLeap && k == 28)
						break;
				}
			}
			else{
				for(int k = 1; k <= (30 + (i % 2)); k++){
					System.out.printf("%2d  ", k);
					temp++;
					if(temp % 7 == 0){
						System.out.println();
					}					
				}
			}
			
			System.out.println();
			System.out.println();
		}			
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getFirstDay() {
		return firstDay;
	}

	public void setFirstDay(int firstDay) {
		this.firstDay = firstDay;
	}

	public boolean isLeap() {
		return isLeap;
	}

	public void setLeap(boolean isLeap) {
		this.isLeap = isLeap;
	}

}

@SuppressWarnings("serial")
class YearNumberException extends Exception{
	public String toString(){
		return "Year number should biger than ZERO";
	}
}
@SuppressWarnings("serial")
class FirstDayException extends Exception{
}