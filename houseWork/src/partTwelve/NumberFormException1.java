package partTwelve;

import java.util.*;

public class NumberFormException1 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		do{
			try{
				String[] string = new String[3];
				string[0] = input.next();
				string[1] = input.next();
				string[2] = input.next();
				Calculator.main(string);
			}
			catch(NumberFormatException ex){		
				System.out.println("Wrong input: " +
				ex.getMessage().substring(18));
			}
		}while(true);
	}
}
/**
public class NumberFormException1 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		do{
			
				String[] string = new String[3];
				string[0] = input.next();
				string[1] = input.next();
				string[2] = input.next();
				Calculator.main(string);		
		}while(true);
	}
}

*/
