package partFour;

import java.util.Scanner;

public class Exersicise4point21 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a SSN: ");
		String number = input.next();
		if(number.charAt(3) != '-' || number.charAt(6) != '-'){
			System.out.print(number + " is an invalid social security number");
		}
		else if( number.compareTo("999-99-9999") > 1 
				|| number.compareTo("000-00-0000") < 1){
			System.out.print(number + " is an invalid social security number");
		}
		else if( number.length() != 11)
			System.out.print(number + " is an invalid social security number");
		else
			System.out.print(number + " is an valid social security number");
	}
}
