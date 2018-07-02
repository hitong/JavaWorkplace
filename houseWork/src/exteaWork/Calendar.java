package exteaWork;

public class Calendar {
	private static String[] Week = {
		 "SUN ","MON ", "TUE ", "WED ",
		 "THU ", "FRI ", "SAT "
	};
	
	
	public Calendar(int year){
		display(computeTheFisrtDay(year),isLeap(year));
	}
	
	
	
	boolean isLeap(int year){
		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
			return true;
		else
			return false;
	}
	
	int computeTheFisrtDay(int year){
		int firstDay = 1;
		for(int i = 1; i < year; i++ ){
			int day = 0;
			if(isLeap(i)){
				day = 366;
			}
			else{
				day = 365;
			}
			firstDay = (day + firstDay) % 7;
		}
		return firstDay;
	}
	
	private void display(int firstDay, boolean leap){
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
						if(i == 1 && leap && k == 29)
							break;	
						else if(i == 1 && !leap && k == 28)
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
}


