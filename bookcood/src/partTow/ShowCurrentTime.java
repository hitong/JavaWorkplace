package partTow;

public class ShowCurrentTime {

	public static void main(String[] args) {
		// Obtain the total mill seconds since midnight, jan 1, 1970
		long totalMilliseconds = System.currentTimeMillis();
		
		// Obtain the total seconds since midnight, Jan 1, 1970
		long totalSeconds = totalMilliseconds / 1000;
		
		// Obtain the current second in the minute in the hour
		long currentSeconds = totalSeconds % 60 ;
		
		// Obtain the total minutes
		long totalMinutes = totalSeconds / 60;
		
		// Obtain the current minutes
		long currentMinutes = totalMinutes % 60 ;
		
		// Obtain the total hours
		long totalHours = totalMinutes / 60;
		
		// Obtain the current hours 
		long currentHours = totalHours % 60 ;
		
		//Display results
		System.out.println("Current time is " + 
				currentHours + ":" + currentMinutes + ":" + currentSeconds
				+ " GMT");
	}

}
